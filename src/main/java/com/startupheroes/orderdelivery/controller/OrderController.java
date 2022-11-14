package com.startupheroes.orderdelivery.controller;

import com.startupheroes.orderdelivery.model.DeliveredOrder;
import com.startupheroes.orderdelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.startupheroes.orderdelivery.model.Order;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/delivered")
    public ResponseEntity<List<Order>> getDeliveredOrders(){

        //retrieve delivered orders
        List<Order> orders = orderService.getAllOrders();
        //transform Orders into the DeliveredOrders
        List<DeliveredOrder> deliveredOrders = new ArrayList<>();

        //publish to kafka
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
