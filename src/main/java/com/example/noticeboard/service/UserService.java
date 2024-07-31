package com.example.noticeboard.service;

import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.UserAddRequest;
import com.example.noticeboard.dto.request.UserLoginRequest;
import com.example.noticeboard.dto.response.UserAddResponse;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserAddResponse addUser(UserAddRequest request) {
        User user = userRepository.save(new User(request.getUserId(), request.getPassword(), request.getEmail(), request.getUserName()));
        return new UserAddResponse(user.getId(), user.getEmail(), user.getUserName());
    }

    public boolean loginUser(UserLoginRequest request) {

        User user = userRepository.findByUserId(request.getUserId());
        if (user != null) {
            if (user.getPassword().equals(request.getUserPw())) {
                return true;
            }
        }


        return false;
    }

}
