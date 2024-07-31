package com.example.noticeboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String content;

    private boolean isRead = false;


    protected Notification() {

    }

    public Notification(User user, Post post, String content) {
        this.user = user;
        this.post = post;
        this.content = content;
    }

    public boolean getIsRead() {
        return isRead;
    }
}

// Post
// 댓글이 달린건지 , 대댓글이 달린거지
// 댓글이 1 / 2
