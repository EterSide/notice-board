package com.example.noticeboard.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Column(nullable = true)
    private Long parentComment;

    protected Comment() {

    }

}
