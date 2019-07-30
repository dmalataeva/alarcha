package com.dmalataeva.alarcha.repositories;

import com.dmalataeva.alarcha.entities.OrderEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void whenGetOrderById() throws Exception {
        OrderEntity order = entityManager.persist(new OrderEntity("placed",Timestamp.from(Instant.now()),10.0,1,1));
        entityManager.flush();

        OrderEntity foundOrder = orderRepository.findById(order.getOrderId()).orElse(new OrderEntity());

        assertThat(foundOrder.getOrderId())
                .isEqualTo(order.getOrderId());

        entityManager.clear();
    }

    @Test
    public void whenSaveOrder() throws Exception {
        OrderEntity order = entityManager.persist(new OrderEntity("placed",Timestamp.from(Instant.now()),10.0,1,1));

        OrderEntity savedOrder = orderRepository.save(order);

        assertThat(savedOrder.getOrderId())
                .isEqualTo(order.getOrderId());

        entityManager.clear();
    }

    @Test
    public void whenDeleteOrder() throws Exception {
        OrderEntity order = entityManager.persist(new OrderEntity("placed",Timestamp.from(Instant.now()),10.0,1,1));
        entityManager.flush();

        orderRepository.deleteById(order.getOrderId());

        OrderEntity checkRemovedOrder = entityManager.find(OrderEntity.class, order.getOrderId());
        assertThat(checkRemovedOrder)
                .isNull();

        entityManager.clear();
    }
}
