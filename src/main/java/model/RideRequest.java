package model;

public class RideRequest {
	
	private Passenger passenger; 
	private Driver driver;
	private Location destination;
	private Location origin;
	
	public RideRequest(Passenger passenger, Location origin, Location destination) {
		this.passenger = passenger;
		this.destination = destination;
		this.origin = origin;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}
	
	
}
