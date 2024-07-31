package com.example.noticeboard.service;

import com.example.noticeboard.domain.Notification;
import com.example.noticeboard.domain.User;
import com.example.noticeboard.dto.response.NotificationResponse;
import com.example.noticeboard.repository.NotificationRepository;
import com.example.noticeboard.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

    private final UserRepository userRepository;
    private final NotificationRepository notificationRepository;

    public NotificationService(UserRepository userRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationResponse> getNotifications(String userId) {

        User user = userRepository.findByUserId(userId);
        List<Notification> notifications = notificationRepository.findAllByUser(user);

        List<NotificationResponse> notificationResponses = new ArrayList<>();

        for (Notification notification : notifications) {

            NotificationResponse notificationResponse = new NotificationResponse(
                    notification.getId(),
                    notification.getContent(),
                    notification.getIsRead(),
                    notification.getPost().getId(),
                    notification.getUser().getId()
            );
            notificationResponses.add(notificationResponse);
        }
        return notificationResponses;
    }
    @Transactional
    public NotificationResponse readNotification(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        notification.setRead(true);
        return new NotificationResponse(
                notification.getId(),
                notification.getContent(),
                notification.getIsRead(),
                notification.getPost().getId(),
                notification.getUser().getId()
        );
    }

}



