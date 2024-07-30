package com.example.noticeboard.domain;

import jakarta.persistence.*;
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private boolean isRead = false;

    protected Notification() {

    }

}
