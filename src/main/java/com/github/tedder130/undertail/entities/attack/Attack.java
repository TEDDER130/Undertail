package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Attack extends DynamicRectangleEntity implements Collider {

    protected int damage;
    protected int[] playArea = new int[4];

    public Attack(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }

    public int getDamage() {
        return damage;
    }
}
