package tower;

import enemy.Enemy;
import java.util.ArrayList;

public class Projectile {
    private int damage;
    private Tower sourceTower;
    private double hitRadius;
    private double locationX;
    private double locationY;
    private double targetLocationX;
    private double targetLocationY;
    private double speed;

    public Projectile(int damage, double hitRadius, int speed, Tower sourceTower) {
        this.damage = damage;
        this.sourceTower = sourceTower;
        this.hitRadius = hitRadius;
        this.locationX = sourceTower.getPositionX();
        this.locationY = sourceTower.getPositionY();
        this.targetLocationX = sourceTower.getTarget().getLocation_x();
        this.targetLocationY = sourceTower.getTarget().getLocation_y();
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public Tower getSourceTower() {
        return sourceTower;
    }

    // calls passed enemy object's handleCollision method
    public void hit(Enemy target) {
        target.handleCollision(this);
    }

    public boolean collidesWith(Enemy e) {
        double dx = this.locationX - e.getLocation_x();
        double dy = this.locationY - e.getLocation_y();
        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance <= this.hitRadius;  // e.g., 10 pixels
    }

    // will be called in every frame
    public boolean updateAndCheckCollision(ArrayList<Enemy> enemies) {
        moveTowardDirection();

        // for each enemy who is alive, if projectile collides with the enemy, hit method is called for that method
        for (Enemy e : enemies) {
            if (!e.isAlive) continue;

            // Only if projectile collides with enemy, hit method is called and enemy health is reduced
            if (collidesWith(e)) {
                hit(e);         // if it collides with any enemy, don't care whether it is initial target or not
                return true;    // signal removal from projectile list
            }
        }
        return false;
    }

    // TODO: This method will calculate its direction to the enemy and will move the enemy as the this.speed
    public void moveTowardDirection() {
        // distances in x and y axes
        double dx = targetLocationX - this.locationX;
        double dy = targetLocationY - this.locationY;

        double distance = Math.sqrt(dx * dx + dy * dy);

        // Avoid division by 0 (when projectile is already at the target)
        if (distance == 0) return;

        // trigonometric stuff, dirx^2 + diry^2 will be equal to 1
        double dirX = dx / distance;
        double dirY = dy / distance;

        // Scale by speed
        double velocityX = dirX * this.speed;
        double velocityY = dirY * this.speed;

        // Move the projectile
        this.locationX += velocityX;
        this.locationY += velocityY;
    }

}