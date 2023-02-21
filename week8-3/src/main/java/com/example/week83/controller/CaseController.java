package com.example.week83.controller;

import com.example.week83.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {

    @Autowired
    private CaseService caseService;

    // This case is to change a value in property file using Actuator
    @GetMapping("/actuator")
    public String actuator() {
        return caseService.actuator();
    }

    // This case is to read values in property file
    @GetMapping("/properties")
    public String readPropertiesFile() {
        return caseService.readPropertiesFile();
    }
}
