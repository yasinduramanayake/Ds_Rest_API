package ds.assignment2.shoppingbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ds.assignment2.shoppingbackend.models.Product;
import ds.assignment2.shoppingbackend.repositories.ProductRepository;

import java.util.Optional;

@RestController
public class ProductController {
	
	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/allproducts")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/addproducts")
    public Product save(@RequestBody Product product) {
        productRepository.save(product);

        return product;
    }

	@RequestMapping(method = RequestMethod.GET, value = "/getProduct/{id}")
    public Optional<Product> show(@PathVariable String id) {
        return productRepository.findById(id);
    }
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateProduct/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {
        Optional<Product> optProduct = productRepository.findById(id);
        Product pro = optProduct.get();
        if (product.getName() != null)
            pro.setName(product.getName());
        if (product.getPrice() != 0L)
            pro.setPrice(product.getPrice());  
        if (product.getVentor() != null)
            pro.setVentor(product.getVentor());
        if (product.getImg() != null)
            pro.setImg(product.getImg());
        if (product.getDescription() != null)
            pro.setDescription(product.getDescription());
        productRepository.save(pro);
        return pro;
    }
	
	 @RequestMapping(method = RequestMethod.GET, value = "/deleteproducts/{id}")
	    public String delete(@PathVariable String id) {
	        Optional<Product> optProduct = productRepository.findById(id);
	        Product product = optProduct.get();
	        productRepository.delete(product);

	        return "";
	    }
}
