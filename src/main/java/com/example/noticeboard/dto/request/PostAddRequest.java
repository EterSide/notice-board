package com.example.noticeboard.dto.request;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

@Getter
public class PostAddRequest {

    private String title;
    private String content;
    private Long userId;

}
