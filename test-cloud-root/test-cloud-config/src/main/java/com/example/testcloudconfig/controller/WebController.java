package com.example.testcloudconfig.controller;

import com.example.testcloudconfig.entity.Role;
import com.example.testcloudconfig.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("")
    public List<Role> hi() {
        return roleRepository.findAll();
    }
}
