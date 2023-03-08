package com.seifer.fruitshop.model;

public class OrderRequestBody {
    private String type;
    private Long quantity;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Long getQuantity() {
        return quantity;
    }
    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public OrderRequestBody(String type, Long quantity) {
        this.type = type;
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "OrderRequestBody [type=" + type + ", quantity=" + quantity + "]";
    }

    public OrderRequestBody(){}
    
}
