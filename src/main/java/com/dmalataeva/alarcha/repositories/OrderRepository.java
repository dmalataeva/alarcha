package com.dmalataeva.alarcha.repositories;

import com.dmalataeva.alarcha.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
