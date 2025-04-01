package com.github.tedder130.undertail.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.text.HealthText;
import com.github.tedder130.undertail.entities.aanval.SmallBullet;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided {

    private Undertail undertail;
    private HealthText healthText;
    private int health = 100;

    public Player(Coordinate2D location, HealthText healthText, Undertail undertail) {
        super("sprites/Player.png", location, new Size(40,40));
        this.healthText = healthText;
        this.undertail = undertail;
        healthText.setHealthText(health);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.W) && pressedKeys.contains(KeyCode.D)) {
            setMotion(5,135d);
        } else if (pressedKeys.contains(KeyCode.D) && pressedKeys.contains(KeyCode.S)) {
            setMotion(5,45d);
        } else if (pressedKeys.contains(KeyCode.S) && pressedKeys.contains(KeyCode.A)) {
            setMotion(5,315d);
        } else if (pressedKeys.contains(KeyCode.A) && pressedKeys.contains(KeyCode.W)) {
            setMotion(5,225);
        } else if(pressedKeys.contains(KeyCode.W)){
            setMotion(5,180d);
        } else if(pressedKeys.contains(KeyCode.D)){
            setMotion(5,90d);
        } else if(pressedKeys.contains(KeyCode.S)){
            setMotion(5,0d);
        } else if(pressedKeys.contains(KeyCode.A)){
            setMotion(5,270d);
        } else {
            setSpeed(0);
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border){
        setSpeed(0);

        switch(border){
            case TOP:
                setAnchorLocationY(1);
                break;
            case BOTTOM:
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if(!((SmallBullet) collider).getHit()) {
                System.out.println("Hit By" + collider);
                this.health -= ((SmallBullet) collider).getDamage();
            }
            ((SmallBullet) collider).setHit(true);
        }
        healthText.setHealthText(health);
    }
}
