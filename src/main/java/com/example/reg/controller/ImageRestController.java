package com.example.reg.controller;

import com.example.reg.util.DetectLabels;
import com.example.reg.util.DetectText;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImageRestController {

    @RequestMapping("/text_to_speech")
    public String textToSpeech(HttpServletRequest request, Model model, String filePath) {
        String path = System.getProperty("user.dir");
        path += "/src/main/resources";
        path += filePath;
        Map<String, int[]> map = new LinkedHashMap<>();
        try {
            map = DetectText.detectText(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("map", map);
        Map.Entry entry = map.entrySet().iterator().next();
        String key = (String) entry.getKey();
        model.addAttribute("info", key);
        return key;
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
        model.addAttribute("list", list);
        return list;
    }
}
