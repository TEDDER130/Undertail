package com.github.tedder130.undertail.entities.aanval;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SmallBullet extends DynamicSpriteEntity implements Collider {

    private int damage = 10;
    private boolean isHit = false;

    public SmallBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation, new Size(15,30));
        setMotion(5, direction);
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