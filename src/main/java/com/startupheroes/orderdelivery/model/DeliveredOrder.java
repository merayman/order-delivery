package com.startupheroes.orderdelivery.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
}
