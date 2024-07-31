package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class UserLoginRequest {

    private String userId;
    private String userPw;

    public UserLoginRequest(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
    }
}
