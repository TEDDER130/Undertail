package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.PlayArea;
import com.github.tedder130.undertail.entities.Player;
import com.github.tedder130.undertail.entities.attack.BigBullet;
import com.github.tedder130.undertail.entities.attack.Laser;
import com.github.tedder130.undertail.entities.attack.SmallBullet;
import com.github.tedder130.undertail.entities.text.HealthText;
import com.github.hanyaeger.api.Size;

import static javafx.scene.paint.Color.rgb;

public class GameLevel extends DynamicScene {

    //de X, Y, Width, Height
    public int[] PlayArea = {100, 200, 600, 300};
    public int[] sizePlayer = {27, 40};

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

        Coordinate2D healthTextCoordinate = new Coordinate2D(20, 20);
        HealthText healthText = new HealthText(healthTextCoordinate);
        addEntity(healthText);

        Coordinate2D playerCoordinate = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Player player = new Player(playerCoordinate, healthText, undertail, PlayArea);
        addEntity(player);

        Coordinate2D bulletCoordinate = new Coordinate2D(PlayArea[0] - sizePlayer[0] / 2, PlayArea[1] - sizePlayer[1] / 2);
        Laser laser = new Laser(bulletCoordinate, 45, true);
        addEntity(laser);
    }
}
