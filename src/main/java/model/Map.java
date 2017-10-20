package model;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Map {
	
	private Location[] grid;
	private int size;
	
	public Map(int size) {
		this.size = size;
		this.grid = new Location[size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i] = new Location(i, j);
			}
		}		
	}

	public Location[] getGrid() {
		return grid;
	}

	public void setGrid(Location[] grid) {
		this.grid = grid;
	}
	
	public boolean inGrid(Location location) {
		if (location.getX() > (size -1) || location.getX() < 0
				|| location.getY() > (size - 1) || location.getY() < 0)
			return false;
		return true;
	}
	
	public void draw() {
		
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
