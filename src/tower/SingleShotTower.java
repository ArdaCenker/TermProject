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
		double shortestDistance = 0;
		// to keep track of the index of closest enemy
		int shortestIndex = 0;

		// for loop make sure we know the closest enemy to the tower
		for(int i = 0; i < enemies.size(); i++) {
			if (calculateDistance(enemies.get(i)) >= shortestDistance)
			{
				shortestIndex = i;
				shortestDistance = calculateDistance(enemies.get(i));
			}
		}

		// if enough time passed from the last shot and enemy is alive
		if (canShoot() && enemies.get(shortestIndex).isAlive)
		{
			// sets target to the closest enemy
			setTarget(enemies.get(shortestIndex));
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
