package tower;

import java.util.ArrayList;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import enemy.Enemy;

public class SingleShotTower extends Tower {

	public SingleShotTower(Point2D position) {
		super(position);
		this.setPrice(50);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	// shoot method should be called in every frame
	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// to keep track of the shortest distance
		double shortestDistance = calculateDistance(enemies.getFirst().getPosition());
		// to keep track of the index of closest enemy
		int shortestIndex = 0;

		// for loop make sure we know the closest enemy to the tower
		for(int i = 1; i < enemies.size(); i++) {
			if (calculateDistance(enemies.get(i).getPosition()) <= shortestDistance)
			{
				shortestIndex = i;
				shortestDistance = calculateDistance(enemies.get(i).getPosition());
			}
		}

		// if enough time passed from the last shot and enemy's health > 0
		if (canShoot() && enemies.get(shortestIndex).getHealth() > 0)
		{
			// sets target to the closest enemy, if it is in the range
			if (calculateDistance(enemies.get(shortestIndex).getPosition()) <= this.getRange())
			{
				// Create a projectile
				Projectile projectile = new Projectile(10, 10,2,this);
				setTarget(enemies.get(shortestIndex));

				// projectile object calls hit method to hit closest enemy
				projectile.hit(enemies.get(shortestIndex));
			}

		}
		 // If enemy's health is 0 (or lower somehow), set's enemy's isAlive to false
		if (enemies.get(shortestIndex).getHealth() <= 0)
		{
			enemies.get(shortestIndex).setAliveFalse();
		}
	}

	@Override
	public void target(Enemy enemy) {
		//if enemy is in range, it becomes target
		if(calculateDistance(enemy.getPosition()) <= getRange()) {
			setTarget(enemy);
		}
	}

	@Override
	public Pane drawTower() {
		Pane castleGroup = new Pane();

        // Kale gövdesi
        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);

        // Kale üst kısmı
        Rectangle up1 = new Rectangle(650, 360, 40, 40);
        up1.setFill(Color.GRAY);
        Rectangle up2 = new Rectangle(730, 360, 40, 40);
        up2.setFill(Color.GRAY);
        Rectangle up3 = new Rectangle(810, 360, 40, 40);
        up3.setFill(Color.GRAY);
        Rectangle up4 = new Rectangle(890, 360, 40, 40);
        up4.setFill(Color.GRAY);

        // Gölge kısımları
        Rectangle shadow1 = new Rectangle(690, 360, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 360, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 360, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 360, 20, 40);
        shadow4.setFill(Color.BLACK);

        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);

        // Kale kapısı
        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);

        // Kale parçalarını bir gruba ekle
        castleGroup.getChildren().addAll(body, up1, up2, up3, up4, shadow, shadow1, shadow2, shadow3, shadow4, door);

        castleGroup.setScaleX(0.1);
        castleGroup.setScaleY(0.1);
        
        return castleGroup;
    }
}
