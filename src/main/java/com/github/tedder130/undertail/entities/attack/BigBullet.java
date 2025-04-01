package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;

public class BigBullet extends Bullet {
    public BigBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation, direction, 25);
    }
}