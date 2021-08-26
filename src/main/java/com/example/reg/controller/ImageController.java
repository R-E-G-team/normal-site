package com.example.reg.controller;

import com.example.reg.dto.Post;
import com.example.reg.repository.GoodsRepository;
import com.example.reg.repository.PostRepository;
import com.example.reg.util.DetectProperties;
import com.example.reg.util.DetectText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@Controller
public class ImageController {

    private final GoodsRepository goodsRepository;

    private final PostRepository postRepository;

    public ImageController(PostRepository postRepository, GoodsRepository goodsRepository) {
        this.postRepository = postRepository;
        this.goodsRepository = goodsRepository;
    }

    @RequestMapping("/text_to_braille")
    public String textToBraille(Model model, HttpServletRequest request, HttpSession session) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources") + "/";
        Post post = postRepository.findById(Long.parseLong(request.getParameter("postNo"))).orElse(null);
        path += post.getPostImagePath();
        Map<String, int[]> map = new LinkedHashMap<>();
        try {
            map = DetectText.detectText(path);
        } catch (IOException e) {
            model.addAttribute("error", "error");
            return "main/braille";
        }
        Map.Entry entry = map.entrySet().iterator().next();
        String key = (String) entry.getKey();
        map.remove(key);
        model.addAttribute("map", map);
        return "main/braille";
    }

    @RequestMapping("/what_color")
    public String whatColor(Model model, String goodsNo, HttpSession session) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources") + "/";
        String filePath = goodsRepository.findById(Long.parseLong(goodsNo)).orElse(null).getGoodsImagePath();
        path += filePath;
        Map<Float, String> map = new HashMap<>();
        List<Float> keySet = new ArrayList<>();
        List<String> hax = new ArrayList<>();
        try {
            map = DetectProperties.detectProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Float key : map.keySet()){
            keySet.add(key);
            hax.add(map.get(key));
        }
        model.addAttribute("percent", keySet);
        model.addAttribute("hax", hax);
        return "templates/color";
    }
}
