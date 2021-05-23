package ds.assignment2.shoppingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import ds.assignment2.shoppingbackend.models.Order;


public interface OrderRepository extends CrudRepository<Order, String> {

	@Override
    void delete(Order deleted);
}
