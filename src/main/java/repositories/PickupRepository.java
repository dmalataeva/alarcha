package repositories;

import entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface PickupRepository extends CrudRepository<Order, Integer> {
}
