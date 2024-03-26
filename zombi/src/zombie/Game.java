package zombie;

import java.util.Random;
import java.util.Scanner;

public class Game {
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
	}

	private boolean isRun() {

		return player.getLocation() < 100;
	}

	private void runMeun(int select) {
		if (select == PLAYER_STATUS) {
			printPlayerStatus();
		} else if (select == PLAYER_MOVE) {
			movePlayer();
			if (player.getLocation() % 5 == 0) {
				battle();
			}else {
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

	private void battle() {
		System.out.println("배틀하게 되었다");
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
		System.out.println("플레이어 현재 위치 : " + player.getLocation());
		System.out.println("[1]플레이어 상태 확인");
		System.out.println("[2]이동");
	}
}
