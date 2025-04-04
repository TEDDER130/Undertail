package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.tedder130.undertail.entities.Player;

public class BigBullet extends Bullet {
    private Size size;

    public BigBullet(Coordinate2D initialLocation, int direction, int[] playArea, Player player, int delay) {
        super(initialLocation, direction, 15, 4, new Size(30, 15), playArea, player, delay);
        size = new Size(30, 15);
    }

    public Size getSize() {
        return size;
    }
}