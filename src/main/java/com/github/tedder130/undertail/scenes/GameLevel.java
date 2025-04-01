package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.Player;
import com.github.tedder130.undertail.entities.text.HealthText;
import javafx.scene.Scene;

public class GameLevel extends DynamicScene {

    Undertail undertail;

    public GameLevel(Undertail undertail) {
        this.undertail = undertail;
    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        Coordinate2D healthTextCoordinate = new Coordinate2D(20, 20);
        HealthText healthText = new HealthText(healthTextCoordinate);
        addEntity(healthText);

        Coordinate2D playerCoordinate = new Coordinate2D(getWidth() / 2, getHeight() / 2);
        Player player = new Player(playerCoordinate, healthText, undertail);
        addEntity(player);
    }
}
