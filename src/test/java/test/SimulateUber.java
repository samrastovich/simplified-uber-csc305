package test;

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
	private Passenger passenger;
	
	public SimulateUber(List<Driver> drivers, Passenger passenger) {
		this.drivers = drivers;
		this.passenger = passenger;
	}
	
	public void run() {
		Random rand = new Random();
		Location destination = new Location(rand.nextInt(300), rand.nextInt(300));
		RideRequest request = passenger.requestRide(destination);
		
		
	}
	
	public static void main(String[] args) {
		Person tim = new Driver("Tim", "Smith");
		Person dave = new Driver("Dave", "Barkley");
		Person dylan = new Driver("Dylan", "Broseph");
		Person michelle = new Driver("Michelle", "Rider");
		Person tony = new Driver("Tony", "McGregor");
			
		Person chad = new Passenger("Chad", "Grep");
		Person derek = new Passenger("Derek", "Smith");
		Person rachel = new Passenger("Rachel", "Dong");
		Person mady = new Passenger("Maddy", "Bird");
		Person gary = new Passenger("Gary", "Bacchus");
		
		List<Person> passengers = new ArrayList<Person>();
		List<Person> drivers = new ArrayList<Person>();
		passengers.addAll(Arrays.asList(chad, derek, rachel, mady, gary));
		drivers.addAll(Arrays.asList(tim, dave, dylan, michelle, tony));
		
		chad.setBalance(45);
		derek.setBalance(-10);
		rachel.setBalance(23);
		mady.setBalance(0);
		gary.setBalance(100);	
		tim.setBalance(100);	
	}
	
}
