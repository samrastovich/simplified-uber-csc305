package model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Passenger of Uber
 * @author samrastovich
 *
 */
public class Passenger extends Person {
	
	private Location location;
	private List<Rating> ratings;
	 
	public Passenger(String firstName, String lastName, double balance) {
		super(firstName, lastName, balance);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	} 
	
	public RideRequest requestRide(Location destination) {
		RideRequest request = new RideRequest(this, location, destination);
		
		return request;	
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
