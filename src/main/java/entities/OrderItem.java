package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class OrderItem {

    /*
        orderItem:
        -itemId
        -options
        -quantity
        -cost
     */

    private OrderItemId orderItemId;
    //private List<String> options;
    private int quantity;
    private double cost;

    public OrderItemId getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(OrderItemId orderItemId) { this.orderItemId = orderItemId; }

    public void setOrderItemId(int orderId, int itemId) { this.orderItemId = new OrderItemId(orderId, itemId); }

    public int getOrderId() { return orderItemId.getOrderId(); }

    public void setOrderId(int orderId) { this.orderItemId.setOrderId(orderId); }

    public int getItemId() { return orderItemId.getItemId(); }

    public void setItemId(int itemId) { this.orderItemId.setItemId(itemId); }

    //public List<String> getOptions() { return options; }

    //public void setOptions(List<String> options) { this.options = options; }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
