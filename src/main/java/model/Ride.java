package model;

public class Ride {
	
	private RideRequest request;
	private double distance;
	private double payRate;
	
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
	public void cancel() {
		
	}
	
}
