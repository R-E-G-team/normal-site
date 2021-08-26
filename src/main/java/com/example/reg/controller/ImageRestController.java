package com.example.reg.controller;

import com.example.reg.util.DetectLabels;
import com.example.reg.util.DetectProperties;
import com.example.reg.util.DetectText;
import com.example.reg.util.DetectTextSpeech;
import com.google.type.Color;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@RestController
public class ImageRestController {

    @RequestMapping("/text_to_speech")
    public String textToSpeech(HttpServletRequest request, Model model, String filePath) {
        String path = System.getProperty("user.dir");
        path += "/src/main/resources";
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
    public List<String> componentToSpeech(HttpServletRequest request, Model model, String filePath) {
        String path = System.getProperty("user.dir");
        path += "/src/main/resources";
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
