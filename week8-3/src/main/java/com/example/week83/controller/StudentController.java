package com.example.week83.controller;

import com.example.week83.component.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class StudentController {

    @Autowired
    private Student student;

    @GetMapping("/student")
    public String name() {
        return student.getName();
    }

}
