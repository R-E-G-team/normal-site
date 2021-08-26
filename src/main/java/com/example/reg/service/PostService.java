package com.example.reg.service;

import com.example.reg.dto.Post;
import com.example.reg.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public interface PostService {

    Post loadPostByPostId(Long id);

    List<Post> getPostList();

    void postInsert(HttpSession session, Post post) throws IOException;
}
