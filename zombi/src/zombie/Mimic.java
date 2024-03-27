package zombie;

import java.util.Random;

public class Mimic extends Monster implements Damageable{

	public Mimic() {
		super("미믹", 50, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void skill(Player player) {
		System.out.println("미믹의 랜덤공격이 시작됩니다.");
		int ranNum = 0;
		for (int i = 0; i < 3; i++) {
			ranNum = new Random().nextInt(20)+1;
			System.out.println("ranNum...");
		}
		System.out.println(ranNum + " !!!!");
		
		System.out.println("미믹이 당신의 힘을 " + ranNum + "으로 고정하였습니다.");
		player.setPower(ranNum);
	}

}
