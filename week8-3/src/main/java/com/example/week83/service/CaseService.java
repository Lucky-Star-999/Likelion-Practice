package com.example.week83.service;

import com.example.week83.component.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaseService {

    @Autowired
    private Student student;

    // This case is to change a value in property file using Actuator
    public String actuator() {
        return "Hi";
    }

    // This case is to read values in property file
    public String readPropertiesFile() {
        return student.toString();
    }

}
