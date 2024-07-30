package com.example.noticeboard.repository;

import com.example.noticeboard.domain.Post;
import com.example.noticeboard.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByContentEndingWith(String content);

    List<Post> findAllByTitleEndingWith(String title);

    List<Post> findAllByUser(User user);
}
