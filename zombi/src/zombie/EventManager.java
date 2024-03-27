package zombie;

import java.util.Random;
import java.util.Scanner;

public class EventManager {
	private final int GO_DOWN_FAST = 1;
	private final int WASTE_POTION = 2;
	private final int WEAKNESS = 3;
	
	private final int GET_POTION = 1;
	private final int GET_POWER = 2;
	private final int GO_UP_FAST = 3;
	private Player player;

	public EventManager() {
		player = Game.getPlayer();
	}

	public void goodEvent() {
		int ranNum = new Random().nextInt(3) + 1;
		if (ranNum == GET_POTION) {
			getPotion();
		} else if (ranNum == GET_POWER) {
			getPower();
		} else if (ranNum == GO_UP_FAST) {
			goUp();
		}
	}

	private void goUp() {
		엘레베이터();
		String answer = inputYesOrNo();
		if (answer.equals("y")) {
			System.out.println("순식간에 탑의 5층을 올랐습니다");
			player.setLocation(player.getLocation() + 4);
		}else if (answer.equals("n")) {
			System.out.println("당신은 걸어가기를 택했습니다.");
			System.out.println("당신의 기대수명이 늘어났습니다. (hp는 안늘어났어요 ㅎㅎ. .)");
		}
	}

	private void 엘레베이터() {
		System.out.println("탑의 계단 아래, 그림자 밑에서 엘레베이터를 발견하였습니다.");
		System.out.println("엘레베이터를 타시겠습니까 ? (y/n)");
	}

	private void getPower() {
		System.out.println("희미한 빛이 당신의 몸을 감싸며 기운을 불어넣고 있습니다.");
		System.out.println("힘이 5 상승합니다");
		player.setPower(player.getPower() + 5);
	}

	private void getPotion() {
		쓰러진소녀();
		String answer = inputYesOrNo();
		if (answer.equals("y")) {
			player.setPotionCountPlus();
			System.out.println("소녀는 고맙다며 포션을 선물하였습니다.");
			System.out.println("착한 마음씨로 삽시다.");
		}else if (answer.equals("n")) {
			System.out.println("소녀는 싸늘하게 죽어갑니다.");
			System.out.println("나쁜사람");
		}
	}

	private void 쓰러진소녀() {
		System.out.println("탑 구석에 쓰러진 소녀가 있습니다. ");
		System.out.println("구하시겠습니까 ? (y/n)");
	}

	private String inputYesOrNo() {
		String answer = new Scanner(System.in).next();
		
		if (answer.equals("y") || answer.equals("n")) {
			return answer;
		}
		
		System.out.println("y/n으로 입력 해주십시요");
		return inputYesOrNo();
	}

	public void badEvent() {
		int ranNum = new Random().nextInt(3);
		if (ranNum == GO_DOWN_FAST) {
			goDown();
		} else if (ranNum == WASTE_POTION) {
			wastePotion();
		} else if (ranNum == WEAKNESS) {
			getWeakness();
		}
	}

	private void getWeakness() {
		System.out.println("당신은 무슨무슨 병에 걸려 힘이 빠집니다.");
		System.out.println("이유가 뭐냐구요 ? 그런건 없습니다.");
		System.out.println("원래 이유없이 고통받는게 삶 아닌가요 ");
		int power = player.getPower() - 3;
		if (power <= 0) {
			return;
		}
		
		player.setPower(power);
	}

	private void wastePotion() {
		쓰러진소녀();
		String answer = inputYesOrNo();
		if (answer.equals("y")) {
			player.setPotionCountPlus();
			System.out.println("소녀는 구해줘서 고마운데 목이 너무 말라 혹시 포션이 있냐고 물었습니다.");
			System.out.println("그러더니 소녀는 당신의 주머니에 손을 넣어 포션을 몽땅 마셔버렸습니다.");
			System.out.println("사람을 봐가면서 도와줍시다");
			while (!(player.getPotionCount() == 0)) {
				player.setPotionCountMinus();
			}
		}else if (answer.equals("n")) {
			System.out.println("소녀는 싸늘하게 죽어갑니다.");
			System.out.println("근데 사실 살렸으면 님 포션 다먹었음");
		}		
	}

	private void goDown() {
		엘레베이터();
		String answer = inputYesOrNo();
		if (answer.equals("y")) {
			System.out.println("엘레베이터가 덜컹거리더니 이윽고 추락하였습니다");
			System.out.println("계단 이용을 생활화 합시다");
			if (player.getLocation() - 4 < 0) {
				return;
			}
			player.setLocation(player.getLocation() - 4);
		}else if (answer.equals("n")) {
			System.out.println("당신은 걸어가기를 택했습니다.");
			System.out.println("당신의 기대수명이 늘어났습니다. (hp는 안늘어났어요 ㅎㅎ. .)");
		}
	}


}
