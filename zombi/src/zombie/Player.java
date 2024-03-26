package zombie;

import java.util.Random;

public class Player extends Unit implements Damageable {
	private int location;
	private int potionCount;
	public Player() {
		super("Player", 300, 5);
		potionCount = 3;
	}
	
	public int getPotionCount() {
		return potionCount;
	}
	public void setPotionCountPlus() {
		this.potionCount = this.potionCount + 1;
		
	}
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = this.location + location;
		if (this.location>=50) {
			this.location = 49;
		}
	}

	public void usePotion() {
		this.potionCount = this.potionCount - 1;
		int hp = this.getHp() + 100 <= 300 ? this.getHp() + 100 : 300;
		this.setHp(hp);
		System.out.println("포션 사용");
	}

	

}
