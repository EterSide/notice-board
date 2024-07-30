package com.example.noticeboard.dto.request;

import lombok.Getter;

@Getter
public class UserAddRequest {

    private String userId;
    private String password;
    private String email;
    private String userName;

}
