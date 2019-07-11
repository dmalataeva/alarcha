package controllers;

import entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import store.OrderStore;

@RestController
@RequestMapping("/order")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/")
    public String defaultOrder() {
        logger.info("Reached default endpoint");
        return "Default order endpoint";
    }

    @RequestMapping(method = RequestMethod.GET)
    public Order getOrder(@RequestParam("id") int orderId) {
        logger.info("GET request with id " + orderId);
        return OrderStore.getOrder(orderId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putOrder(@RequestBody Order order) {
        System.out.println("PUT request with order " + order);
        OrderStore.updateOrder(order);
    }

    @RequestMapping(method = RequestMethod.POST)
    public int postOrder(@RequestBody Order order) {
        return OrderStore.addOrder(order);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId) {
        OrderStore.deleteOrder(orderId);
    }

}
