package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class PostUpdateRequest {

    private String title;
    private String content;
    private String imgUrl;

}
