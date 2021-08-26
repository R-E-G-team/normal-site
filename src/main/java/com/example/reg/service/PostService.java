package com.example.reg.service;

import com.example.reg.dto.Post;
import com.example.reg.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post loadPostByPostId(Long id) {
        Post post = postRepository.getById(id);
        return post;
    }
}
