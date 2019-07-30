package com.dmalataeva.alarcha.controllers;

import com.dmalataeva.alarcha.entities.OrderEntity;
import com.dmalataeva.alarcha.models.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.dmalataeva.alarcha.repositories.OrderRepository;

import java.time.Instant;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = com.dmalataeva.alarcha.Alarcha.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private OrderRepository orderRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void whenGetOrderById_thenReturnOrder() throws Exception {
        Order order = new Order(1,"placed",Instant.now(),10.0,1,1);

        OrderEntity res = orderRepository.save(order.convertToEntity());

        mvc.perform(MockMvcRequestBuilders.get("/order").param("id", order.getOrderId() + "")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.orderId").value(order.getOrderId()));
    }
}
