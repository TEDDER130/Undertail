package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.tedder130.undertail.scenes.GameLevel;

public class BulletCross extends Patroon {

    int y = 0;
    int x = 0;

    public BulletCross(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {

        int[] bigBulletData = new int[3];

        if (x == 0) {
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2;
            bigBulletData[2] = 70;
        } else if (x == 1) {
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2;
            bigBulletData[2] = 290;
        } else if (x == 2) {
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
            bigBulletData[2] = 110;
        } else if (x == 3) {
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
            bigBulletData[2] = 250;
        }

        gameLevel.spawnBigBullet(bigBulletData);

        if (x >= 3) {
            remove();
        } else {
            x++;
        }
    }
}
