package model;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver extends Person {

	private Location location;
	private boolean status;
	private List<Car> cars;
	private Car equippedCar;
	private Ride currentRide;
	
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
	public void addCar(Car car) {
		cars.add(car);
	}

	public Car getEquippedCar() {
		return equippedCar;
	}

	public void setEquippedCar(Car equippedCar) {
		this.equippedCar = equippedCar;
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
