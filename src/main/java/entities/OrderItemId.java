package entities;

import java.io.Serializable;

public class OrderItemId implements Serializable {
    private int orderId;
    private int itemId;

    public OrderItemId(int orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public int getOrderId() { return this.orderId; }

    public int getItemId() { return this.itemId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }

    public void setItemId(int itemId) { this.itemId = itemId; }
}
