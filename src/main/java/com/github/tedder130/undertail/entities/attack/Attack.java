package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.tedder130.undertail.entities.Player;

public abstract class Attack extends DynamicRectangleEntity implements Collider, TimerContainer {

    protected int damage;
    protected int indication = 0;
    protected int delay = 500;

    public abstract void indication();

    public abstract boolean canHit();

    public Attack(Coordinate2D initialLocation, Player player, int delay) {
        super(initialLocation);
        this.delay = delay;
    }

    public Attack(Coordinate2D initialLocation, Size size, Player player, int delay) {
        super(initialLocation, size);
        this.delay = delay;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void setupTimers() {
        addTimer(new IndicationTimer(this));
    }

    protected static class IndicationTimer extends Timer {

        private Attack attack;

        protected IndicationTimer(final Attack attack) {
            super(attack.delay);
            this.attack = attack;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            attack.indication();
        }
    }
}