package com.github.tedder130.undertail.entities.attack;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.tedder130.undertail.entities.Player;

import static javafx.scene.paint.Color.rgb;

public class Tile extends Attack {

    private int damage = 2;
    private long lastHit = 0;

    public Tile(Coordinate2D initialLocation, Player player, int delay) {
        super(initialLocation, new Size(102,107), player, delay);
        setFill(rgb(255,255,255, 0.2));
        player.increaseScore(1);
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