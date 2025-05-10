package enemy;

import java.util.ArrayList;
import tower.Projectile;
import javafx.geometry.Point2D;

public class Enemy {
	
	private int health;
	// findPath will calculate and return this object's intended speed_x and y
	private double speed;
	// location info will probably come from javafx object of the enemy
	private Point2D position;
	// r_1(x1,y1), r_2(x2,y2)... Rows for targeted_locations
	// locations will be provided by the LevelManager class
	private ArrayList<Point2D> targetedLocations;
	// a boolean value to know whether the enemy is alive or not
	public boolean isAlive;

	// Constructor
	Enemy (Point2D position, int health, double speed,
		   ArrayList<Point2D> targetedLocations)
	{
		this.health = health;
		this.position = position;
		this.targetedLocations = targetedLocations;
		this.isAlive = true;
		this.speed = speed;
	}

	public Point2D getPosition() {return position;}

	// returns health of the object
	public double getSpeed_x() {
		return this.speed;
	}

	public int getHealth() {
		return health;
	}
	// sets health of the object
	public void setHealth(int health) {
		this.health = health;
	}

	public void setAliveFalse () {this.isAlive = false;}

	// should be called in every frame, moves enemy to its destination according to speed
	public void moveEnemy ()
	{
		Point2D directionVector = findDirection(this.position, this.targetedLocations);

		this.position.add(directionVector.multiply(speed));
	}

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
