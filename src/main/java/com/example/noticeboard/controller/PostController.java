package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.PostAddRequest;
import com.example.noticeboard.dto.request.PostUpdateRequest;
import com.example.noticeboard.dto.response.PostAddResponse;
import com.example.noticeboard.dto.response.PostResponse;
import com.example.noticeboard.service.PostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("posts")
    public List<PostResponse> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("post/search")
    public List<PostResponse> getSearchPosts(
            @RequestParam String searchType,
            @RequestParam String keyword
    ) {
        return postService.getSearchPosts(searchType, keyword);
    }

    @PostMapping("posts")
    public PostAddResponse addPost(
            @RequestPart(name = "request") PostAddRequest request,
            @RequestPart(required = false, name = "imageFile") MultipartFile imageFile
    ) throws IOException {
        return postService.addPost(request, imageFile);
    }

    @GetMapping("posts/{postId}")
    public PostResponse getPost(@PathVariable("postId") Long id) {
        return postService.getPost(id);
    }

    @PutMapping("posts")
    public PostResponse updatePost(
            @RequestPart(name = "request") PostUpdateRequest request,
            @RequestPart(required = false, name = "imageFile") MultipartFile imageFile
    ) throws IOException {
        return postService.updatePost(request, imageFile);
    }

    @DeleteMapping("posts/{postId}")
    public void deletePost(@PathVariable("postId") Long id) {
        postService.deletePost(id);
    }
}
