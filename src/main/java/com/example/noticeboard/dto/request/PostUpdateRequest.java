package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class PostUpdateRequest {

    private Long postId;
    private String title;
    private String content;

}
