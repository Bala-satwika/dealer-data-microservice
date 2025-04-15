package com.tvsmotor.dealerdata.Model;

public class Item {
    private String product;
    private int quantity;
    private String status;

    public Item() {
    }

    public Item(String product, int quantity, String status) {
        this.product = product;
        this.quantity = quantity;
        this.status = status;
    }

    // Getters and Setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
