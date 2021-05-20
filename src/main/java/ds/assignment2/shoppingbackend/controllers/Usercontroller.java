package ds.assignment2.shoppingbackend.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ds.assignment2.shoppingbackend.models.Product;
import ds.assignment2.shoppingbackend.models.User;
import ds.assignment2.shoppingbackend.repositories.UserRepository;

@RestController
public class Usercontroller {

	@Autowired
	UserRepository userRepository;
	
	String id;

	@RequestMapping(method=RequestMethod.GET, value="/allusers")
    public Iterable<User> product() {
        return userRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addusers")
    public User save(@RequestBody User user) {
		
		userRepository.save(user);

        return user;
    }
			@RequestMapping(method = RequestMethod.GET, value = "/getusers/{email}")
			    public User show(@PathVariable String email) {
			        return userRepository.findByEmail(email);
			    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<?> login(@RequestBody User user) {
		System.out.println(user.toString());
		User userObj = userRepository.findByEmail(user.getEmail());
//        User login = userlogin.get();
		if(userObj != null) {
	        if(user.getEmail().equals( userObj.getEmail()) && user.getPassword().equals( userObj.getPassword())) {
	        	return new ResponseEntity<>(userObj, HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Invalid Password", HttpStatus.UNAUTHORIZED);
		}

        else {
        	
        	return new ResponseEntity<>("Invalid Email", HttpStatus.UNAUTHORIZED);
        
       }
    }
	 @RequestMapping(method = RequestMethod.GET, value = "/deleteuser/{email}")
	    public String delete(@PathVariable String email) {
		  User delete = userRepository.findByEmail(email);
	        userRepository.delete(delete);

	        return "";
	    }
	 
	 @RequestMapping(method = RequestMethod.POST, value = "/updateuser/{email}")
	    public User update(@PathVariable String email, @RequestBody User user) {
	        User res =  userRepository.findByEmail(email);
	        if (user.getFull_name() != null)
	            res.setFull_name(user.getFull_name());
	        if (user.getDate_of_birth() != null)
	            res.setDate_of_birth(user.getDate_of_birth());  
	        if (user.getEmail() != null)
	           res.setEmail(user.getEmail());
	        if (user.getPassword() != null)
	            res.setPassword(user.getPassword());
	        if (user.getGender() != null)
	            res.setGender(user.getGender());
	        userRepository.save(res);
	        return res;
	    }
}
