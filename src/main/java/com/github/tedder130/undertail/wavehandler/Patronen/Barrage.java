package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.tedder130.undertail.scenes.GameLevel;

public class Barrage extends Patroon {

    int x = 0;

    public Barrage(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {

        int[] bigBulletData = new int[3];

            bigBulletData[0] = playArea[0] - (sizePlayer[0] / 4) * 3 + (this.x * 61) + 23;
            bigBulletData[1] = playArea[1] - sizePlayer[1] / 2;
            bigBulletData[2] = 0;

        gameLevel.spawnBigBullet(bigBulletData);

        if (x > 6) {
            remove();
        } else {
            x++;
        }
    }
}