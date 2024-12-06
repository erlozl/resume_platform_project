package com.example.resume_platform.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 10)
    private String username;
    @Column(nullable = false, length = 80)
    private String password;
    @Column(nullable = false, unique = true, length = 20)
    private String userid;

    // @Builder
    // public User(Integer id, String username, String password, String userid) {
    // this.id = id;
    // this.username = username;
    // this.password = password;
    // this.userid = userid;
    // }

}
