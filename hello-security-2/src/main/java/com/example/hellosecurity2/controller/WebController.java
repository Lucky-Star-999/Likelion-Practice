package com.example.hellosecurity2.controller;

import com.example.hellosecurity2.entity.UserInfo;
import com.example.hellosecurity2.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping(value = {"/hello"})
    public String hello() {
        return "hello";
    }

}
