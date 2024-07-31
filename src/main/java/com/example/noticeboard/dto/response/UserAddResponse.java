package com.example.noticeboard.dto.response;

import lombok.Getter;

@Getter
public class UserAddResponse {

    private Long id;
    private String email;
    private String userName;

    public UserAddResponse(Long id, String email, String userName) {
        this.id = id;
        this.email = email;
        this.userName = userName;
    }
}
