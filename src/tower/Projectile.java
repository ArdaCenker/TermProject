package tower;

import enemy.Enemy;

public class Projectile {
    private int damage;
    private Tower sourceTower;

    public Projectile(int damage, Tower sourceTower) {
        this.damage = damage;
        this.sourceTower = sourceTower;
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

}