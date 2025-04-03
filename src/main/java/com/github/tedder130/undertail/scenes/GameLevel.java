package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.tedder130.undertail.Spawner.Patronen.*;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.PlayArea;
import com.github.tedder130.undertail.entities.Player;
import com.github.tedder130.undertail.entities.attack.BigBullet;
import com.github.tedder130.undertail.entities.attack.Laser;
import com.github.tedder130.undertail.entities.attack.SmallBullet;
import com.github.tedder130.undertail.entities.attack.Tile;
import com.github.tedder130.undertail.entities.text.HealthText;
import com.github.hanyaeger.api.Size;
import com.github.tedder130.undertail.entities.text.HighScoreText;
import com.github.tedder130.undertail.entities.text.ScoreText;
import com.github.tedder130.undertail.entities.text.WaveText;

import static javafx.scene.paint.Color.rgb;

public class GameLevel extends DynamicScene {

    //de X, Y, Width, Height
    final public int[] PlayArea = {100, 200, 600, 300};
    public int[] sizePlayer = {27, 40};
    private int wave = 3;
    private int highScore = 69;
    private int score = 4312;

    Undertail undertail;

    public GameLevel(Undertail undertail) {
        this.undertail = undertail;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/AreaBaackground.png");
        //calculatePlayArea();
    }

//    public void calculatePlayArea() {
//        System.out.println(getWidth() + " " + getHeight());
//    }

    @Override
    public void setupEntities() {
        Coordinate2D playAreaCoordinate = new Coordinate2D(PlayArea[0] - sizePlayer[0] / 2, PlayArea[1] - sizePlayer[1] / 2);
        Size playAreaSize = new Size(PlayArea[2] + sizePlayer[0] / 2, PlayArea[3] + sizePlayer[1] / 2);
        PlayArea playArea = new PlayArea(playAreaCoordinate, playAreaSize);
        addEntity(playArea);

        Coordinate2D healthTextCoordinate = new Coordinate2D(getWidth() / 3, 70);
        HealthText healthText = new HealthText(healthTextCoordinate);
        addEntity(healthText);

        Coordinate2D waveTextCoordinate = new Coordinate2D(getWidth() / 3, 130);
        WaveText waveText = new WaveText(waveTextCoordinate);
        addEntity(waveText);
        waveText.setWaveText(wave);

        Coordinate2D scoreTextCoordinate = new Coordinate2D(getWidth() / 3 * 2, 70);
        ScoreText scoreText = new ScoreText(scoreTextCoordinate);
        addEntity(scoreText);
        scoreText.setScoreText(score);

        Coordinate2D highScoreTextCoordinate = new Coordinate2D(getWidth() / 3 * 2, 130);
        HighScoreText highScoreText = new HighScoreText(highScoreTextCoordinate);
        addEntity(highScoreText);
        highScoreText.setHighScoreText(highScore);



        Coordinate2D playerCoordinate = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Player player = new Player(playerCoordinate, healthText, undertail, PlayArea);
        addEntity(player);

//        Coordinate2D bulletCoordinate = new Coordinate2D(PlayArea[0] - sizePlayer[0] / 2, PlayArea[1] - sizePlayer[1] / 2);
//        Laser laser = new Laser(bulletCoordinate, 45, true);
//        addEntity(laser);
//
//        Coordinate2D abulletCoordinate = new Coordinate2D(100, PlayArea[1] - sizePlayer[1] / 2 + 150);
//        BigBullet bigBullet = new BigBullet(abulletCoordinate, 0, PlayArea);
//        addEntity(bigBullet);
//
//        SmallBullet smallBullet = new SmallBullet(abulletCoordinate, 90, PlayArea);
//        addEntity(smallBullet);
//
//        Coordinate2D bulletCoordinatew = new Coordinate2D(PlayArea[0] - sizePlayer[0] / 2 + 100, PlayArea[1] - sizePlayer[1] / 2 + 100);
//        Tile tile = new Tile(bulletCoordinatew);
//        addEntity(tile);

        Containment containment = new Containment(this, PlayArea, sizePlayer);
        addEntity(containment);
    }

    public void spawnSmallBullet(int[] smallBulletData) {
        Coordinate2D smallBulletCoordinate = new Coordinate2D(smallBulletData[0], smallBulletData[1]);
        SmallBullet smallBullet = new SmallBullet(smallBulletCoordinate, smallBulletData[2], PlayArea);
        addEntity(smallBullet);
    }

    public void spawnBigBullet(int[] bigBulletData) {
        Coordinate2D bigBulletCoordinate = new Coordinate2D(bigBulletData[0], bigBulletData[1]);
        BigBullet bigBullet = new BigBullet(bigBulletCoordinate, bigBulletData[2], PlayArea);
        addEntity(bigBullet);
    }

    public void spawnLaser(int[] laserData) {
        boolean horizontal = (laserData[3] != 0);
        Coordinate2D laserCoordinate = new Coordinate2D(laserData[0], laserData[1]);
        Laser laser = new Laser(laserCoordinate, laserData[2], horizontal);
        addEntity(laser);
    }

    public void spawnTile(int[] tileData) {
        Coordinate2D tileCoordinate = new Coordinate2D(tileData[0], tileData[1]);
        Tile tile = new Tile(tileCoordinate);
        addEntity(tile);
    }
}