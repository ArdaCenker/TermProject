package enemy;

import java.util.ArrayList;

import tower.Projectile;
import javafx.geometry.Point2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;

public class Enemy {
	
	private int health;
	// findPath will calculate and return this object's intended speed_x and y
	private double speed;
	// location info will probably come from javafx object of the enemy
	private Point2D position;
	// r_1(x1,y1), r_2(x2,y2)... Rows for targeted_locations
	// locations will be provided by the LevelManager class
	private ArrayList<Point2D> targetedGrids;
	// a boolean value to know whether the enemy is alive or not
	public boolean isAlive;
	private ArrayList<Point2D> targetedCoordinates;
	private int gridSize;

	// Constructor
	public Enemy (Point2D position, int health, double speed, int gridSize,
		   ArrayList<Point2D> targetedGrids)
	{
		this.health = health;
		this.position = position;
		this.targetedGrids = targetedGrids;
		this.isAlive = true;
		this.speed = speed;
		this.gridSize = gridSize;
		this.targetedCoordinates = gridToCoordinates(new ArrayList<>(targetedGrids));
	}

	public Enemy() {

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
	public void moveEnemy (double dt)
	{
		Point2D directionVector = findDirection(this.position, this.targetedCoordinates);

		this.position = this.position.add(directionVector.multiply(speed * dt));
	}

	// TODO: En son grid e geldiği zaman patlıyor
	// returns normalized vector, this method should be called in every frame
	public Point2D findDirection(Point2D currentPosition, ArrayList<Point2D> targetedCoordinates) {
		// No more waypoints? Return zero direction
		if (targetedCoordinates.isEmpty()) {
			return new Point2D(0, 0);
		}

		// sets first element of targetedLocations as destination
		Point2D destination = targetedCoordinates.getFirst();

		// If we've reached the target, move to next
		if (currentPosition.distance(destination) < 0.01) {
			// removes the first location to change the first location in the list
			targetedCoordinates.removeFirst();

			// TODO: if no element left in the list, sets direction as this new Point2D, but this is where it patlıyor
			if (targetedCoordinates.isEmpty()) {
				return new Point2D(0, 0);
			}
			// so now, destination is the next grid
			destination = targetedCoordinates.getFirst();
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

	public Pane drawEnemy(Point2D position) {
		Pane enemy = new Pane();

        // Üçgen oluştur
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                100.0, 50.0,
                80.0, 150.0,
                130.0, 150.0
        );
        triangle.setFill(Color.RED);
        triangle.setStroke(Color.BLACK);

        // Yuvarlak oluştur
        Circle circle = new Circle(102, 70, 20);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);

        // Progress Bar oluştur
        ProgressBar progressBar = new ProgressBar(1);
        progressBar.setLayoutX(50); // X konumunu ayarla
        progressBar.setLayoutY(27); // Y konumunu ayarla
        progressBar.setPrefWidth(100); // Genişliği ayarla
        progressBar.setStyle("-fx-accent: red;-fx-box-border: transparent; -fx-background: black");

        enemy.setScaleX(0.35);
        enemy.setScaleY(0.35);

        enemy.setLayoutX(position.getX());
        enemy.setLayoutY(position.getY());

        // Tasarlanan cisimleri grupla
        enemy.getChildren().addAll(triangle, circle, progressBar);

        return enemy;
	}


	// This method finds grids' centers' coordinates according to their grid indices
	private ArrayList<Point2D> gridToCoordinates(ArrayList<Point2D> gridList)
	{
		// for each grid's center's x and y element, calculated via formula (2 * gridSize * index) + (gridSize/2)
		for (int i = 0; i < gridList.size(); i++) {
			double xCoordinate = gridList.get(i).getX() * gridSize + (double)gridSize/2;
			double yCoordinate = gridList.get(i).getY() * gridSize + (double)gridSize/2;

			gridList.set(i, new Point2D(xCoordinate, yCoordinate));
		}
		return gridList;
	}
}
