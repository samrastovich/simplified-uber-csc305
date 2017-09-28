package model;

import java.util.List;

public class Driver extends Person {

	private Location location;
	private boolean status;
	private List<Car> cars;
	
	public Driver(String firstName, String lastName) {
		super(firstName, lastName);
	}
	
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean hasRoute) {
		this.status = hasRoute;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
			
}
