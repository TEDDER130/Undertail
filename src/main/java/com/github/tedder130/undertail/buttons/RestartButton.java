package com.github.tedder130.undertail.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.tedder130.undertail.Undertail;
import javafx.scene.input.MouseButton;

public class RestartButton extends GameButton {

    public RestartButton(Coordinate2D initialLocation, Undertail undertail) {
        super(initialLocation, "RESTART", undertail);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        undertail.setActiveScene(1);
    }
}