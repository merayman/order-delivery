package com.startupheroes.orderdelivery.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@ToString
public class DeliveredOrder {
    private Long id;
    private String createdAt;
    private String lastUpdatedAt;
    private Integer collectionDuration;
    private Integer deliveryDuration;
    //estimated time of arrival in minutes
    private Integer eta;
    //realized minutes from order creation to order completion
    private Integer leadTime;
    private Boolean orderInTime;

    public DeliveredOrder(Order order){
        id = order.getId();
        createdAt = order.getCreatedAt().toString();
        lastUpdatedAt = order.getLastUpdatedAt().toString();
        if (order.getCollectedAt() == null) // if not collected yet
            collectionDuration = Math.toIntExact(ChronoUnit.MINUTES.
                    between(order.getCollectionStartedAt(), LocalDateTime.now()));
        else
            collectionDuration = Math.toIntExact(ChronoUnit.MINUTES.
                between(order.getCollectionStartedAt(),order.getCollectedAt()));
        if (order.getDeliveredAt() == null) // if not delivered yet
            deliveryDuration = Math.toIntExact(ChronoUnit.MINUTES.
                    between(order.getDeliveryStartedAt(),LocalDateTime.now()));
        else
            deliveryDuration = Math.toIntExact(ChronoUnit.MINUTES.
                between(order.getDeliveryStartedAt(),order.getDeliveredAt()));
        eta = order.getEta();
        leadTime = Math.toIntExact(ChronoUnit.MINUTES.
                between(order.getCreatedAt(),order.getDeliveredAt()));
        orderInTime = eta >= deliveryDuration;
    }

}
