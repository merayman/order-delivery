package com.startupheroes.orderdelivery.repository;

import com.startupheroes.orderdelivery.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
