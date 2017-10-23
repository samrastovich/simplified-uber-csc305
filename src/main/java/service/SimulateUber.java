package service;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Driver;
import model.Location;
import model.Map;
import model.Passenger;
import model.RideRequest;

/**
 * Uber simulation that implements the simplified uber 
 * @author samrastovich
 *
 */
public class SimulateUber implements Runnable {
	
	private List<Driver> drivers;
	private double rate;
	private Map map;
	private Passenger passenger;
	private LinkedList<Driver> priorityQueue;
	
	
	public SimulateUber(List<Driver> drivers, Passenger passenger, double rate) {
		this.rate = rate;
		this.drivers = drivers;
		this.passenger = passenger;
		this.rate = rate;
	}
	
	public void orderDrivers(RideRequest request) {				
		double min = drivers.get(0).getLocation().calculateDistance(request.getOrigin());
		for (Driver driver: drivers) {
			if (driver.getLocation().calculateDistance(request.getOrigin()) < min && !driver.getStatus())
				priorityQueue.addFirst(driver);
		}
	}
	
	
	public void run() {
		Random rand = new Random();
		
		Location destination = new Location(rand.nextInt(300), rand.nextInt(300));
		RideRequest request = passenger.requestRide(destination);
		orderDrivers(request);
		Driver driver = priorityQueue.get(0);
		
		driver.acceptRide(request);
		
		
		
		
		
			
		
	}
	
	
}
