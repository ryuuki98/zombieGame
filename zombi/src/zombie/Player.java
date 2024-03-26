package zombie;

import java.util.Random;

public class Player extends Unit {
	private int location;
	public Player() {
		super("Player", 100, 5);
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = this.location + location;
	}

	

}
