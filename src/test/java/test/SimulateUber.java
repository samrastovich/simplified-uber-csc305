package test;

import model.Driver;
import model.Passenger;
import model.Person;

public class SimulateUber implements Runnable {
	
	public void run() {
		Driver tim = new Driver("Tim", "Smith");
		Driver dave = new Driver("Dave", "Barkley");
		Driver dylan = new Driver("Dylan", "Broseph");
		Driver michelle = new Driver("Michelle", "Rider");
			
		Person chad = new Passenger("Chad", "Grep");
		chad.setBalance(45);
		
		
	}
	
}
