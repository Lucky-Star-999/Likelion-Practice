package com.example.hellosecurity.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_db")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}
