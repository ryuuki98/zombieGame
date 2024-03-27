package zombie;

abstract class Unit{
	private int maxHp;
	private String name;
	private int hp;
	private int power;
	private boolean isDead;
	
	public Unit(String name, int hp, int power) {
		this.hp = hp;
		this.name = name;
		this.power = power;
		maxHp = hp;
	}
	public String getName() {
		return name;
	}	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
		if (this.hp<=0) {
			this.hp = 0;
			this.isDead = true;
			System.out.println(this.name + " 사망");
		}
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}


	
	public boolean isDead() {
		return isDead;
	}
	
	
	
	
	abstract public void attack(Damageable unit);
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s [%d/%d]",this.name , this.hp,this.maxHp);
	}
	
}
