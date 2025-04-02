package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

import static javafx.scene.paint.Color.rgb;

public class Bullet extends Attack {
    
    private boolean isHit = false;

    public Bullet(Coordinate2D initialLocation, int direction, int damage, Size size) {
        super(initialLocation, size);
        this.damage = damage;
        setFill(rgb(255,255,255,1));
        setMotion(5, direction);
        setRotate(direction + 90);
    }

    public boolean getHit() {
        return isHit;
    }

    public void setHit(boolean isHit) {
        this.isHit = isHit;
    }
}