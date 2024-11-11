package com.itclopedia.courses.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {

    @KafkaListener(topics = "notifications", groupId = "analytics")
    public void consumeNotification(String message) {
        System.out.println("Received notification: " + message);
    }
}
