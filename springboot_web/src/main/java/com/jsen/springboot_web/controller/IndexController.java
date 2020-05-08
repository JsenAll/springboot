package com.jsen.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class IndexController {
    @RequestMapping("/test_01")
    public String test_o1(Model model) {
        model.addAttribute("msg", "你好 Thymeleaf");
        model.addAttribute("arrs", Arrays.asList("你好", "SpringBoot", "Thymeleaf"));
        return "index";
    }

    public static void main(String[] args) {
        String url = "https://m.166xs.cc/xiaoshuo/210/210261/98975883/";
        int i = url.lastIndexOf("/");
        int length = url.length();
        if (length - 1 == i) {
            url = url.substring(0, i);
            i = url.lastIndexOf("/");
        }
        String substring = url.substring(0, i);
        System.out.println(substring);
    }
}
