package com.example.noticeboard.dto.response;

import lombok.Getter;

@Getter
public class PostAddResponse {

    private String title;
    private String content;
    private String imgUrl;

    public PostAddResponse(String title, String content, String imgUrl) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
    }
}
