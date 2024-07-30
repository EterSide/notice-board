package com.example.noticeboard.dto.response;

import com.example.noticeboard.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class PostResponse {

    private Long postId;
    private String title;
    private String content;
    private String userName;
    private String imgUrl;
//    private List<Comment> commentList;
    private LocalDateTime time;


}
