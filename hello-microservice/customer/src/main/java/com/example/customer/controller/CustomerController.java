package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/findTaxi")
    public String findTaxi() {
        String result = restTemplate.getForObject("http://localhost:8081/api/v1/driver/taxi", String.class);
        return result;
    }
}
