package zombie;

public class Magician extends Monster implements Damageable{

	public Magician() {
		super("매지션", 30, 8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void skill(Player player) {
		System.out.println("매지션은 마법을 통해 본인의 힘을 1 상승시켰습니다.");
		super.setPower(super.getPower() + 1);
	}

}
