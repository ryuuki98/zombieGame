package zombie;

import java.util.Random;

public class Monster extends Unit {

	public Monster(String name, int hp, int power) {
		super(name, hp, power);
	}
	public boolean dropPotion() {
		int ranNumber = new Random().nextInt(10);
		if (ranNumber < 2) {
			return true;
		}
		return false;
	}
	@Override
	public void attack(Damageable unit) {
		Unit target = (Unit) unit;
		int hp = target.getHp() - super.getPower() * 5;
		System.out.printf("%s는 %d의 데미지를 입혔다\n",super.getName(),super.getPower() * 5);
		target.setHp(hp);
		
	}

}
