package com.example.hellojwt2.controller;

import com.example.hellojwt2.dto.LoginRequest;
import com.example.hellojwt2.dto.LoginResponse;
import com.example.hellojwt2.security.CustomUserDetails;
import com.example.hellojwt2.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/api")
public class WebController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@RequestBody LoginRequest loginRequest) {

        // Xác thực từ username và password
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        System.out.println(authentication);

        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng
        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new LoginResponse(jwt);
    }

    // Api /api/random yêu cầu phải xác thực mới có thể request
    @GetMapping("/random")
    public String randomStuff() {
        return "JWT Hợp lệ mới có thể thấy được message này";
    }

    @GetMapping("/admin/hello")
    public String helloAdmin() {
        return "Admin mới vào được đây";
    }

    @GetMapping("/customer/hello")
    public String helloCustomer() {
        return "Customer mới vào được đây";
    }

}
