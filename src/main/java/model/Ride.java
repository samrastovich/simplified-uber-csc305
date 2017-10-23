package model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Ride Request becomes Ride after a driver has accepted. 
 * @author samrastovich
 *
 */
public class Ride {
	
	private RideRequest request;
	private double distance;
	private double payRate;
	private Driver driver;
	
	public Ride(RideRequest request) {
		this.request = request;
	}
	
	public RideRequest getRequest() {
		return request;
	}

	public void setRequest(RideRequest request) {
		this.request = request;
	}

	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public double getPayRate() {
		return payRate;
	}
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}
	public double calculateRideCost() {
		return distance * payRate;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
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
