package zombie;

abstract class Unit{
	private final int MAX_HP;
	private String name;
	private int hp;
	private int power;
	
	public Unit(String name, int hp, int power) {
		this.hp = hp;
		this.name = name;
		this.power = power;
		MAX_HP = hp;
	}
	
}
