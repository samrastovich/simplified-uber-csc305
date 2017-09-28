package model;

public class Map {
	
	private Location[] grid;
	
	public Map() {
		this.grid = new Location[300];
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
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
		if (location.getX() > 299 || location.getX() < 0
				|| location.getY() > 299 || location.getY() < 0)
			return false;
		return true;
	}
	
	
	
	
}
