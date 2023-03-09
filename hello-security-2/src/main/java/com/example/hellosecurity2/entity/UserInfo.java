package com.example.hellosecurity2.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {
    @Id
    private String id;
    private String email;
    private String role;
    private String password;
    private String fullname;
    private String phone;
}
