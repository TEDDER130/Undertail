package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.tedder130.undertail.wavehandler.Patronen.*;
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
import com.github.tedder130.undertail.wavehandler.WaveHandler;

import java.util.Objects;

public class GameLevel extends DynamicScene {

    //de X, Y, Width, Height
    final public int[] PlayArea = {100, 200, 600, 300};
    public int[] sizePlayer = {27, 40};
    public int indication = 500;
    private Player player;

    Undertail undertail;

    public GameLevel(Undertail undertail) {
        this.undertail = undertail;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/AreaBaackground.png");
    }

    @Override
    public void setupEntities() {
        Coordinate2D playAreaCoordinate = new Coordinate2D(PlayArea[0] - sizePlayer[0] / 2, PlayArea[1] - sizePlayer[1] / 2);
        Size playAreaSize = new Size(PlayArea[2] + sizePlayer[0] / 2, PlayArea[3] + sizePlayer[1] / 2);
        PlayArea playArea = new PlayArea(playAreaCoordinate, playAreaSize);
        addEntity(playArea);

        Coordinate2D healthTextCoordinate = new Coordinate2D(getWidth() / 3, 70);
        HealthText healthText = new HealthText(healthTextCoordinate);
        addEntity(healthText);
        healthText.setHealthText(100);

        Coordinate2D waveTextCoordinate = new Coordinate2D(getWidth() / 3, 130);
        WaveText waveText = new WaveText(waveTextCoordinate);
        addEntity(waveText);
        waveText.setWaveText(0);

        Coordinate2D scoreTextCoordinate = new Coordinate2D(getWidth() / 3 * 2, 70);
        ScoreText scoreText = new ScoreText(scoreTextCoordinate);
        addEntity(scoreText);
        scoreText.setScoreText(0);

        Coordinate2D highScoreTextCoordinate = new Coordinate2D(getWidth() / 3 * 2, 130);
        HighScoreText highScoreText = new HighScoreText(highScoreTextCoordinate);
        addEntity(highScoreText);
        highScoreText.setHighScoreText(undertail.highScore);


        Coordinate2D playerCoordinate = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Player player = new Player(playerCoordinate, healthText, scoreText, highScoreText, waveText, undertail, PlayArea);
        this.player = player;
        addEntity(player);

        WaveHandler waveHandler = new WaveHandler(this, player);
        addEntity(waveHandler);
    }

    public void spawnSmallBullet(int[] smallBulletData) {
        Coordinate2D smallBulletCoordinate = new Coordinate2D(smallBulletData[0], smallBulletData[1]);
        SmallBullet smallBullet = new SmallBullet(smallBulletCoordinate, smallBulletData[2], PlayArea, player, indication);
        addEntity(smallBullet);
    }

    public void spawnBigBullet(int[] bigBulletData) {
        Coordinate2D bigBulletCoordinate = new Coordinate2D(bigBulletData[0], bigBulletData[1]);
        BigBullet bigBullet = new BigBullet(bigBulletCoordinate, bigBulletData[2], PlayArea, player, indication);
        addEntity(bigBullet);
    }

    public void spawnLaser(int[] laserData) {
        boolean horizontal = (laserData[2] != 0);
        Coordinate2D laserCoordinate = new Coordinate2D(laserData[0], laserData[1]);
        Laser laser = new Laser(laserCoordinate, laserData[3], horizontal, player, indication);
        addEntity(laser);
    }

    public void spawnTile(int[] tileData) {
        Coordinate2D tileCoordinate = new Coordinate2D(tileData[0], tileData[1]);
        Tile tile = new Tile(tileCoordinate, player, indication);
        addEntity(tile);
    }

    public void spawnWave(String pattern) {
        if(Objects.equals(pattern, "barrage")) {
            Barrage barrage = new Barrage(this, PlayArea, sizePlayer);
            addEntity(barrage);
        } else if (Objects.equals(pattern, "chessboard")) {
            Chessboard chessboard = new Chessboard(this, PlayArea, sizePlayer);
            addEntity(chessboard);
        } else if (Objects.equals(pattern, "containment")) {
            Containment containment = new Containment(this, PlayArea, sizePlayer);
            addEntity(containment);
        } else if (Objects.equals(pattern, "crossfire")) {
            Crossfire crossfire = new Crossfire(this, PlayArea, sizePlayer);
            addEntity(crossfire);
        } else if (Objects.equals(pattern, "cross")) {
            Cross cross = new Cross(this, PlayArea, sizePlayer);
            addEntity(cross);
        } else if (Objects.equals(pattern, "offlimits")) {
            Offlimits offlimits = new Offlimits(this, PlayArea, sizePlayer);
            addEntity(offlimits);
        } else if (Objects.equals(pattern, "bulletcross")) {
            BulletCross bulletCross = new BulletCross(this, PlayArea, sizePlayer);
            addEntity(bulletCross);
        }
    }

    public void decreaseIndication() {
        if (indication > 250) {
            indication-=5;
        }
    }
}