package tower;

import java.util.ArrayList;

import enemy.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//150123012 Arda Cenker Karagöz - 150124005 Talha Zencirkıran - 150123002 Ali Faik Aksoy
public class TripleShotTower extends Tower {

	public TripleShotTower(Point2D position) {
		super(position);
		this.setPrice(150);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}

	// This method should be called in every frame
	@Override
	public void shoot(ArrayList<Enemy> enemies) {
		// TODO: Will pick the closest 3 enemy objects
		// stores indices of original enemies ArrayList for later usage
		int[] sortedEnemyIndices = closestEnemiesIndices(enemies).clone();

		Enemy[] enemyTargets = new Enemy[3];

		for(int i = 0; i < enemies.size(); i++) {//zaten 3 tane düşmanı yok edeceğimiz için 4.'den devam edecek o yüzden 3 artırdım.

			// TODO: THERE WILL BE OUT OF BOUNDS INDEX ERROR IN THIS FOR LOOP!!!
			//recognizing targets
			for(int j = 0; j < 3; j++) {
				target(enemies.get(sortedEnemyIndices[i + j]));
				enemyTargets[j] = getTarget();
			}



		}
			
	}

	//this method recognizes the enemy as a target.
	@Override
	public void target(Enemy enemy) {
		//if enemy is in range, it becomes target
		if(calculateDistance(enemy.getPosition()) <= getRange()) {
			setTarget(enemy);
		}
	}

	//this method draws triple shot tower
	@Override
	public Pane drawTower() {
		Pane castleGroup = new Pane();

        //Tower body
        Rectangle secBody = new Rectangle(650, 230, 200, 200);
        secBody.setFill(Color.GRAY);

        Rectangle secShadow = new Rectangle(850, 230, 100, 200);
        secShadow.setFill(Color.BLACK);

        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);

        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);


        //Upper tower
        Rectangle up1 = new Rectangle(650, 190, 40, 40);
        up1.setFill(Color.GRAY);
        Rectangle up2 = new Rectangle(730, 190, 40, 40);
        up2.setFill(Color.GRAY);
        Rectangle up3 = new Rectangle(810, 190, 40, 40);
        up3.setFill(Color.GRAY);
        Rectangle up4 = new Rectangle(890, 190, 40, 40);
        up4.setFill(Color.GRAY);

        //Shadows

        Rectangle shadow1 = new Rectangle(690, 190, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 190, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 190, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 190, 20, 40);
        shadow4.setFill(Color.BLACK);

        //Doors

        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);
        Rectangle secDoor = new Rectangle(715, 300, 70, 100);
        secDoor.setFill(Color.BLACK);

        //Add all parts to the group

        castleGroup.getChildren().addAll(
            secBody, secShadow, body, up1, up2, up3, up4,
            shadow, shadow1, shadow2, shadow3, shadow4, door, secDoor
        );
        
        castleGroup.setScaleX(0.1);
        castleGroup.setScaleY(0.1);


        return castleGroup;
    }

}
