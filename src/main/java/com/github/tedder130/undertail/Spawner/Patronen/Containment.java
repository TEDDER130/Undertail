package com.github.tedder130.undertail.Spawner.Patronen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.entities.attack.Tile;
import com.github.tedder130.undertail.scenes.GameLevel;

import java.util.Arrays;

public class Containment extends Patroon {

    int axis = 0;

    public Containment(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {
        int[] laserData = new int[4];

        laserData[3] = 40;

        if (axis == 0) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2;
            laserData[1] = playArea[1] - sizePlayer[1] / 2 + 40;
            laserData[2] = 1;
        } else if (axis == 1) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2 + 80;
            laserData[1] = playArea[1] - sizePlayer[1] / 2;
            laserData[2] = 0;
        } else if (axis == 2) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2;
            laserData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3] + sizePlayer[1] / 2 - 80;
            laserData[2] = 1;
        } else if (axis == 3) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2] + sizePlayer[0] / 2 - 120;
            laserData[1] = playArea[1] - sizePlayer[1] / 2;
            laserData[2] = 0;
        }

        System.out.println("send: " + Arrays.toString(laserData));
        gameLevel.spawnLaser(laserData);

        if(axis > 2) {
            remove();
        } else {
            axis++;
        }
    }
}