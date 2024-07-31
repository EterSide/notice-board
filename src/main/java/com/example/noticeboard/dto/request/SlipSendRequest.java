package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class SlipSendRequest {

    private Long sndId;
    private Long rcvId;
    private String content;

}
