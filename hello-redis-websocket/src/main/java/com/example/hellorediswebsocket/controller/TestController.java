package com.example.hellorediswebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redis")
    public String helloRedis() {
        redisTemplate.opsForValue().set("likelion", "hello redis");
        return (String) redisTemplate.opsForValue().get("likelion");
    }
}
