package com.example.reg.service;

import com.example.reg.dto.Post;
import com.example.reg.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post loadPostByPostId(Long id) {
        Post post = postRepository.getById(id);
        return post;
    }

    @Override
    public List<Post> getPostList() {
        return postRepository.findAll();
    }

    @Override
    public void postInsert(HttpSession session, Post post) throws IOException {
        MultipartFile file = post.getFile();
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources");
        String fileName = file.getOriginalFilename();
        post.setPostImagePath(fileName);
        file.transferTo(new File(path+"/"+fileName));
        postRepository.save(post);

    }
}
