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
		for(int i = 0; i < enemies.size(); i++) {
			
			//recognizing target
			target(enemies.get(i));
		
			//if canShoot is true and target's health isn't 0, we reduce the health until it becomes 0
			while(getTarget().getHealth() != 0 && canShoot()) {
				getTarget().setHealth(getTarget().getHealth() - getBulletDamage());
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
