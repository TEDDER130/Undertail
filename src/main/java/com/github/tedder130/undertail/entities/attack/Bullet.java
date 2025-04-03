package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

import static javafx.scene.paint.Color.rgb;

public class Bullet extends Attack {

    protected int[] playArea = new int[4];
    private boolean canHit = true;
    private int angle;
    private int speed;
    //private int indication = 0;

    public Bullet(Coordinate2D initialLocation, int angle, int damage, int speed, Size size) {
        super(initialLocation, size);
        this.damage = damage;
        this.angle = angle;
        this.speed = speed;
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

    public boolean isOffScreen() {
        return false;
    }
}