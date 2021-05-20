package ds.assignment2.shoppingbackend.repositories;

import org.springframework.data.repository.CrudRepository;
import ds.assignment2.shoppingbackend.models.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

	 @Override
	    void delete(Product deleted);
}
