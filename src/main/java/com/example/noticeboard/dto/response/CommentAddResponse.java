package com.example.noticeboard.dto.response;

import lombok.Getter;

@Getter
public class CommentAddResponse {

    private Long id;
    private Long postId;
    private String content;
    private Long sndId;
    private Long commentId;

    public CommentAddResponse(Long id, Long postId, String content, Long sndId, Long commentId) {
        this.id = id;
        this.postId = postId;
        this.content = content;
        this.sndId = sndId;
        this.commentId = commentId;
    }
}
