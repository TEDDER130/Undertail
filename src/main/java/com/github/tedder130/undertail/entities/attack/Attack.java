package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Attack extends DynamicSpriteEntity implements Collider {

    protected int damage;

    protected Attack(Coordinate2D initialLocation) {
        super("sprites/Bullet.png", initialLocation);
    }

    public int getDamage() {
        return damage;
    }
}
