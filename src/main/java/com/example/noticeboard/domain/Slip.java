package com.example.noticeboard.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@Entity
public class Slip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String content;

    @CreationTimestamp
    private LocalDateTime time;

    protected Slip() {

    }

}
