package com.dmalataeva.alarcha.services;

import com.dmalataeva.alarcha.models.Order;
import com.dmalataeva.alarcha.repositories.OrderRepository;
import net.bytebuddy.implementation.bytecode.Throw;
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
import static org.assertj.core.api.Assertions.fail;

import java.time.Instant;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class OrderServiceIntegrationTest {

    @TestConfiguration
    static class OrderServiceTestContextConfiguration {

        @Bean("testOrderService")
        public OrderService orderService() {
            return new OrderService();
        }
    }

    @Autowired
    private OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private ShippingService shippingService;

    @Before
    public void setUp() {
        Order order = new Order(1,"placed",Instant.now(),10.0,1,1);

        Mockito.when(orderRepository.findById(order.getOrderId())).thenReturn(Optional.of(order.convertToEntity()));
    }

    @Test
    public void whenFindOrderById() {
        int orderId = 1;

        Order foundOrder = null;

        try {
            foundOrder = orderService.getOrderById(orderId);
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }

        assertThat(foundOrder.getOrderId())
                .isEqualTo(orderId);
    }
}
