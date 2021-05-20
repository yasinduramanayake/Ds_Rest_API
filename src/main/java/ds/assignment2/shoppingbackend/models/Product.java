package ds.assignment2.shoppingbackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")

public class Product {
	
	@Id
	String id;
    String name;
    double price;
    String ventor;
    String img;
    String description;
    
	public Product() {

	}

	public Product(String name, double price, String ventor, String img,String description) {
		this.name = name;
		this.price = price;
		this.ventor = ventor;
		this.img = img;
		this.description = description;
	}

	 public String getId() {
	        return id;
	 }
	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVentor() {
		return ventor;
	}

	public void setVentor(String ventor) {
		this.ventor = ventor;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
    
}
