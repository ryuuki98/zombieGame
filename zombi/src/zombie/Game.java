package zombie;

public class Game {
	private static Game instance = new Game();
	private Unit player;
	private Game() {
		player = new Player();
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	public void run() {
		while (true) {

		}
	}
}
