package http.controller;

import entities.Order;
import org.springframework.web.bind.annotation.*;
import store.OrderStore;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/")
    public String defaultOrder() {
        return "Default order endpoint";
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int orderId) {
        return OrderStore.getOrder(orderId);
    }

    @PutMapping("/{id}")
    public void putOrder(@RequestBody Order order) {
        OrderStore.updateOrder(order);
    }

    @PostMapping
    public int postOrder(@RequestBody Order order) {
        return OrderStore.addOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int orderId) {
        OrderStore.deleteOrder(orderId);
    }

}
