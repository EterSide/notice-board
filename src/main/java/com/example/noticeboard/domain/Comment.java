package com.example.noticeboard.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id",nullable = true)
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> commentList = new ArrayList<>();



    protected Comment() {

    }

    public Comment(String content, User user, Post post, Comment parentComment) {
        this.content = content;
        this.user = user;
        this.post = post;
        this.parentComment = parentComment;
    }

    public Comment(String content, User user, Post post) {
        this.content = content;
        this.user = user;
        this.post = post;
    }

//    public Comment(String content, User user, Post post) {
//        this.content = content;
//        this.user = user;
//        this.post = post;
//    }


}
