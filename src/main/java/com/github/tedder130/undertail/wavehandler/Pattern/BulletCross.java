package com.github.tedder130.undertail.wavehandler.Pattern;

import com.github.tedder130.undertail.scenes.GameLevel;

public class BulletCross extends Pattern {

    public BulletCross(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {
        int[] bigBulletData = new int[3];


            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2;
            bigBulletData[2] = 70;
        gameLevel.spawnBigBullet(bigBulletData);
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2;
            bigBulletData[2] = 290;
        gameLevel.spawnBigBullet(bigBulletData);
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2;
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
            bigBulletData[2] = 110;
        gameLevel.spawnBigBullet(bigBulletData);
            bigBulletData[0] = playArea[0] - sizePlayer[0] / 2 + playArea[2];
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2 + playArea[3];
            bigBulletData[2] = 250;
        gameLevel.spawnBigBullet(bigBulletData);

            remove();
    }
}
