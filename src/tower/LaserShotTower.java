package tower;

import java.util.ArrayList;

import enemy.Enemy;

public class LaserShotTower extends Tower {

	public LaserShotTower(double positionX, double positionY) {
		super(positionX, positionY);
		this.setPrice(120);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		
	}

}
