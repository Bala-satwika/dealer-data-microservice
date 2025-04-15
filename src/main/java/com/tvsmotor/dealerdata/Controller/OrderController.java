package com.tvsmotor.dealerdata.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tvsmotor.dealerdata.Model.Order;
import com.tvsmotor.dealerdata.Service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/{dealerId}")
    public List<Order> getOrdersByDealerIdAndStateId(@PathVariable String dealerId) {
        return orderService.getOrdersByDealerId(dealerId);
    }
}
