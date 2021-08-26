package com.example.reg.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_no_seq")
    @SequenceGenerator(sequenceName = "goods_no_seq", allocationSize = 1, name = "goods_no_seq" )
    private Long goodsNo;
    private String goodImagePath;
    private String goodsTitle;
    private String goodsContent;
}
