package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.entities.OrderEntity;
import com.dmalataeva.alarcha.models.Order;
import com.dmalataeva.alarcha.models.OrderAndShipping;
import com.dmalataeva.alarcha.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.dmalataeva.alarcha.repositories.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    //private Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping("/")
    public String defaultOrder() {
        //logger.info("You've hit the default endpoint");
        //logger.debug("This is a debugging message for the default endpoint");
        return "Default order endpoint";
    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET)
    public List<Order> getOrderByCustomerId(@RequestParam("id") int id) {
        return orderService.getOrderByCustomerId(id);
    }

    @RequestMapping(path = "/shipping", method = RequestMethod.GET)
    public List<Order> getOrderByShippingId(@RequestParam("id") int id) {
        return orderService.getOrderByShippingId(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Order getOrder(@RequestParam("id") int id) throws Exception {
        return orderService.getOrderById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void putOrder(@RequestBody OrderAndShipping orderAndShipping) throws Exception {
        orderService.saveOrder(orderAndShipping);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Order postOrder(@RequestBody OrderAndShipping orderAndShipping) throws Exception {
        return orderService.saveOrder(orderAndShipping);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrderById(id);
    }

}
