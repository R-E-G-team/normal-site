package com.example.reg.dto;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "goods_no_seq")
    @SequenceGenerator(sequenceName = "goods_no_seq", allocationSize = 1, name = "goods_no_seq" )
    private Long goodsNo;
    private String goodsImagePath;
    private String goodsTitle;
    private int goodsPrice;
    private String goodsContent;
    private String detailImagePath;

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public Long getGoodsNo() {
        return goodsNo;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public String getDetailImagePath() {
        return detailImagePath;
    }
}
