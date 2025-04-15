package com.tvsmotor.dealerdata.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvsmotor.dealerdata.Model.Order;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
	 List<Order> findByDealerId(String dealerId);
}