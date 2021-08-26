package com.example.reg.controller;

import com.example.reg.util.DetectProperties;
import com.example.reg.util.DetectText;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class ImageController {

    @RequestMapping("/text_to_braille")
    public String textToBraille(Model model, String filePath) {
        String path = System.getProperty("user.dir");
        path += "/src/main/resources";
        path += filePath;
        Map<String, int[]> map = new LinkedHashMap<>();
        try {
            map = DetectText.detectText(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map.Entry entry = map.entrySet().iterator().next();
        String key = (String) entry.getKey();
        map.remove(key);
        model.addAttribute("map", map);
        return "braille";
    }

    @RequestMapping("/what_color")
    public String whatColor(Model model, String filePath) {
        String path = System.getProperty("user.dir");
        path += "/src/main/resources";
        path += filePath;
        Map<Float, String> map = new HashMap<>();
        List<Float> keySet = new ArrayList<>();
        List<String> hax = new ArrayList<>();
        try {
            map = DetectProperties.detectProperties(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Float key : map.keySet()){
            keySet.add(key);
            hax.add(map.get(key));

        }
        model.addAttribute("percent", keySet);
        model.addAttribute("hax", hax);
        return "templates/color";
    }
}
