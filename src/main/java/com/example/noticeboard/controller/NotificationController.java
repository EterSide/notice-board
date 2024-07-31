package com.example.noticeboard.controller;

import com.example.noticeboard.dto.response.NotificationResponse;
import com.example.noticeboard.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("notifications/{userId}")
    public List<NotificationResponse> getNotifications(@PathVariable("userId") String userId) {
        return notificationService.getNotifications(userId);
    }

    @PatchMapping("notifications/{notificationId}/read")
    public NotificationResponse readNotification(@PathVariable("notificationId") Long id) {
        return notificationService.readNotification(id);
    }
}
