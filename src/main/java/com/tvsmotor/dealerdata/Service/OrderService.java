package com.tvsmotor.dealerdata.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tvsmotor.dealerdata.Model.Order;
import com.tvsmotor.dealerdata.Repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByDealerId(String dealerId) {
        return orderRepository.findByDealerId(dealerId);
    }
}
