package com.github.tedder130.undertail.wavehandler.Pattern;

import com.github.tedder130.undertail.scenes.GameLevel;

public class Cross extends Pattern {

    int axis = 0;

    public Cross(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {
        int[] laserData = new int[4];

        laserData[3] = 20;

        //x, y, boolean, width

        if (axis == 0) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2;
            laserData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3] / 2 - 10;
            laserData[2] = 1;
        } else if (axis == 1) {
            laserData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2] / 2 - 10;
            laserData[1] = playArea[1] - sizePlayer[1] / 2;
            laserData[2] = 0;
        }

        gameLevel.spawnLaser(laserData);

        if(axis >= 1) {
            remove();
        } else {
            axis++;
        }
    }
}
