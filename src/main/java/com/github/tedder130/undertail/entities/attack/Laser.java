package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.entities.Player;

import static javafx.scene.paint.Color.rgb;

public class Laser extends Attack {

    private int damage = 2;
    private long lastHit = 0;

    public Laser(Coordinate2D initialLocation, int width, boolean horizontal, Player player, int delay) {
        super(initialLocation, player, delay);
        setFill(rgb(255,255,255, 0.2));
        if (!horizontal) {
            setWidth(width);
            setHeight(300 + 20);
        } else {
            setWidth(600 + 13);
            setHeight(width);
        }
        player.increaseScore(3);
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void indication() {
        if (indication >= 3) {
            setFill(rgb(255,255,255,0.75));
            if (indication >= 5) {
                remove();
            }
        } else if (indication % 2 == 0) {
            setFill(rgb(255,255,255, 0.1));
        } else {
            setFill(rgb(255,255,255, 0.15));
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
