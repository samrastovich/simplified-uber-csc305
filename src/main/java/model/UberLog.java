package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Logs the information for the rides of the day 
 * @author samrastovich
 *
 */
public class UberLog {
	
	private List<Driver> drivers;
	
	public UberLog() {
		this.drivers = new ArrayList<Driver>();
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> rides) {
		this.drivers = rides;
	}
	
	public void addDriver(Driver driver) {
		drivers.add(driver);
	}
	
	public void writeToFile(String fileName) {
		try {
			FileOutputStream out = new FileOutputStream(fileName);
			String json = toJson();
			System.out.println(json);
			byte[] toBytes = toJson().getBytes();
			out.write(toBytes);
			
			out.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
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
