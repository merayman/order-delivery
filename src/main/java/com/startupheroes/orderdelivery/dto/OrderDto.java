package com.startupheroes.orderdelivery.dto;


import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private Long customerId;
    //estimated time of arrival in minutes
    private Integer eta;
    //Datetimes
}
