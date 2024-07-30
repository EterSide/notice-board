package com.example.noticeboard.repository;

import com.example.noticeboard.domain.Slip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlipRepository extends JpaRepository<Slip, Long> {
}
