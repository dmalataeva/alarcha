package repositories;

import entities.OrderItemEntity;
import entities.OrderItemEntityPK;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemEntityPK> {
}
