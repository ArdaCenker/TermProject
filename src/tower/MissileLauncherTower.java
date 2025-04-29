package tower;

import java.util.ArrayList;

import enemy.Enemy;

public class MissileLauncherTower extends Tower {
	
	private double effectRange;
	
	
	public MissileLauncherTower(double positionX, double positionY) {
		super(positionX, positionY);
		this.setPrice(200);
		this.setRange(1.0);
		this.setFireRate(1.5);
		this.setEffectRange(1.0);
	}

	public double getEffectRange() {
		return effectRange;
	}

	public void setEffectRange(double effectRange) {
		this.effectRange = effectRange;
	}

	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enemy target(Enemy enemy) {
		return null;
		
	}

}
