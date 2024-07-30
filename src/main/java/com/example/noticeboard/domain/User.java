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

   //-----------------------------------연관관계 필드 (테이블에는 생성 X)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "sndUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slip> sentSlip;

    @OneToMany(mappedBy = "rcvUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Slip> rcvSlip;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    protected User() {}

    public User(String userId, String password, String email, String userName) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.userName = userName;
    }
}
