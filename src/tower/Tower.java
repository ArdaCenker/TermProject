package tower;

import java.util.ArrayList;

import enemy.Enemy;

public abstract class Tower {
	
	private int price;
	private int bulletDamage;
	private double range;
	private double fireRate;
	private double positionX;
	private double positionY;
	private long shootInterval = Long.MAX_VALUE;
	private long lastShotTime = 0;
	private Enemy target;
	
	public Tower(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.bulletDamage = 10;
		this.shootInterval = (long)(1000.0 / fireRate);
	}
	
	public long getShootInterval() {
		return shootInterval;
	}

	public void setShootInterval(long shootInterval) {
		this.shootInterval = shootInterval;
	}

	public long getLastShotTime() {
		return lastShotTime;
	}

	public void setLastShotTime(long lastShotTime) {
		this.lastShotTime = lastShotTime;
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
	    this.shootInterval = (long)(1000.0 / fireRate);
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

	public int getBulletDamage() {
		return bulletDamage;
	}

	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}
	

	public Enemy getTarget() {
		return target;
	}

	public void setTarget(Enemy target) {
		this.target = target;
	}
	
	//checks the shootInterval is passed and sets lastShotTime to now
	public boolean canShoot() {
	    long now = System.currentTimeMillis();
	    if (now - lastShotTime >= shootInterval) {
	        lastShotTime = now;
	        return true;
	    }
	    return false;
	}
	
	public abstract void shoot(ArrayList<Enemy> enemies);
	
	public abstract void target(Enemy enemy);
	
	//finds distance between enemy and tower
	public double calculateDistance(Enemy enemy) {
		double distance = Math.sqrt(
				Math.pow(enemy.getLocation_x() - getPositionX(),2) + 
				Math.pow(enemy.getLocation_y() - getPositionY(),2));
		
		return distance;
	}

}
