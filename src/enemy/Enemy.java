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
	ArrayList<float[][]> targeted_locations;
	
	public Enemy(int health) {
		this.health = health;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	// returns a vector for direction, this method should be called in every frame
	public float[] findPath(float location_x, float location_y,
							ArrayList<float[][]> targeted_locations)
	{
		// Assigns first target loc's x and y values to new variables
		float target_loc_x = targeted_locations.getFirst()[0][0];
		float target_loc_y = targeted_locations.getFirst()[1][0];

		// Checks whether the object arrived to first target destination
		if (target_loc_x == location_x && target_loc_y == location_y)
		{
			// if yes, then removes the first element from the list
			targeted_locations.removeFirst();
			// renews target_loc_x and y with the new first element
			target_loc_x = targeted_locations.getFirst()[0][0];
			target_loc_y = targeted_locations.getFirst()[1][0];
		}

		// set path as hypotenuse of two locations, and assign tangent to tangent
		float tangent = (target_loc_y - location_y) / (target_loc_x - location_x);

		// direction will hold the ratio, it's like a vector for speed
		float[] direction = new float[2];
		direction[0] = 1;
		direction[1] = tangent;

		// return direction
		return direction;
	}
}
