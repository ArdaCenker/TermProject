package tower;

import java.util.ArrayList;

import enemy.Enemy;

public class SingleShotTower extends Tower {

	public SingleShotTower(double positionX, double positionY) {
		super(positionX, positionY);
		this.setPrice(50);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	// shoot method should be called in every frame
	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// to keep track of the shortest distance
		double shortestDistance = calculateDistance(enemies.getFirst());
		// to keep track of the index of closest enemy
		int shortestIndex = 0;

		// for loop make sure we know the closest enemy to the tower
		for(int i = 1; i < enemies.size(); i++) {
			if (calculateDistance(enemies.get(i)) <= shortestDistance)
			{
				shortestIndex = i;
				shortestDistance = calculateDistance(enemies.get(i));
			}
		}

		// if enough time passed from the last shot and enemy's health > 0
		if (canShoot() && enemies.get(shortestIndex).getHealth() > 0)
		{
			// sets target to the closest enemy, if it is in the range
			if (calculateDistance(enemies.get(shortestIndex)) <= this.getRange())
			{
				// Create a projectile
				Projectile projectile = new Projectile(10, this);
				setTarget(enemies.get(shortestIndex));

				// projectile object calls hit method to hit closest enemy
				projectile.hit(enemies.get(shortestIndex));
			}

		}
	}

	@Override
	public void target(Enemy enemy) {
		//if enemy is in range, it becomes target
		if(calculateDistance(enemy) <= getRange()) {
			setTarget(enemy);
		}
	}
}
