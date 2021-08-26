package com.example.reg.controller;

import com.example.reg.repository.GoodsRepository;
import com.example.reg.util.DetectLabels;
import com.example.reg.util.DetectProperties;
import com.example.reg.util.DetectText;
import com.example.reg.util.DetectTextSpeech;
import com.google.type.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@RestController
public class ImageRestController {

    @Autowired
    private GoodsRepository goodsRepository;

    @RequestMapping("/text_to_speech")
    public String textToSpeech(HttpSession session, Model model, String goodsNo) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources") + "/";
        String filePath = goodsRepository.findById(Long.parseLong(goodsNo)).orElse(null).getDetailImagePath();
        path += filePath;
        String text = "";
        try {
            text = DetectTextSpeech.detectTextSpeech(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

    @RequestMapping("/component_to_speech")
    public List<String> componentToSpeech(HttpSession session, Model model, String goodsNo) {
        ServletContext application = session.getServletContext();
        String path = application.getRealPath("/resources") + "/";
        String filePath = goodsRepository.findById(Long.parseLong(goodsNo)).orElse(null).getGoodsImagePath();
        path += filePath;
        List<String> list = new ArrayList<>();
        try {
            list = DetectLabels.detectLabels(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
