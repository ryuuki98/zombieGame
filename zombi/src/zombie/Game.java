package zombie;

import java.util.Random;
import java.util.Scanner;

public class Game {
	private final int END_FLOOR = 50;
	
	private final int ATTACK_MONSTER = 1;
	private final int USE_ITEM = 2;
	private final int PLAYER_STATUS = 1;
	private final int PLAYER_MOVE = 2;
	private static Game instance = new Game();
	private Player player;

	private Game() {
		player = new Player();
	}

	public static Game getInstance() {
		return instance;
	}

	public void run() {
		while (isRun()) {
			printMenu();
			int select = inputNumber("menu");
			runMeun(select);
		}
		printResult();
	}

	private void printResult() {
		if (!player.isDead()) {
			printPlayerLocation();
			System.out.println("클리어 했습니다 ~ ");
		}
	}

	private boolean isRun() {
		if (player.isDead()) {
			System.out.println("플레이어가 사망하여 게임이 종료됩니다.");
			return false;
		}

		return player.getLocation() < END_FLOOR-1;
	}

	private void runMeun(int select) {
		if (select == PLAYER_STATUS) {
			printPlayerStatus();
		} else if (select == PLAYER_MOVE) {
			movePlayer();
			if (player.getLocation() % 3 == 0) {
				Monster monster = new Monster();
				battle(monster);
			} else {
				occurredEvent();
			}
		}
	}

	private void occurredEvent() {
		int ranNumber = new Random().nextInt(3) + 1;
		if (ranNumber == 1) {
			goodEvent();
		} else if (ranNumber == 2) {
			badEvent();
		} else if (ranNumber == 3) {
			randomEvent();
		}
	}

	private void randomEvent() {
		System.out.println("랜덤이벤트");
	}

	private void badEvent() {
		System.out.println("나쁜 이벤트");
	}

	private void goodEvent() {
		System.out.println("좋은 이벤트");
	}

	private void battle(Monster monster) {
		System.out.println("야생의 적 " + monster.getName() + "이 나타났다 ! ");
		while (!monster.isDead() && !player.isDead()) {
			System.out.println("==================");		
			System.out.println(player);
			System.out.println(monster);
			System.out.println("==================");
			printBattleMenu();
			int select = inputNumber("menu");
			runBattleMenu(select,monster);
		}
		if (monster.dropPotion()) {
			player.setPotionCountPlus();
			System.out.println("몬스터가 포션을 드랍했어요 !");
			
		}

	}

	private void runBattleMenu(int select, Monster monster) {
		if (select == ATTACK_MONSTER) {
			attack(monster);
		} else if (select == USE_ITEM) {
			useItem();
		}
	}

	private void useItem() {
		if (player.getPotionCount() == 0) {
			System.out.println("현재 가진 포션이 없습니다.");
			return;
		}
		System.out.println("현재 포션 갯수 : " + player.getPotionCount());
		int option = inputNumber("포션을 사용하시겠습니까 ? y : 1 n : 0");
		if (option == 1) {
			player.usePotion();
		}
	}

	private void attack(Monster monster) {
		player.attack(monster);
		if (!monster.isDead()) {
			monster.attack(player);
		}
	}

	private void printBattleMenu() {
		System.out.println("[1]공격");
		System.out.println("[2]아이템 사용");
	}

	private void movePlayer() {
		Random random = new Random();
		int ranNumber = random.nextInt(5) + 1;
		player.setLocation(ranNumber);
		System.out.printf("플레이어는 %d만큼 이동했다...\n", ranNumber);
	}

	private void printPlayerStatus() {
		System.out.println(player);
	}

	private int inputNumber(String message) {
		int number = 0;
		System.out.print(message + " : ");
		try {
			String numberString = new Scanner(System.in).next();
			number = Integer.parseInt(numberString);
		} catch (Exception e) {
			System.out.println("숫자를 입력하세요");
			return inputNumber(message);
		}
		return number;
	}

	private void printMenu() {
		printPlayerLocation();
		System.out.println("[1]플레이어 상태 확인");
		System.out.println("[2]이동");
	}

	private void printPlayerLocation() {
		for (int i =0; i <END_FLOOR; i++) {
			if (i == player.getLocation()) {
				System.out.print("⎝ᑒ⎠");
			}else if (i == END_FLOOR-1) {
				System.out.print("|GOAL|");
			}
			else {
				System.out.print("_ ");
			}
		}
		System.out.println();
	}
}
