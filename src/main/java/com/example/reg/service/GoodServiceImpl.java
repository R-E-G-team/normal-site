package com.example.reg.service;

import com.example.reg.dto.Goods;
import com.example.reg.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GoodServiceImpl implements GoodsService{

    private final GoodsRepository goodsRepository;

    public GoodServiceImpl(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @Override
    public List<Goods> getGoodsList() {
        return goodsRepository.findAll();
    }

    @Override
    public Goods getGoods(Long goodsNo) {
        return goodsRepository.findById(goodsNo).orElse(null);
    }
}
