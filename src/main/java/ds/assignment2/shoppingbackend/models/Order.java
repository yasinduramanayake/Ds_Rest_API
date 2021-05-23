package ds.assignment2.shoppingbackend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")

public class Order {
	
	@Id
	String id;
    String pname;
    double price;
    String email;
    int qty;
    String rname;
    String address;
    
    
	public Order() {
	
	}

	public Order(String pname, double price, String email, int qty, String rname, String address) {
		this.pname = pname;
		this.price = price;
		this.email = email;
		this.qty = qty;
		this.rname = rname;
		this.address = address;
	}
    
	public String getId() {
		return id;
	}

	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public String getRname() {
		return rname;
	}


	public void setRname(String rname) {
		this.rname = rname;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
}
