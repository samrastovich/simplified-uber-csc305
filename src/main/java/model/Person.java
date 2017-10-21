package model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private List<Rating> ratings;
	private double balance;
	
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAverageRating() {
		double total = 0;
		for (Rating rating: this.getRatings()) {
			total += rating.getRating();
		}
		return total / this.getRatings().size();
	}
	public boolean compare(Person other) {
		boolean res = false;
		if (other.getAverageRating() > this.getAverageRating()) {
			res = true;
		}
		return res; 
	}
	public boolean pay(double amount, Person other) {
		if (this.balance - amount < 0) {
			return false;
		
		} else {
			this.balance -= amount;
			other.balance += amount;
			return true;
		}		
	}
	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		String json = null;
		
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
			
		} catch(JsonGenerationException e) {
			e.printStackTrace();
		} catch(JsonMappingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return json;
	}
	
}
