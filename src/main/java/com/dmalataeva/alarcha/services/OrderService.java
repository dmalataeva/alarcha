package com.dmalataeva.alarcha.services;

import com.dmalataeva.alarcha.entities.OrderEntity;
import com.dmalataeva.alarcha.models.Order;
import com.dmalataeva.alarcha.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(int orderId) {
        return new Order(orderRepository.findById(orderId).orElse(new OrderEntity()));
    }

    /*public List<Order> getOrderByCustomerId(int customerId) {
        List<OrderEntity> orderEntityList = orderRepository.findOrderByCustomerId(customerId);
        List<Order> orderList = new ArrayList<>();
        for (OrderEntity orderEntity:orderEntityList) {
            orderList.add(new Order(orderEntity));
        }

        return orderList;
    }*/

    public Order saveOrder(Order order) {
        OrderEntity saveResult = orderRepository.save(order.convertToEntity());
        return new Order(saveResult);
    }

    public void deleteOrderById(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
