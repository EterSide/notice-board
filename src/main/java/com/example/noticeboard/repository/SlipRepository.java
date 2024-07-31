package com.example.noticeboard.repository;

import com.example.noticeboard.domain.Slip;
import com.example.noticeboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SlipRepository extends JpaRepository<Slip, Long> {

    List<Slip> findByRcvUser(User user);
    List<Slip> findBySndUser(User user);
}
