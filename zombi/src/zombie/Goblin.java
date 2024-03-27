package zombie;

import java.util.Random;

public class Goblin extends Monster implements Damageable{

	public Goblin() {
		super("고블린", 100, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void skill(Player player) {
		int ranNum = new Random().nextInt(5);
		if (ranNum < 1) {
			System.out.println("고블린이 당신의 물약을 강탈했습니다.");
			player.setPotionCountMinus();
		}
	}

}
