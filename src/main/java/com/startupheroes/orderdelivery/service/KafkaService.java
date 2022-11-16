package com.startupheroes.orderdelivery.service;

import com.startupheroes.orderdelivery.model.DeliveredOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaService {

    @Value("${sh.kafka.topic}")
    private String topic;
    private final KafkaTemplate<String, DeliveredOrder> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, DeliveredOrder> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishOrder(DeliveredOrder deliveredOrder){
        kafkaTemplate.send(topic,deliveredOrder);
    }
}
