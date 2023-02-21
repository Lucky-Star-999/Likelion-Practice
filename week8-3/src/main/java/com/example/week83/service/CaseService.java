package com.example.week83.service;

import com.example.week83.config.StudentSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    private StudentSettings studentSettings;

    // This case is to change a value in property file using Actuator
    public String actuator() {
        return "Hi";
    }

    // This case is to read values in property file
    public String readPropertiesFile() {
        return studentSettings.toString();
    }

    public String changePropertiesFile(String name) {
        studentSettings.setName(name);
        return studentSettings.getName();
    }
}
