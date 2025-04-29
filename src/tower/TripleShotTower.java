package tower;

import java.util.ArrayList;

import enemy.Enemy;

public class TripleShotTower extends Tower {

	public TripleShotTower(double positionX, double positionY) {
		super(positionX, positionY);
		this.setPrice(150);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	@Override
	public void shoot(ArrayList<Enemy> enemies) {

		for(int i = 0; i < enemies.size(); i++) {
			
			Enemy[] enemyTargets = new Enemy[3];
			
			for(int j = 0; j < 3; j++) {
				enemyTargets[j] = target(enemies.get(j));
			}
			
			
			//AYNI ANDA 3 DÜŞMANIN CANI AZALTILMALI
			
			//if canShoot is true and target's health isn't 0, we reduce the health until it becomes 0
			while(getTarget().getHealth() != 0 && canShoot()) {
				getTarget().setHealth(getTarget().getHealth() - getBulletDamage());
			}
		}
			
	}


	@Override
	public Enemy target(Enemy enemy) {
		//if enemy is in range, it becomes target
		if(calculateDistance(enemy) <= getRange()) {
			setTarget(enemy);
			return getTarget();
		}
		return null;
	}

}
