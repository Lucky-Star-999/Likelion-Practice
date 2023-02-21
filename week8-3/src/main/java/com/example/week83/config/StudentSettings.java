package com.example.week83.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RefreshScope
public class StudentSettings {
    private String name;
    private int age;
    private String major;
}
