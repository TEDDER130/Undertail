package com.github.tedder130.undertail.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.tedder130.undertail.Undertail;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.scene.paint.Color.rgb;

public class RestartButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private Undertail undertail;

    public RestartButton(Coordinate2D initialLocation, Undertail undertail){
        super(initialLocation,"RESTART");
        setFill(rgb(255,255,255));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        this.undertail = undertail;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        undertail.setActiveScene(1);
    }

    @Override
    public void onMouseEntered(){
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setCursor(Cursor.DEFAULT);
    }
}
