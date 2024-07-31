package com.example.noticeboard.dto.response;

import lombok.Getter;

@Getter
public class NotificationResponse {

    private Long id;
    private String content;
    private boolean isRead;
    private Long postId;
    private Long rcvId;

    public NotificationResponse(Long id, String content, boolean isRead, Long postId, Long rcvId) {
        this.id = id;
        this.content = content;
        this.isRead = isRead;
        this.postId = postId;
        this.rcvId = rcvId;
    }
}
