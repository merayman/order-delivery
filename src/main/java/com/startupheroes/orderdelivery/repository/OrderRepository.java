package com.startupheroes.orderdelivery.repository;

import com.startupheroes.orderdelivery.model.Order;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    /*
        method
        @returns: delivered orders created last week
     */
    @Query( value = "select * from \"Order\" o where\n" +
            "    o.delivered_at is not null and\n" +
            " now() - o.created_at < interval '1 week'",
    nativeQuery = true)
    List<Order> getLastWeekDeliveredOrders();
}
