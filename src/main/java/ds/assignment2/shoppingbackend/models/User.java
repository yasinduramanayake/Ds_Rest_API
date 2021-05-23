package ds.assignment2.shoppingbackend.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")

public class User {

	@Id
	ObjectId  id;
    String  full_name;
    String  mobile;
    String  date_of_birth;
	String  email;
    String  password;
    
    public User() {
	
	
	}
    public User(ObjectId id, String full_name, String mobile, String date_of_birth, String email,
			String password) {
		super();
		this.id = id;
		this.full_name = full_name;
		this.mobile = mobile;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.password = password;
		
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", full_name=" + full_name + ", mobile=" + mobile + ", date_of_birth=" + date_of_birth
				+ ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
}
