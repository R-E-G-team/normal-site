package com.example.reg.controller;

import com.example.reg.dto.Goods;
import com.example.reg.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class GoodsController {

    private final GoodsService goodsService;

    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/templates/shop")
    public void shop(Model model) {
        List<Goods> goodsList = goodsService.getGoodsList();
        model.addAttribute("goods", goodsList.get(0));
        model.addAttribute("goodsList", goodsList);
    }

    @RequestMapping("/templates/shop_details")
    public void shopDetails(Model model, HttpServletRequest request) {
        Long goodsNo = Long.parseLong(request.getParameter("goodsNo"));
        Goods goods = goodsService.getGoods(goodsNo);
        model.addAttribute("goods", goods);
    }
}
