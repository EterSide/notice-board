package com.example.noticeboard.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime time;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    protected Post() {

    }




}
