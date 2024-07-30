package com.example.noticeboard.service;

import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.request.UserAddRequest;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public long addUser(UserAddRequest request) {
        User user = userRepository.save(new User(request.getUserId(), request.getUserName(), request.getEmail(), request.getPassword()));
        return user.getId();
    }

}
