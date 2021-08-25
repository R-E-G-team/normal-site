package com.example.reg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/templates")
public class TemplatesController {

    @RequestMapping("/about")
    public void about() {}

    @RequestMapping("/blog")
    public void blog() {}

    @RequestMapping("/blog_details")
    public void blogDetails() {}

    @RequestMapping("/checkout")
    public void checkout() {}

    @RequestMapping("/contact")
    public void contact() {}

    @RequestMapping("/index")
    public void index() {}

    @RequestMapping("/main")
    public void main() {}

    @RequestMapping("/shop")
    public void shop() {}

    @RequestMapping("/shop_details")
    public void shopDetails() {}

    @RequestMapping("/shopping_cart")
    public void shoppingCard() {}

}
