package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.tedder130.undertail.scenes.GameLevel;

public class Offlimits extends Patroon {

    int x = 0;
    int y = 0;

    public Offlimits(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);

    }

    @Override
    public void generateEntities() {
        int[] tileData = new int[2];

        int randomX = (int) (Math.random() * 5);
        int randomY = (int) (Math.random() * 2);

        tileData[0] = playArea[0] - sizePlayer[0] / 2 + (randomX * 102);
        tileData[1] = playArea[1] - sizePlayer[1] / 2 + (randomY * 107);

        gameLevel.spawnTile(tileData);

        remove();
    }
}