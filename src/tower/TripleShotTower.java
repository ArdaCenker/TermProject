package tower;

import java.util.ArrayList;
import java.util.Arrays;

import enemy.Enemy;

public class TripleShotTower extends Tower {

	public TripleShotTower(double positionX, double positionY) {
		super(positionX, positionY);
		this.setPrice(150);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	// This method should be called in every frame
	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// TODO: Will pick the closest 3 enemy objects
		// stores indices of original enemies ArrayList for later usage
		int[] sortedEnemyIndices = closestEnemiesIndices(enemies).clone();

		Enemy[] enemyTargets = new Enemy[3];

		for(int i = 0; i < enemies.size(); i++) {//zaten 3 tane düşmanı yok edeceğimiz için 4.'den devam edecek o yüzden 3 artırdım.

			// TODO: THERE WILL BE OUT OF BOUNDS INDEX ERROR IN THIS FOR LOOP!!!
			//recognizing targets
			for(int j = 0; j < 3; j++) {
				target(enemies.get(sortedEnemyIndices[i + j]));
				enemyTargets[j] = getTarget();
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
