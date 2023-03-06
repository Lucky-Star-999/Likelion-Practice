package com.example.hellorediswebsocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/redis/list")
    public List<String> helloRedis2() {
        List<String> redisList = new ArrayList<>();
        redisList.add("Element 1");
        redisList.add("Element 2");
        redisList.add("Element 3");
        redisTemplate.opsForList().rightPushAll("redisList", redisList);
        return (List<String>) redisTemplate.opsForList().range("redisList", 0, -1);
    }
}
