package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Driver;
import model.Location;
import model.Passenger;
import service.SimulateUber;

/**
 * Testing class
 * @author samrastovich
 *
 */
public class UberTest {
	
	public static void main(String[] args) {
		
		List<Driver> drivers = new ArrayList<Driver>();
		List<Passenger> passengers = new ArrayList<Passenger>();
		List<SimulateUber> ubers = new ArrayList<SimulateUber>();
		
		try {
			Scanner in = new Scanner(new File("drivers.txt"));
			
			while (in.hasNextLine()) {
				String next = in.nextLine();
				String[] split = next.split(" ");
				Driver driver = new Driver(split[1], split[0], Double.parseDouble(split[2]));
				driver.setLocation(new Location(Integer.parseInt(split[3]), Integer.parseInt(split[4])));
				drivers.add(driver);
			}
			
			in = new Scanner(new File("passengers.txt"));
			while (in.hasNextLine()) {
				String next = in.nextLine();
				String[] split = next.split(" ");
				Passenger passenger = new Passenger(split[1], split[0], Double.parseDouble(split[2]));
				passenger.setLocation(new Location(Integer.parseInt(split[3]), Integer.parseInt(split[4])));
				passengers.add(passenger);
				ubers.add(new SimulateUber(drivers, passenger, 2.00));
			}
			
			in.close();
			
			

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Passenger driver: passengers) {
			System.out.println(driver.toJson());
		}
		
		
	}
}
