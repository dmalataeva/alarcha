package repositories;

import entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<Order, Integer> {
}
