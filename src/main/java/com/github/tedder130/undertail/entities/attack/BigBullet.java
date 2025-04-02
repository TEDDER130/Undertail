package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BigBullet extends Bullet {
    public BigBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation, direction, 25, new Size(30, 60));
    }
}