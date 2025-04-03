package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;

import static javafx.scene.paint.Color.rgb;

public class Laser extends Attack {

    private int damage = 1;
    private long lastHit = 0;

    public Laser(Coordinate2D initialLocation, int width, boolean horizontal) {
        super(initialLocation);
        setFill(rgb(255,255,255, 0.33));
        if (!horizontal) {
            setWidth(width);
            setHeight(300 + 20);
        } else {
            setWidth(600 + 13);
            setHeight(width);
        }
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void indication() {
        if (indication >= 3) {
            setFill(rgb(255,255,255,0.75));
        } else if (indication % 2 == 0) {
            setFill(rgb(255,255,255, 0.1));
        } else {
            setFill(rgb(255,255,255, 0.33));
        }
        indication++;
    }

    public boolean canHit() {
        if (System.currentTimeMillis() - this.lastHit >= 100 && indication >= 4) {
            setLastHit();
            return true;
        }
        return false;
    }

    public void setLastHit() {
        this.lastHit = System.currentTimeMillis();
    }
}
