package com.example.noticeboard.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SlipSendReponse {

    private Long slipId;
    private Long sndId;
    private Long rcvId;
    private String content;
    private LocalDateTime sentAt;

    public SlipSendReponse(Long slipId, Long sndId, Long rcvId, String content, LocalDateTime sentAt) {
        this.slipId = slipId;
        this.sndId = sndId;
        this.rcvId = rcvId;
        this.content = content;
        this.sentAt = sentAt;
    }
}
