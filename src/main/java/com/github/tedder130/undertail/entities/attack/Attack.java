package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Attack extends DynamicSpriteEntity implements Collider, TimerContainer {


    protected int damage;
    protected int[] playArea = new int[4];

    public Attack(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }

    public int getDamage() {
        return damage;
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
