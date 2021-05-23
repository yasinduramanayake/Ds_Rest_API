package ds.assignment2.shoppingbackend.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


import ds.assignment2.shoppingbackend.models.User;

public interface UserRepository extends MongoRepository<User, ObjectId>  {
	
	public User findByEmail(String email);

	 @Override
	    void delete(User deleted);
}
