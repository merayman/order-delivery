package com.startupheroes.orderdelivery.controller;

import com.startupheroes.orderdelivery.model.DeliveredOrder;
import com.startupheroes.orderdelivery.service.KafkaService;
import com.startupheroes.orderdelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.startupheroes.orderdelivery.model.Order;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private KafkaService kafkaService;
    @GetMapping("/delivered")
    public ResponseEntity<List<Order>> getDeliveredOrders(){

        //retrieve delivered orders from the DB
        List<Order> orders = orderService.getDeliveredLastWeekOrders();
        orders.forEach( order -> {
            //create delivered order objects
            DeliveredOrder deliveredOrder = new DeliveredOrder(order);
            //publish to the kafka
            kafkaService.publishOrder(deliveredOrder);
        } );

        return ResponseEntity.ok(orders);
    }

}
