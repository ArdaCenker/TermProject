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

		for(int i = 0; i < enemies.size(); i+=3) {//zaten 3 tane düşmanı yok edeceğimiz için 4.'den devam edecek o yüzden 3 artırdım.
			
			Enemy[] enemyTargets = new Enemy[3];
			
			//recognizing targets
			for(int j = 0; j < 3; j++) {
				target(enemies.get(i + j));
				enemyTargets[j] = getTarget();
			}

			
			//if canShoot is true and target's health isn't 0, we reduce the health until it becomes 0
			while(getTarget().getHealth() != 0 && canShoot()) {
				
				for(int j = 0; j < enemyTargets.length; j++) {
					enemyTargets[j].setHealth(enemyTargets[j].getHealth() - getBulletDamage()); 
				}
				
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
