package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.CommentAddRequest;
import com.example.noticeboard.dto.request.PostAddRequest;
import com.example.noticeboard.service.CommentService;
import com.example.noticeboard.service.PostService;
import com.example.noticeboard.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class LoginController {

    private final UserService userService;
    private final PostService postService;
    private final CommentService commentService;

    public LoginController(UserService userService, PostService postService, CommentService commentService) {
        this.userService = userService;
        this.postService = postService;
        this.commentService = commentService;
    }

    @PostMapping("post/add")
    public Long addPost(
            @RequestPart(name = "request") PostAddRequest request,
            @RequestPart(required = false, name = "imageFile") MultipartFile imageFile
    ) throws IOException {
        return postService.addPost(request, imageFile);
    }

    @PostMapping("comment/add")
    public Long addComment(@RequestBody CommentAddRequest request) {
        return commentService.addComment(request);
    }

}
