package zombie;

import java.util.Random;

public class Monster extends Unit implements Damageable {

	public Monster() {
		super("", 0, 0);
		int ran = new Random().nextInt(3);
		if (ran == 0) {
			this.setName("Mob1");
			this.setMaxHp(10);
			this.setHp(10);
			this.setPower(100);
		} else if (ran == 1) {
			this.setName("Mob2");
			this.setMaxHp(20);
			this.setHp(20);
			this.setPower(100);
		} else if (ran == 2) {
			this.setName("Mob3");
			this.setMaxHp(30);
			this.setHp(30);
			this.setPower(100);
		}
	}

}
