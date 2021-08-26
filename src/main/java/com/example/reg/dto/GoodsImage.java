package com.example.reg.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GoodsImage {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_no_seq")
    @SequenceGenerator(sequenceName = "image_no_seq", allocationSize = 1, name = "image_no_seq" )
    private Long imageNo;
    private String imagePath;
    private Long goodsNo;
}
