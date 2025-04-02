package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import static javafx.util.Duration.millis;

public class Laser extends DynamicSpriteEntity implements Collider {

    private int damage = 1;
    private long lastHit = 0;

    public Laser(Coordinate2D initialLocation, int width, boolean horizontal) {
        super("sprites/Laser.png", initialLocation);

        if (horizontal) {
            new Size(width, 1000);
        } else {
            new Size(1000, width);
        }
    }

    public int getDamage() {
        return damage;
    }

    public boolean canHit() {
        if (System.currentTimeMillis() - this.lastHit >= 100) {
            setLastHit();
            return true;
        }
        return false;
    }

    public void setLastHit() {
        this.lastHit = System.currentTimeMillis();
    }
}
