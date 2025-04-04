package com.github.tedder130.undertail.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class WaveText extends TextEntity {
    public WaveText(Coordinate2D initialLocation){
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
    }

    public void setWaveText(int wave){
        setText("Wave: " + wave);
    }
}