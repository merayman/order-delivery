package com.startupheroes.orderdelivery.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "x")
@Table(name = "x")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Order {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    //estimated time of arrival in minutes
    @Column(name = "eta")
    private Integer eta;
    //Datetimes
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "last_updated_at")
    private LocalDateTime lastUpdatedAt;
    @Column(name = "collection_started_at")
    private LocalDateTime collectionStartedAt;
    @Column(name = "collected_at")
    private LocalDateTime collectedAt;
    @Column(name = "delivery_started_at")
    private LocalDateTime deliveryStartedAt;
    @Column(name = "delivered_at")
    private LocalDateTime deliveredAt;
}
