package com.example.noticeboard.service;

import com.example.noticeboard.domain.Post;
import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.PostAddRequest;
import com.example.noticeboard.dto.response.PostResponse;
import com.example.noticeboard.repository.PostRepository;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponse> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> postResponses = new ArrayList<>();
        for (Post post : posts) {
            User user = post.getUser();

            PostResponse postResponse = new PostResponse(post.getId(),post.getTitle(), post.getContent(), user.getUserName(),post.getImageUrl() ,post.getTime());
            postResponses.add(postResponse);
        }

        return postResponses;
    }

    public List<PostResponse> getSearchPosts(String searchType, String keyword) {

        List<Post> posts = null;
        List<PostResponse> postResponses = new ArrayList<>();

        if(searchType.equals("title") && keyword != null) {
            posts = postRepository.findByTitleContaining(keyword);
        } else if (searchType.equals("content") && keyword != null) {
            posts = postRepository.findByContentContaining(keyword);
        } else if (searchType.equals("name") && keyword != null) {
            posts = postRepository.findByUser(userRepository.findByUserName(keyword));
        }


        for (Post post : posts) {

            User user = post.getUser();

            PostResponse postResponse = new PostResponse(post.getId(),post.getTitle(), post.getContent(), user.getUserName(),post.getImageUrl(), post.getTime());
            postResponses.add(postResponse);
        }



        return postResponses;
    }

    public Long addPost(PostAddRequest request, MultipartFile imageFile) throws IOException {

        String imageUrl = null;
        if (imageFile != null) {
            imageUrl = saveImage(imageFile);
        }

        User user = userRepository.findById(request.getUserId()).orElseThrow(IllegalArgumentException::new);
        Post post = postRepository.save(new Post(imageUrl, user, request.getContent(), request.getTitle()));

        return post.getId();
    }

    private String saveImage(MultipartFile imageFile) throws IOException {
        String uploadDir = "C:/Users/inx58/Downloads/jpashop-v20210728/noticeBoard/Images/";
        String originalFilename = imageFile.getOriginalFilename();
        String uniqueFilename = UUID.randomUUID().toString() + "_" + originalFilename;
        String filePath = uploadDir + uniqueFilename;

        Files.createDirectories(Paths.get(uploadDir));
        imageFile.transferTo(new File(filePath));

        return filePath;
    }

}

