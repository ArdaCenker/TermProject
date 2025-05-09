package tower;

import enemy.Enemy;
import java.util.ArrayList;
import javafx.geometry.Point2D;

public class Projectile {
    private int damage;
    private Tower sourceTower;
    private double hitRadius;
    private Point2D position;
    private Point2D targetPosition;
    private double speed;

    public Projectile(int damage, double hitRadius, int speed, Tower sourceTower) {
        this.damage = damage;
        this.sourceTower = sourceTower;
        this.hitRadius = hitRadius;
        this.position = sourceTower.getPosition();
        this.targetPosition = sourceTower.getTarget().getPosition();
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
        double distance = this.position.distance(targetPosition);

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
        // Direction vector from current position to target
        Point2D direction = targetPosition.subtract(position);

        if (direction.magnitude() == 0) return;

        // Normalize direction and scale by speed
        Point2D velocity = direction.normalize().multiply(this.speed);

        // Update position
        this.position = this.position.add(velocity);
    }

}