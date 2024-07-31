package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.UserAddRequest;
import com.example.noticeboard.dto.request.UserLoginRequest;
import com.example.noticeboard.dto.response.UserAddResponse;
import com.example.noticeboard.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/register")
    public UserAddResponse addUser(@RequestBody UserAddRequest request) {
        return userService.addUser(request);
    }

    @PostMapping("users/login")
    public boolean loginUser(@RequestBody UserLoginRequest request) {
        return userService.loginUser(request);
    }


}
