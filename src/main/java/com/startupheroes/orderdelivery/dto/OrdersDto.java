package com.startupheroes.orderdelivery.dto;

import com.startupheroes.orderdelivery.model.Order;
import lombok.*;

import java.util.List;

@Data
public class OrdersDto {
    private List<Order> orders;
}
