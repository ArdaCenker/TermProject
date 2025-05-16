package tower;

import java.util.ArrayList;
import java.util.Arrays;

import enemy.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

//150123012 Arda Cenker Karagöz - 150124005 Talha Zencirkıran
public abstract class Tower {
	
	private int price;
	private int bulletDamage;
	private double range;
	private double fireRate;
	private Point2D position;
	private long shootInterval = Long.MAX_VALUE;
	private long lastShotTime = 0;
	private Enemy target;
	
	public Tower(Point2D position) {
		this.position = position;
		this.bulletDamage = 10;
		this.shootInterval = (long)(1000.0 / fireRate);
	}

	public Point2D getPosition() {return position;}
	
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

	public double calculateDistance(Point2D otherPoint) {
		return this.position.distance(otherPoint);
	}

	// TODO: To be implemented
	public int[] closestEnemiesIndices(ArrayList<Enemy> enemies)
	{
		// to keep track of originalIndexes
		int[] indices = new int[enemies.size()];
		// to keep track of distances
		double[] distances = new double[enemies.size()];
		// copy of distances as sorted
		double[] sortedDistances = distances.clone();

		// Assign each value to distances and originalIndexes arrays
		for (int i = 0; i < enemies.size(); i++) {
			distances[i] = this.position.distance(enemies.get(i).getPosition());
		}

		// sort sortedDistances
		Arrays.sort(sortedDistances);
		// compares distances and sortedDistances and assigns indices array's values according to original indices
		for (int i = 0; i < enemies.size(); i++) {

			for (int j = 0; j < distances.length; j++) {
				if (sortedDistances[i] == distances[j]) {
					indices[i] = j;
				}
			}
		}

		return indices;
	}

	public abstract Pane drawTower();


}

