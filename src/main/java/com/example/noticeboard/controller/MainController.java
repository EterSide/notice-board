package com.example.noticeboard.controller;

import com.example.noticeboard.dto.request.UserAddRequest;
import com.example.noticeboard.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    public Long addUser(@RequestBody UserAddRequest request) {
         return userService.addUser(request);
    }


}
