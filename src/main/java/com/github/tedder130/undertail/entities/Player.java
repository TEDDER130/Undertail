package com.github.tedder130.undertail.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.attack.Bullet;
import com.github.tedder130.undertail.entities.text.HealthText;
import com.github.tedder130.undertail.entities.attack.SmallBullet;
import javafx.scene.input.KeyCode;
import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collided {

    private Undertail undertail;
    private HealthText healthText;
    private int health = 100;
    private int[] playAreaPropoties;

    public Player(Coordinate2D location, HealthText healthText, Undertail undertail, int[] playAreaPropoties) {
        super("sprites/Player.png", location, new Size(40,40));
        this.healthText = healthText;
        this.undertail = undertail;
        this.playAreaPropoties = playAreaPropoties;
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
        } else if(pressedKeys.contains(KeyCode.S) && canMove(0)){
            setMotion(5,0d);
        } else if(pressedKeys.contains(KeyCode.A)){
            setMotion(5,270d);
        } else {
            setSpeed(0);
        }
    }

    public boolean canMove(int angle) {
        System.out.println(getAnchorLocation().getY());

        double x = getAnchorLocation().getX();
        double y = getAnchorLocation().getY();

        int xPosArea = playAreaPropoties[0];
        int yPosArea = playAreaPropoties[1];
        int width = playAreaPropoties[2];
        int height = playAreaPropoties[3];

        switch (angle) {
            case 0:
                if (y < height + yPosArea) {
                    setAnchorLocationY(height + yPosArea - 1);
                    return true;
                }
                break;
                case 45:
                    if (y < height + yPosArea && x < width + xPosArea) {
                        setAnchorLocationY(height + yPosArea - 1);
                        setAnchorLocationY(width + xPosArea - 1);
                        return true;
                    }
                    break;
                    case 90:
                        if (x < width + xPosArea) {
                            setAnchorLocationX(width + xPosArea - 1);
                            return true;
                        }
                        break;
                        case 135:
                            if (y > yPosArea && x < width + xPosArea) {
                                setAnchorLocationY(height + 1);
                                setAnchorLocationX(width + xPosArea - 1);
                            }
                            break;
            case: 180
        }
        return false;
    }


//    @Override
//    public void notifyBoundaryTouching(SceneBorder border){
//        setSpeed(0);
//
//        switch(border){
//            case TOP:
//                setAnchorLocationY(1);
//                break;
//            case BOTTOM:
//                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
//                break;
//            case LEFT:
//                setAnchorLocationX(1);
//                break;
//            case RIGHT:
//                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
//            default:
//                break;
//        }
//    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof Bullet) {
                Bullet bullet = (Bullet) collider;
                if (!bullet.getHit()) {
                    System.out.println("Hit By " + bullet);
                    this.health -= bullet.getDamage();
                }
                bullet.setHit(true);
            }
        }
        healthText.setHealthText(health);
    }
}
