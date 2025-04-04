package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.tedder130.undertail.scenes.GameLevel;

public class Quadcircle extends Patroon {

    int randomCorner;
    int angle = 0;
    int startAngle = 0;

    public Quadcircle(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
        randomCorner = (int) (Math.random() * 4);
        angle = randomCorner * 90;
        startAngle = angle;
    }

    @Override
    public void generateEntities() {

        int[] smallBulletData = new int[3];

        if (randomCorner == 0) {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2;
        } else if (randomCorner == 1) {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
        } else if (randomCorner == 2) {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
        } else if (randomCorner == 3) {
            smallBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            smallBulletData[1] = playArea[1] - sizePlayer[1] / 2;
        }

        smallBulletData[2] = angle;

        gameLevel.spawnSmallBullet(smallBulletData);

        if (angle >= startAngle + 90) {
            remove();
        } else {
            angle+=15;
        }
    }
}