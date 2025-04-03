package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class SmallBullet extends Bullet {
    private Size size;

    public SmallBullet(Coordinate2D initialLocation, int direction, int[] playArea) {
        super(initialLocation, direction, 10, 8, new Size(10, 5), playArea);
        size = new Size(10, 5);
    }

    public Size getSize() {
        return size;
    }
}