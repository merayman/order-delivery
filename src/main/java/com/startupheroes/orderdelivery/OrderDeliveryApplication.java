package com.startupheroes.orderdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class OrderDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderDeliveryApplication.class, args);
	}

}
