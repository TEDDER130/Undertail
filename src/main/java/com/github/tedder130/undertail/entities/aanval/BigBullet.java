package com.github.tedder130.undertail.entities.aanval;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BigBullet extends DynamicSpriteEntity implements Collider {

    private int damage = 25;
    private boolean isHit = false;

    public BigBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation, new Size(30,60));
        setMotion(3, direction);
        setRotate(direction + 90);
    }

    public int getDamage() {
        return damage;
    }

    public boolean getHit() {
        return isHit;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }
}