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

	@Override
	public void shoot(ArrayList<Enemy> enemies) {

		for(int i = 0; i < enemies.size(); i++) {

			//finding distance between enemy and tower
			double distance = Math.sqrt(
					Math.pow(enemies.get(i).getLocation_x() - getPositionX(),2) + 
					Math.pow(enemies.get(i).getLocation_y() - getPositionY(),2));
		
			if(distance <= getRange()) {
				//if enemy is in range we reduce the health until it becomes 0
				while(enemies.get(i).getHealth() != 0 && canShoot()) {
				enemies.get(i).setHealth(enemies.get(i).getHealth() - getBulletDamage());
			
		
				}
			}
		
		}
	}
}
