package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class BigBullet extends Bullet {
    private Size size;

    public BigBullet(Coordinate2D initialLocation, int direction, int[] playArea) {
        super(initialLocation, direction, 25, 4, new Size(30, 15), playArea);
        size = new Size(30, 15);
    }

    public Size getSize() {
        return size;
    }
}