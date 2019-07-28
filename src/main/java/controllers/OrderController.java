package controllers;

import entities.OrderEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import repositories.OrderRepository;
import models.Order;

@RestController
@RequestMapping("/order")
public class OrderController {
    //private Logger logger = LoggerFactory.getLogger(OrderController.class);

    private OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/")
    public String defaultOrder() {
        //logger.info("You've hit the default endpoint");
        //logger.debug("This is a debugging message for the default endpoint");
        return "Default order endpoint";
    }

    @RequestMapping(method = RequestMethod.GET)
    public OrderEntity getOrder(@RequestParam("id") int orderId) {
        return orderRepository.findById(orderId).orElse(new OrderEntity());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putOrder(@RequestBody OrderEntity order) {
        orderRepository.save(order);
    }

    @RequestMapping(method = RequestMethod.POST)
    public OrderEntity postOrder(@RequestBody OrderEntity order) {
        return orderRepository.save(order);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int orderId) {
        orderRepository.deleteById(orderId);
    }

}
