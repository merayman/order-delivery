package com.startupheroes.orderdelivery.service;

import com.startupheroes.orderdelivery.model.Order;
import com.startupheroes.orderdelivery.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
