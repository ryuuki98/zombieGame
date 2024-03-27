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
	public void setPotionCountMinus() {
		this.potionCount = potionCount-1;
	}
	
	
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
		if (this.location>=30) {
			this.location = 29;
		}
	}

	public void usePotion() {
		this.potionCount = this.potionCount - 1;
		int hp = this.getHp() + 100 <= 300 ? this.getHp() + 100 : 300;
		this.setHp(hp);
		System.out.println("포션 사용");
	}

	@Override
	public void attack(Damageable unit) {
		Unit target = (Unit) unit;
		int damage = (int) (super.getPower() * 5 * Math.random());
		int hp = (int) (target.getHp() - damage);
		System.out.printf("%s는 %d의 데미지를 입혔다\n",super.getName(),damage);
		target.setHp(hp);
	}

	

}
