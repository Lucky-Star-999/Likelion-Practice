package com.example.hellosecurity2.controller;

import com.example.hellosecurity2.entity.UserInfo;
import com.example.hellosecurity2.repository.UserInfoRepository;
import com.example.hellosecurity2.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

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

    @GetMapping(value = {"/admin/hello"})
    public String helloAdmin() {
        return "hello-admin";
    }

    @ResponseBody
    @GetMapping(value = {"/user"})
    public Collection<? extends GrantedAuthority> getRole() {

        return customUserDetails.getAuthorities();
    }

}
