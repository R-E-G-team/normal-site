package com.example.reg.service;

import com.example.reg.dto.Post;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLTransientException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public interface PostService {

    Post loadPostByPostId(Long id);

    List<Post> getPostList();

    void postInsert(HttpSession session, Post post) throws IOException;
}
