package com.github.tedder130.undertail.entities.drops;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.tedder130.undertail.scenes.GameLevel;

public class Drop extends DynamicSpriteEntity implements Collider {
    private String typeDrop;

    public Drop(String resource, Coordinate2D initialLocation, String typeDrop) {
        super(resource, initialLocation, new Size(20, 20));
        this.typeDrop = typeDrop;
        System.out.println("DROP: " + typeDrop);
    }

    public String getTypeDrop() {
        return typeDrop;
    }
}
