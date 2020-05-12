package com.jsen.springboot_web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * 校验登陆
 *
 * @author Jsen on 2020/5/12
 */
@Controller
public class LoginController {
    @PostMapping("/user/login")
    public String login(String username, String password, Map<String, Object> map) {
        if (!StringUtils.isEmpty(username) && "1234".equals(password))
            return "redirect:/main";
        else {
            return "login";
        }
    }

}
