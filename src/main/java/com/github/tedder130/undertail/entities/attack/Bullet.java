package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Bullet extends DynamicSpriteEntity implements Collider {

    private int damage;
    private boolean isHit = false;

    public Bullet(String resource, Coordinate2D initialLocation, int direction, int damage, Size size) {
        super(resource, initialLocation, size);
        this.damage = damage;
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