package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.tedder130.undertail.entities.PlayArea;

import java.io.Serializable;

import static javafx.scene.paint.Color.rgb;

public class Bullet extends Attack implements TimerContainer{

    protected int[] playArea;
    private boolean canHit = true;
    private int angle;
    private int speed;
    //private int indication = 0;

    public Bullet(Coordinate2D initialLocation, int angle, int damage, int speed, Size size, int[] playArea) {
        super(initialLocation, size);
        this.damage = damage;
        this.angle = angle;
        this.speed = speed;
        this.playArea = playArea;
        setFill(rgb(255,255,255,0.33));
        setMotion(0, angle);
        setRotate(angle + 90);
    }

    public boolean canHit() {
        if (canHit && indication >= 2) {
            return true;
        }
        return false;
    }

    public int getAngle() {
        return angle;
    }

    public int getMotion() {
        return speed;
    }

    public void setCanHit(boolean canHit) {
        this.canHit = canHit;
    }

    @Override
    public void indication() {
        if (indication >= 1) {
            setFill(rgb(255,255,255,0.75));
            setMotion(getMotion(), getAngle());
        } else if (indication % 2 == 0) {
            setFill(rgb(255,255,255, 0.1));
        } else {
            setFill(rgb(255,255,255, 0.33));
        }
        indication++;
    }

    void checkCollision() {
        double X = getAnchorLocation().getX();
        double Y = getAnchorLocation().getY();

        Size size = null;

        if (this instanceof BigBullet) {
            BigBullet bullet = (BigBullet) this;
            size = bullet.getSize();
        } else if (this instanceof SmallBullet) {
            SmallBullet bullet = (SmallBullet) this;
            size = bullet.getSize();
        }

        if(angle > 315 || angle < 45 || angle > 135 && angle < 225) {
            if (X < playArea[0] || Y < playArea[1]|| X > playArea[2] + playArea[0] || Y > playArea[3] + playArea[1] - size.height()) {
                remove();
            }
        } else {
            if (X < playArea[0] || Y < playArea[1] || X > playArea[2] + playArea[0] - size.width() || Y > playArea[3] + playArea[1]) {
                remove();
            }
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new CollisionTimer(this));
        addTimer(new IndicationTimer(this));
    }

    private static class CollisionTimer extends Timer {

        private Bullet bullet;

        protected CollisionTimer(final Bullet bullet) {
            super(10);
            this.bullet = bullet;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            bullet.checkCollision();
        }
    }
}