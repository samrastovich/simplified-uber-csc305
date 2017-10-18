package model;

import java.util.List;

public class Passenger extends Person {
	
	private Location location;
	private List<Rating> ratings;
	 
	public Passenger(String firstName, String lastName) {
		super(firstName, lastName);
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
}
