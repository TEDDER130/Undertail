package com.github.tedder130.undertail.Spawner.Patronen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.entities.attack.Tile;
import com.github.tedder130.undertail.scenes.GameLevel;

public class Chessboard extends Patroon {

    int x = 0;
    int y = 0;

    public Chessboard(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(gameLevel, playArea, sizePlayer);
    }

    @Override
    public void generateEntities() {
        System.out.println("Generate entities ran");
        System.out.println("x: " + this.x + " y: " + this.y);
        int[] tileData = new int[2];


            if(x % 2 == 0) {
                tileData[0] = playArea[0] - sizePlayer[0] / 2 + (this.x * 102);
                tileData[1] = playArea[1] - sizePlayer[1] / 2 + (this.y * 107);
                if (y % 2 == 1) {
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