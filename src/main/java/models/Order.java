package models;

import entities.OrderEntity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

public class Order {
    private int orderId;
    private String status;
    private Instant dateCreated;
    private double subtotal;
    private int customerId;
    private int shippingId;

    public Order (OrderEntity orderEntity) {
        this.orderId = orderEntity.getOrderId();
        this.status = orderEntity.getStatus();
        this.dateCreated = orderEntity.getDateCreated().toInstant();
        this.subtotal = orderEntity.getSubtotal();
        this.customerId = orderEntity.getCustomerId();
        this.shippingId = orderEntity.getShippingId();
    }

    public OrderEntity convertToEntity() {
        return new OrderEntity(orderId, status, Timestamp.from(dateCreated), subtotal, customerId, shippingId);
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

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
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
