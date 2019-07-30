package com.dmalataeva.alarcha.services;

import com.dmalataeva.alarcha.entities.OrderEntity;
import com.dmalataeva.alarcha.models.Order;
import com.dmalataeva.alarcha.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class OrderServiceIntegrationTest {

    @TestConfiguration
    static class OrderServiceTestContextConfiguration {

        @Bean
        public OrderService orderService() {
            return new OrderService();
        }
    }

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Before
    public void setUp() {
        Order order = new Order(1,"placed",Instant.now(),10.0,1,1);
        Order order2 = new Order(2,"processing",Instant.now(),10.0,1,2);

        List<OrderEntity> sameCustomerOrderList = new ArrayList<>();
        sameCustomerOrderList.add(order.convertToEntity());
        sameCustomerOrderList.add(order2.convertToEntity());

        Mockito.when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.of(order.convertToEntity()));
    }

    @Test
    public void whenFindOrderById() {
        int orderId = 1;

        Order foundOrder = orderService.getOrderById(orderId);

        assertThat(foundOrder.getOrderId())
                .isEqualTo(orderId);
    }
}
