package com.example.reg.controller;

import com.example.reg.dto.Post;
import com.example.reg.service.PostService;
import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping("/templates/blog")
    public void blog(Model model) {
        List<Post> postList = postService.getPostList();
        model.addAttribute("postList", postList);
    }

    @RequestMapping("/templates/blog_details")
    public void blogDetails(Model model, HttpServletRequest request) {
        Long postNo = Long.parseLong(request.getParameter("postNo"));
        model.addAttribute("post", postService.loadPostByPostId(postNo));
    }

    @RequestMapping("/templates/write_form")
    public String writeForm() {
        return "/templates/blog_write";
    }

    @RequestMapping("/post_insert")
    public String postInsert(HttpSession session, Post post) {
        System.out.println("controller");
        try {
            postService.postInsert(session, post);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/templates/blog";
    }

    @RequestMapping("/download")
    public static boolean doFileDownload(
            HttpServletResponse response, String filename,
            String originalFileName,
            HttpSession session) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources");
        try {
            String fullPath = path + File.separator + filename;

            if(originalFileName==null||originalFileName.equals("")) {

                originalFileName = filename;
            }

            // 한글이름 파일을 다운받을때 깨짐 방지
            originalFileName = new String(
                    originalFileName.getBytes("euc-kr"),"ISO-8859-1"); // 이렇게 써줘도 됨 8859_1

            File f = new File(fullPath);

            if(!f.exists())
                return false;

            // 파일을받는건 response로 처리해주면 됨
            response.setContentType("application/octet-stream");  // 공식
            response.setHeader("Content-disposition",
                    "attachment;fileName="+originalFileName);
            // 받은 파일의 header에 딸려있는 파일의 이름을 지정해준 것


            //파일은 서버에 저장돼있음
            //서버에있는 파일을 내보내려면 일단 "먼저 파일을 읽어내서" 내보내야함
            BufferedInputStream bis =
                    new BufferedInputStream(new
                            FileInputStream(f));

            // 읽어들인 파일을 "출력"한다
            OutputStream out = response.getOutputStream();

            int data;
            byte[] bytes = new byte[4096]; //4096 byte만큼 읽어서 클라이언트한테 내보낼것임

            while((data=bis.read(bytes,0,4096))!=-1) {//0~4096까지 읽어서 data에 넣을것임

                out.write(bytes,0,data); //0~data의size까지 내보낼것임

            }

            out.flush();
            out.close();
            bis.close(); // 사용한 메소드는 다 닫아주기


        } catch (Exception e) {
            return false; //에러가 나면 false값 리턴
        }

        return true; //정상 실행 시
    }
}
