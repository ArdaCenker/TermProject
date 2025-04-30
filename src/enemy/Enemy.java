package enemy;

import java.util.ArrayList;

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

	// returns a vector for direction, this method should be called in every frame
	public float[] findDirection(float location_x, float location_y,
							ArrayList<float[][]> targeted_locations)
	{
		// Assigns first target loc's x and y values to new variables
		float target_loc_x = targeted_locations.getFirst()[0][0];
		float target_loc_y = targeted_locations.getFirst()[1][0];
		// Creates an array for storing direction
		float[] direction = new float[2];

		// Checks whether the object arrived to first target destination
		if (target_loc_x == location_x && target_loc_y == location_y)
		{
			// if yes, then removes the first element from the list
			targeted_locations.removeFirst();
			// renews target_loc_x and y with the new first element
			target_loc_x = targeted_locations.getFirst()[0][0];
			target_loc_y = targeted_locations.getFirst()[1][0];
		}

		// Sets direction of enemy according to enemy's and target's location
		if ((target_loc_x - location_x) != 0){
			// set path as hypotenuse of two locations, and assign tangent to tangent
			float tangent = (target_loc_y - location_y) / (target_loc_x - location_x);
			direction[0] = 1;
			direction[1] = tangent;
		}
		// if divisor value of tangent becomes equivalent to 0
		else if ((target_loc_x - location_x) == 0) {
			direction[0] = 0;
			direction[1] = ((target_loc_y - location_y) > 0) ? 1 : -1;
		}

		// return direction
		return direction;
	}
}
