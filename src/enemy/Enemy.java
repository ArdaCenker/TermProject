package enemy;

import java.util.ArrayList;
import tower.Projectile;
import javafx.geometry.Point2D;

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
	private ArrayList<Point2D> targetedLocations;
	// a boolean value to know whether the enemy is alive or not
	public boolean isAlive;

	// Constructor
	Enemy (float location_x, float location_y, int health,
		   ArrayList<Point2D> targetedLocations)
	{
		this.health = health;
		this.location_x = location_x;
		this.location_y = location_y;
		this.targetedLocations = targetedLocations;
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

	// TODO: En son grid e geldiği zaman patlıyor
	// returns normalized vector, this method should be called in every frame
	public Point2D findDirection(Point2D currentPosition, ArrayList<Point2D> targetedLocations) {
		// No more waypoints? Return zero direction
		if (targetedLocations.isEmpty()) {
			return new Point2D(0, 0);
		}

		// sets first element of targetedLocations as destination
		Point2D destination = targetedLocations.getFirst();

		// If we've reached the target, move to next
		if (currentPosition.distance(destination) < 0.01) {
			// removes the first location to change the first location in the list
			targetedLocations.removeFirst();

			// TODO: if no element left in the list, sets direction as this new Point2D, but this is where it patlıyor
			if (targetedLocations.isEmpty()) {
				return new Point2D(0, 0);
			}
			// so now, destination is the next grid
			destination = targetedLocations.getFirst();
		}

		// direction = target - current, normalized
		return destination.subtract(currentPosition).normalize();
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
