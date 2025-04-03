package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.buttons.QuitButton;
import com.github.tedder130.undertail.buttons.RestartButton;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.rgb;

public class GameOver extends StaticScene {
    private Undertail undertail;

    public GameOver(Undertail undertail){
        this.undertail = undertail;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(rgb(0,0,0));
    }

    @Override
    public void setupEntities() {
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "GAMEOVER"
        );
        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(rgb(255,255,255));
        gameOverText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(gameOverText);

        Coordinate2D restartButtonLocation = new Coordinate2D(getWidth() / 3, (getHeight() / 3) * 2);
        RestartButton restartButton = new RestartButton(restartButtonLocation, undertail);
        addEntity(restartButton);

        Coordinate2D quitButtonLocation = new Coordinate2D((getWidth() / 3) * 2, (getHeight() / 3) * 2);
        QuitButton quitButton = new QuitButton(quitButtonLocation, undertail);
        addEntity(quitButton);
    }
}

