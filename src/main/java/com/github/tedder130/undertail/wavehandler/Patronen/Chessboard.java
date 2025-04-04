package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.tedder130.undertail.scenes.GameLevel;

public class Chessboard extends Patroon {

    int x = 0;
    int y = 0;
    int random;

    public Chessboard(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
        random = (int) (Math.random() * 2);
    }

    @Override
    public void generateEntities() {
        int[] tileData = new int[2];


            if(x % 2 == 0) {
                tileData[0] = playArea[0] - sizePlayer[0] / 2 + (this.x * 102);
                tileData[1] = playArea[1] - sizePlayer[1] / 2 + (this.y * 107);
                if (y % 2 == random) {
                    tileData[0]+=105;
                }
                gameLevel.spawnTile(tileData);
            }


        if(x >= 5 && y >= 2) {
            remove();
        } else if (x >= 5) {
            y++;
            x = 0;
        } else {
            x++;
        }
    }
}