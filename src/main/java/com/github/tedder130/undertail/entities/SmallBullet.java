package com.github.tedder130.undertail.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SmallBullet extends DynamicSpriteEntity {
    protected SmallBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation);
        setMotion(10, direction);
        setRotate(direction);
    }
}
