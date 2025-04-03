package com.github.tedder130.undertail.Spawner.Patronen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.entities.attack.Tile;
import com.github.tedder130.undertail.scenes.GameLevel;

public class Crossfire extends Patroon {

    int y = 0;
    boolean left = true;

    public Crossfire(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {

        int[] smallBulletData = new int[3];

        if (left == true) {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2 + (this.y * 80) - this.y;
            smallBulletData[2] = 90;
        } else {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2 + (this.y * 80) + 40;
            smallBulletData[2] = 270;
        }

        gameLevel.spawnSmallBullet(smallBulletData);

        if (left == false && y >= 3 ) {
            remove();
        } else if (y >= 4) {
            left = false;
            y = 0;
        } else {
            y++;
        }
    }
}