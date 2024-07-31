package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.CommentAddRequest;
import com.example.noticeboard.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("comment/add")
    public Long addComment(@RequestBody CommentAddRequest request) {
        return commentService.addComment(request);
    }
}
