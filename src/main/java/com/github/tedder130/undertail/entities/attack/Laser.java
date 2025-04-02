package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

import java.util.Random;

import static javafx.scene.paint.Color.rgb;
import static javafx.util.Duration.millis;

public class Laser extends DynamicRectangleEntity implements Collider, TimerContainer {

    private int damage = 1;
    private long lastHit = 0;
    private int indication = 0;

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

    public int getDamage() {
        return damage;
    }

    public boolean canHit() {
        if (System.currentTimeMillis() - this.lastHit >= 100 && indication >= 3) {
            setLastHit();
            return true;
        }
        return false;
    }

    public void setLastHit() {
        this.lastHit = System.currentTimeMillis();
    }


    @Override
    public void setupTimers() {
        addTimer(new LaserTimer(this));
    }

    private static class LaserTimer extends Timer {

        private Laser laser;

        protected LaserTimer(final Laser laser) {
            super(500);
            this.laser = laser;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            laser.indication();
        }
    }
}
