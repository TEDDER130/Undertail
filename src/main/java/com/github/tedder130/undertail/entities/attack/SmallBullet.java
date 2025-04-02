package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SmallBullet extends Bullet {
    public SmallBullet(Coordinate2D initialLocation, int direction) {
        super("sprites/Bullet.png", initialLocation, direction, 10, new Size(15, 30));
    }
}