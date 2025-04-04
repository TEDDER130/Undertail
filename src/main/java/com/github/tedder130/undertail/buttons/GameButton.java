package com.github.tedder130.undertail.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.tedder130.undertail.Undertail;
import javafx.scene.Cursor;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.rgb;

public abstract class GameButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    protected Undertail undertail;

    public GameButton(Coordinate2D initialLocation, String text, Undertail undertail) {
        super(initialLocation, text);
        setFill(rgb(255, 255, 255));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.undertail = undertail;
    }

    @Override
    public void onMouseEntered() { setCursor(Cursor.HAND); }

    @Override
    public void onMouseExited() { setCursor(Cursor.DEFAULT); }
}
