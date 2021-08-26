package com.example.reg.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_no_seq")
    @SequenceGenerator(sequenceName = "post_no_seq", allocationSize = 1, name = "post_no_seq")
    private Long postNo;
    private String postTitle;
    private String postContent;
    private String postImagePath;

    @Transient
    private MultipartFile file;

    public Long getPostNo() {
        return postNo;
    }

    public String getPostContent() {
        return postContent;
    }

    public String getPostImagePath() {
        return postImagePath;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public void setPostNo(Long postNo) {
        this.postNo = postNo;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public void setPostImagePath(String postImagePath) {
        this.postImagePath = postImagePath;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}
