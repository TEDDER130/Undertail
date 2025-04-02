package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import static javafx.scene.paint.Color.rgb;

public abstract class Attack extends DynamicRectangleEntity implements Collider, TimerContainer {


    protected int damage;
    protected int[] playArea = new int[4];
    protected int indication = 0;

    public Attack(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    public Attack(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size);
    }

    public int getDamage() {
        return damage;
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

    @Override
    public void setupTimers() {
        addTimer(new IndicationTimer(this));
    }

    private static class IndicationTimer extends Timer {

        private Attack attack;

        protected IndicationTimer(final Attack attack) {
            super(500);
            this.attack = attack;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            attack.indication();
        }
    }
}
