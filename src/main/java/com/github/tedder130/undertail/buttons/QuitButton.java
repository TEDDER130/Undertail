package com.github.tedder130.undertail.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.Undertail;
import javafx.scene.input.MouseButton;

public class QuitButton extends GameButton {

    public QuitButton(Coordinate2D initialLocation, Undertail undertail) {
        super(initialLocation, "QUIT", undertail);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        undertail.quit();
    }
}