package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class CommentAddRequest {

    private String content;
    private Long userId;
    private Long postId;
    private Long parentId;

}
