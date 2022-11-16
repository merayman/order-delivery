package com.startupheroes.orderdelivery.config;

import com.startupheroes.orderdelivery.model.DeliveredOrder;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

    @Value("${sh.kafka.address1}")
    private String kafkaAddress1;
    @Value("${sh.kafka.address2}")
    private String kafkaAddress2;
    @Value("${sh.kafka.address3}")
    private String kafkaAddress3;
    @Value("${sh.kafka.group_id}")
    private String groupId;

    //kafka producer configuration
    @Bean
    public ProducerFactory producerFactory(){
        Map <String, Object> config= new HashMap<>();
        List<String> bootstrapServers = new ArrayList<>();
        bootstrapServers.add(kafkaAddress1);
        bootstrapServers.add(kafkaAddress2);
        bootstrapServers.add(kafkaAddress3);
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(config);
    }

    @Bean
    public KafkaTemplate<String, DeliveredOrder> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}