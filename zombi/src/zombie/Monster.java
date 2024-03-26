package zombie;

import java.util.Random;

public class Monster extends Unit implements Damageable {

	public Monster() {
		super("", 0, 0);
		int ran = new Random().nextInt(3);
		if (ran == 0) {
			this.setName("Mob1");
			this.setMaxHp(30);
			this.setHp(30);
			this.setPower(1);
		} else if (ran == 1) {
			this.setName("Mob2");
			this.setMaxHp(40);
			this.setHp(40);
			this.setPower(2);
		} else if (ran == 2) {
			this.setName("Mob3");
			this.setMaxHp(50);
			this.setHp(50);
			this.setPower(3);
		}
	}
	public boolean dropPotion() {
		int ranNumber = new Random().nextInt(3);
		if (ranNumber < 1) {
			return true;
		}
		return false;
	}

}
