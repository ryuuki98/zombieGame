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
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getmaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	
	
	public void attack(Damageable unit) {
		Unit target = (Unit) unit;
		int hp = target.getHp() - this.power * 5;
		target.setHp(hp);
		System.out.printf("%s는 %d의 데미지를 입혔다\n",this.name,this.power * 5);
		if (target.getHp() <= 0) {
			target.isDead = true;
			System.out.println(target.getName() + "은 쓰러졌다 ! ");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s [%d/%d]",this.name , this.hp,this.maxHp);
	}
	
}
