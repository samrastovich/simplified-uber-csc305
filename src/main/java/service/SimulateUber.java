package service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import model.Driver;
import model.Location;
import model.Passenger;
import model.Person;
import model.RideRequest;

public class SimulateUber implements Runnable {
	
	private List<Driver> drivers;
	private double rate;
	
	public SimulateUber(double rate) {
		this.rate = rate;
	}
	
	public SimulateUber(List<Driver> drivers, Passenger passenger) {
		this.drivers = drivers;
	}
	
	public Driver findClosestDriver(RideRequest request) {
		Driver closest = drivers.get(0);
		double min = drivers.get(0).getLocation().calculateDistance(request.getOrigin());
		for (int i = 1; i < drivers.size(); i++) {
			if (drivers.get(i).getLocation().calculateDistance(request.getOrigin()) < min)
				closest = drivers.get(i);
		}
		return closest;
	}
	
	
	
	
	public void run() {
		Random rand = new Random();
		
		Location destination = new Location(rand.nextInt(300), rand.nextInt(300));
			
		
	}
	
	
}
