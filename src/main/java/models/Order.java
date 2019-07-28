package models;

import entities.OrderEntity;

import java.sql.Date;

public class Order {
    private int orderId;
    private String status;
    private Date dateCreated;
    private double subtotal;
    private int customerId;
    private int shippingId;

    public Order (OrderEntity orderEntity) {
        this.orderId = orderEntity.getOrderId();
        this.status = orderEntity.getStatus();
        this.dateCreated = orderEntity.getDateCreated();
        this.subtotal = orderEntity.getSubtotal();
        this.customerId = orderEntity.getCustomerId();
        this.shippingId = orderEntity.getShippingId();
    }

    public OrderEntity convertToEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId(orderId);
        orderEntity.setStatus(status);
        orderEntity.setDateCreated(dateCreated);
        orderEntity.setSubtotal(subtotal);
        orderEntity.setCustomerId(customerId);
        orderEntity.setShippingId(shippingId);

        return orderEntity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

}
