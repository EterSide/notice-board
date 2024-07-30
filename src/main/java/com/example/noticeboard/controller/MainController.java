package com.example.noticeboard.controller;

import com.example.noticeboard.domain.Comment;
import com.example.noticeboard.domain.Post;
import com.example.noticeboard.dto.request.PostAddRequest;
import com.example.noticeboard.dto.request.UserAddRequest;
import com.example.noticeboard.dto.response.PostResponse;
import com.example.noticeboard.service.PostService;
import com.example.noticeboard.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class MainController {

    private final UserService userService;
    private final PostService postService;

    public MainController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping("user/add")
    public Long addUser(@RequestBody UserAddRequest request) {
         return userService.addUser(request);
    }

    @GetMapping("post")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("post/search")
    public List<PostResponse> getSearchPosts(
            @RequestParam String searchType,
            @RequestParam String keyword
                                    )
    {
        return postService.getSearchPosts(searchType, keyword);
    }




}
