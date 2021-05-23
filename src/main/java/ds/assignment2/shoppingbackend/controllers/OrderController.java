package ds.assignment2.shoppingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ds.assignment2.shoppingbackend.models.Order;
import ds.assignment2.shoppingbackend.repositories.OrderRepository;


import java.util.Optional;

@RestController
public class OrderController {
	
	@Autowired
	OrderRepository orderRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/allOrders")
    public Iterable<Order> order() {
        return orderRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addOrders")
    public Order save(@RequestBody Order order) {
		orderRepository.save(order);
        return order;
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOrder/{id}")
    public Optional<Order> show(@PathVariable String id) {
        return orderRepository.findById(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateOrder/{id}")
    public Order update(@PathVariable String id, @RequestBody Order order) {
        Optional<Order> optOrder = orderRepository.findById(id);
        Order or = optOrder.get();
        if (order.getQty()!= 0)
            or.setQty(order.getQty());  
        if (or.getRname() != null)
            or.setRname(order.getRname());
        if (or.getAddress() != null)
            or.setAddress(order.getAddress());
        orderRepository.save(or);
        return or;
    }
	
	 @RequestMapping(method = RequestMethod.GET, value = "/deleteOrders/{id}")
	    public String delete(@PathVariable String id) {
	        Optional<Order> optOrder = orderRepository.findById(id);
	        Order order = optOrder.get();
	        orderRepository.delete(order);

	        return "";
	    }

}
