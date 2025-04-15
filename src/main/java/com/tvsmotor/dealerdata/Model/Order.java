package com.tvsmotor.dealerdata.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Order")
public class Order {
    @Id
    private String orderId;
    private String dealerId;
    private List<Item> items; // Change to a list of items
    private String date;

    public Order() {
    }

    public Order(String orderId, String dealerId, List<Item> items, String date) {
        this.orderId = orderId;
        this.dealerId = dealerId;
        this.items = items;
        this.date = date;
    }

    // Getters and Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getDealerId() {
        return dealerId;
    }

    public void setDealerId(String dealerId) {
        this.dealerId = dealerId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
