package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Attack extends DynamicSpriteEntity implements Collider {

    protected int damage;
    protected int[] playArea = new int[4];

    public Attack(String resource, Coordinate2D initialLocation, Size size) {
        super(resource, initialLocation, size);
    }

    int getDamage() {
        return damage;
    }
}
