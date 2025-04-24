package tower;

import java.util.ArrayList;

import enemy.Enemy;

public abstract class Tower {
	
	private int price;
	private double range;
	private double fireRate;
	private double positionX;
	private double positionY;
	
	public Tower(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public double getRange() {
		return range;
	}
	
	public void setRange(double range) {
		this.range = range;
	}
	
	public double getFireRate() {
		return fireRate;
	}

	public void setFireRate(double fireRate) {
		this.fireRate = fireRate;
	}
	
	public double getPositionX() {
		return positionX;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionY() {
		return positionY;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public abstract void shoot(ArrayList<Enemy> enemies);
	
}
