package com.example.noticeboard.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SlipResponse {

    private Long id;
    private Long sndId;
    private String content;
    private LocalDateTime time;

    public SlipResponse(Long id, Long sndId, String content, LocalDateTime time) {
        this.id = id;
        this.sndId = sndId;
        this.content = content;
        this.time = time;
    }
}
