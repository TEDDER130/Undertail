package com.github.tedder130.undertail.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;

public class PlayArea extends RectangleEntity {

    public PlayArea(Coordinate2D initialPosition, Size size) {
        super(initialPosition, size);
    }
}
