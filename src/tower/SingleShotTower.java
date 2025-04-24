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
		// TODO Auto-generated method stub
		
	}

}
