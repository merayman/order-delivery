package com.startupheroes.orderdelivery.service;

import com.startupheroes.orderdelivery.model.Order;
import com.startupheroes.orderdelivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public List<Order> getDeliveredLastWeekOrders(){
        return orderRepository.getLastWeekDeliveredOrders();
    }
}
