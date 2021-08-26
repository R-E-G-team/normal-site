package com.example.reg.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_no_seq")
    @SequenceGenerator(sequenceName = "post_no_seq", allocationSize = 1, name = "post_no_seq" )
    private Long postNo;
    private String postTitle;
    private String postContent;
    private String postImagePath;
}
