package com.example.reg.service;

import com.example.reg.dto.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> getGoodsList();

    Goods getGoods(Long goodsNo);
}
