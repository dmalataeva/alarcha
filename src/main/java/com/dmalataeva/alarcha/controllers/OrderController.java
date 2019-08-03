package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.entities.OrderEntity;
import com.dmalataeva.alarcha.models.Order;
import com.dmalataeva.alarcha.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dmalataeva.alarcha.repositories.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
    //private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

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
    public Order getOrder(@RequestParam("id") int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putOrder(@RequestBody Order order) {
        orderService.saveOrder(order);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order postOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }

}
