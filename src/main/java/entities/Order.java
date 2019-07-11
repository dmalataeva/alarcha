package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
public class Order {
    /*
        Order:
        -orderId
        -datePlaced
        -collectMethod
        -userId
        -orderItems [{orderItem}]
        -total
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private int userId;
    private Timestamp datePlaced;
    private String collectMethod;
    private OrderItem[] orderItems;
    private double total;

    public Order(int userId, Instant datePlaced, String collectMethod, double total) {
        this.userId = userId;
        this.datePlaced = Timestamp.from(datePlaced);
        this.collectMethod = collectMethod;
        this.total = total;
    }

    public Order(){}

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Timestamp datePlaced) { this.datePlaced = datePlaced; }

    public String getCollectMethod() {
        return collectMethod;
    }

    public void setCollectMethod(String collectMethod) {
        this.collectMethod = collectMethod;
    }

    public OrderItem[] getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(OrderItem[] orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    /*
        Status:
        Type
        Date
        Logs
        */
}
