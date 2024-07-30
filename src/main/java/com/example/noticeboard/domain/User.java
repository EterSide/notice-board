package com.example.noticeboard.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String userId;

    private String password;

    private String email;

    private String userName;

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    protected User() {}

    public User(String userId, String password, String email, String userName) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
}
