package enemy;

import java.util.ArrayList;
import tower.Projectile;

public class Enemy {
	
	private int health;
	// findPath will calculate and return this object's intended speed_x and y
	private float speed_x;
	private float speed_y;
	// location info will probably come from javafx object of the enemy
	private float location_x;
	private float location_y;
	// r_1(x1,y1), r_2(x2,y2)... Rows for targeted_locations
	// locations will be provided by the LevelManager class
	ArrayList<float[][]> targeted_locations;
	// a boolean value to know whether the enemy is alive or not
	public boolean isAlive;

	// Constructor
	Enemy (float location_x, float location_y, int health,
		   ArrayList<float[][]> targeted_locations)
	{
		this.health = health;
		this.location_x = location_x;
		this.location_y = location_y;
		this.targeted_locations = targeted_locations;
		this.isAlive = true;
	}

	// returns health of the object
	public float getSpeed_x() {
		return speed_x;
	}

	public void setSpeed_x(float speed_x) {
		this.speed_x = speed_x;
	}

	public float getSpeed_y() {
		return speed_y;
	}

	public void setSpeed_y(float speed_y) {
		this.speed_y = speed_y;
	}

	public float getLocation_x() {
		return location_x;
	}

	public void setLocation_x(float location_x) {
		this.location_x = location_x;
	}

	public float getLocation_y() {
		return location_y;
	}

	public void setLocation_y(float location_y) {
		this.location_y = location_y;
	}

	public int getHealth() {
		return health;
	}
	// sets health of the object
	public void setHealth(int health) {
		this.health = health;
	}

	public void setAliveFalse () {this.isAlive = false;}

	// TODO: BU METHOD VELOCITY DEĞERLERİNİ Mİ VERMELİ, YOKSA VOİD RETURNLEYIP KONUMUMU DEĞİŞTİRMELİ??
	// returns normalized vector, this method should be called in every frame
	public float[] findDirection(float locationX, float locationY,
								 ArrayList<float[][]> targetedLocations) {
		// Check if there are no targets left
		if (targetedLocations.isEmpty()) {
			return new float[] {0, 0};  // no direction
		}

		// Get current target location
		float targetX = targetedLocations.getFirst()[0][0];
		float targetY = targetedLocations.getFirst()[1][0];

		// Check if we've arrived at the target (with float epsilon check)
		if (Math.abs(targetX - locationX) < 0.01f && Math.abs(targetY - locationY) < 0.01f) {
			// then removes the first element from the list, we have arrived and need to change our target
			targetedLocations.removeFirst();

			// If no more targets, return zero vector
			if (targetedLocations.isEmpty()) {
				return new float[] {0, 0};
			}
			// renews target_loc_x and y with the new first element
			targetX = targetedLocations.getFirst()[0][0];
			targetY = targetedLocations.getFirst()[1][0];
		}

		// Calculate normalized direction vector, dx and dy for distances in x and y axes
		float dx = targetX - locationX;
		float dy = targetY - locationY;
		float magnitude = (float)Math.sqrt(dx * dx + dy * dy);

		if (magnitude == 0) return new float[] {0, 0};  // already at target

		float dirX = dx / magnitude;
		float dirY = dy / magnitude;

		return new float[] {dirX, dirY};
	}
	// handles collision with projectile, reduces health of the enemy
	public void handleCollision(Projectile projectile) {
		int damage = projectile.getDamage();
		this.setHealth(this.getHealth() - damage);
		if (this.getHealth() <= 0) {
			this.isAlive = false;
		}
	}
}
