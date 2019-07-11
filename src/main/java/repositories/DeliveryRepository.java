package repositories;

import entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository extends CrudRepository<Order, Integer> {
}
