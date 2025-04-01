package com.github.tedder130.undertail.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.tedder130.undertail.Undertail;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.rgb;

public class TitleScene extends StaticScene {
    private Undertail undertail;

    public TitleScene(Undertail undertail){
        this.undertail = undertail;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(rgb(0,0,0));
    }

    @Override
    public void setupEntities() {
        var undertailText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "UNDERTAIL"
        );
        undertailText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        undertailText.setFill(rgb(255,255,255));
        undertailText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(undertailText);
    }
}
