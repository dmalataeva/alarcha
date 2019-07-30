package com.dmalataeva.alarcha.repositories;

import com.dmalataeva.alarcha.entities.OrderItemEntity;
import com.dmalataeva.alarcha.entities.OrderItemEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemEntityPK> {
}
