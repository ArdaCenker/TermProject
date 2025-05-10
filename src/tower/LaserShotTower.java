package tower;

import java.util.ArrayList;

import enemy.Enemy;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class LaserShotTower extends Tower {

	public LaserShotTower(Point2D position) {
		super(position);
		this.setPrice(120);
		this.setRange(1.0);
		this.setFireRate(1.5);
	}
	
	
	
	//HER FRAMEDE BELİRLİ BİR MİKTAR CAN AZALTMALI MERMİ GİBİ DEĞİL
	@Override
	public void shoot(ArrayList<Enemy> enemies) {

		for(int i = 0; i < enemies.size(); i++) {

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
		if(calculateDistance(enemy.getPosition()) <= getRange()) {
			setTarget(enemy);
		}
	}



	@Override
	public Pane drawTower() {
		Pane castleGroup = new Pane();

        //Tower body
        Rectangle secBody = new Rectangle(670, 230, 170, 170);
        secBody.setFill(Color.GRAY);
        secBody.setStroke(Color.BLACK);

        // Kale üst kısmı
        Rectangle secUp1 = new Rectangle(670, 200, 30, 30);
        secUp1.setFill(Color.GRAY);
        secUp1.setStroke(Color.BLACK);
        Rectangle secUp2 = new Rectangle(735, 200, 30, 30);
        secUp2.setFill(Color.GRAY);
        secUp2.setStroke(Color.BLACK);
        Rectangle secUp3 = new Rectangle(800, 200, 30, 30);
        secUp3.setFill(Color.GRAY);
        secUp3.setStroke(Color.BLACK);
        Rectangle secUp4 = new Rectangle(850, 200, 30, 30);
        secUp4.setFill(Color.GRAY);
        secUp4.setStroke(Color.BLACK);

        // Gölge kısımları
        Rectangle secShadow1 = new Rectangle(700, 200, 15, 30);
        secShadow1.setFill(Color.BLACK);
        Rectangle secShadow2 = new Rectangle(765, 200, 15, 30);
        secShadow2.setFill(Color.BLACK);
        Rectangle secShadow3 = new Rectangle(830, 200, 15, 30);
        secShadow3.setFill(Color.BLACK);
        Rectangle secShadow4 = new Rectangle(880, 200, 15, 30);
        secShadow4.setFill(Color.BLACK);

        Rectangle secShadow = new Rectangle(830, 230, 65, 170);
        secShadow.setFill(Color.BLACK);

        // Ana gövde
        Rectangle body = new Rectangle(650, 400, 200, 200);
        body.setFill(Color.GRAY);
        body.setStroke(Color.BLACK);
        Rectangle shadow = new Rectangle(850, 400, 100, 200);
        shadow.setFill(Color.BLACK);

        // Kale üst kısmı
        Rectangle up1 = new Rectangle(650, 360, 40, 40);
        up1.setFill(Color.GRAY);
        up1.setStroke(Color.BLACK);
        Rectangle up2 = new Rectangle(730, 360, 40, 40);
        up2.setFill(Color.GRAY);
        up2.setStroke(Color.BLACK);
        Rectangle up3 = new Rectangle(810, 360, 40, 40);
        up3.setFill(Color.GRAY);
        up3.setStroke(Color.BLACK);
        Rectangle up4 = new Rectangle(890, 360, 40, 40);
        up4.setFill(Color.GRAY);
        up4.setStroke(Color.BLACK);

        // Gölge kısımları
        Rectangle shadow1 = new Rectangle(690, 360, 20, 40);
        shadow1.setFill(Color.BLACK);
        Rectangle shadow2 = new Rectangle(770, 360, 20, 40);
        shadow2.setFill(Color.BLACK);
        Rectangle shadow3 = new Rectangle(850, 360, 20, 40);
        shadow3.setFill(Color.BLACK);
        Rectangle shadow4 = new Rectangle(930, 360, 20, 40);
        shadow4.setFill(Color.BLACK);

        // Kale kapısı
        Rectangle door = new Rectangle(715, 500, 70, 100);
        door.setFill(Color.BLACK);

        //Add all parts to the group
        castleGroup.getChildren().addAll(
            secBody, secUp1, secUp2, secUp3, secUp4,
            secShadow1, secShadow2, secShadow3, secShadow4, secShadow,
            body, up1, up2, up3, up4, shadow, shadow1, shadow2, shadow3, shadow4, door
        );
        
        castleGroup.setScaleX(0.1);
        castleGroup.setScaleY(0.1);

        return castleGroup;
    }

}
