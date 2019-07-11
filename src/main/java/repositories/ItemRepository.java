package repositories;

import entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Order, Integer> {
}
