package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import static javafx.util.Duration.millis;

public class Laser extends DynamicSpriteEntity implements Collider {

    private int damage = 5;
    private long lastHit = 0;

    public Laser(Coordinate2D initialLocation, int width, int angle) {
        super("sprites/Bullet.png", initialLocation, new Size(width, 50));
    }

    public int getDamage() {
        return damage;
    }

    public boolean canHit() {
        if (System.currentTimeMillis() - this.lastHit >= 500) {
            setLastHit();
            return true;
        }
        return false;
    }

    public void setLastHit() {
        this.lastHit = System.currentTimeMillis();
    }
}
