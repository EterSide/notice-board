package com.example.noticeboard.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Slip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "snd_user_id")
    private User sndUser;

    @ManyToOne
    @JoinColumn(name = "rcv_user_id")
    private User rcvUser;

    private String content;

    @CreationTimestamp
    private LocalDateTime time;


    protected Slip() {

    }

}
