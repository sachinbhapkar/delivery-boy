package com.foods.deliveryboy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.foods.deliveryboy.config.AppConstants.LOCATION_UPDATE_TOPIC;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {
        kafkaTemplate.send(LOCATION_UPDATE_TOPIC, location);
        return true;
    }
}
