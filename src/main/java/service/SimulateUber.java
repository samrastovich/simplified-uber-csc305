package service;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.Driver;
import model.Location;
import model.Map;
import model.Passenger;
import model.Rating;
import model.RideRequest;
import model.UberLog;

/**
 * Uber simulation that implements the simplified uber 
 * @author samrastovich
 *
 */
public class SimulateUber extends Thread {
	
	private List<Driver> drivers;
	private double rate;
	private Map map;
	private Passenger passenger;
	private LinkedList<Driver> priorityQueue;
	private UberLog log;
	
	
	public SimulateUber(List<Driver> drivers, Passenger passenger, UberLog log, double rate) {
		this.rate = rate;
		this.drivers = drivers;
		this.passenger = passenger;
		this.rate = rate;
		this.map = new Map(300);
		this.log = log;
		this.priorityQueue = new LinkedList<Driver>(drivers);
	}
	
	public void orderDrivers(RideRequest request) {				
		double min = drivers.get(0).getLocation().calculateDistance(request.getOrigin());
		double rating = drivers.get(0).getAverageRating();
		
		for (Driver driver: drivers) {
			double distance = driver.getLocation().calculateDistance(request.getOrigin());
			
			if (distance < min && !driver.getStatus()) {
				priorityQueue.addFirst(driver);
			} 
			
		}
	}
	

	public void run() {
		Random rand = new Random();
			
		Location destination = new Location(rand.nextInt(300), rand.nextInt(300));
		RideRequest request = passenger.requestRide(destination);
		orderDrivers(request);
		Driver driver = priorityQueue.get(0);
		
		driver.acceptRide(request);
		if (passenger.pay(10, driver)) {
			try {
				Thread.sleep(1000);
				passenger.rate(new Rating(rand.nextInt(5) + 1), driver);
				driver.endRide();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			driver.cancelRide();
			
		}
		log.addDriver(driver);	
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public LinkedList<Driver> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(LinkedList<Driver> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}

	public UberLog getLog() {
		return log;
	}

	public void setLog(UberLog log) {
		this.log = log;
	}
	
	
	
	
}
