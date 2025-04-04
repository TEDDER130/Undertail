package com.github.tedder130.undertail.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.tedder130.undertail.Undertail;
import com.github.tedder130.undertail.entities.attack.Bullet;
import com.github.tedder130.undertail.entities.attack.Laser;
import com.github.tedder130.undertail.entities.attack.Tile;
import com.github.tedder130.undertail.entities.drops.Drop;
import com.github.tedder130.undertail.entities.text.HealthText;
import com.github.tedder130.undertail.entities.text.HighScoreText;
import com.github.tedder130.undertail.entities.text.ScoreText;
import com.github.tedder130.undertail.entities.text.WaveText;
import com.github.tedder130.undertail.scenes.GameLevel;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, Collided {

    private Undertail undertail;
    private HealthText healthText;
    private ScoreText scoreText;
    private HighScoreText highScoreText;
    private WaveText waveText;
    private GameLevel gameLevel;
    public int health = 100;
    public int wave = 0;
    public int score = 0;
    private int[] playAreaProperties;

    public Player(Coordinate2D location, HealthText healthText, ScoreText scoreText, HighScoreText highScoreText, WaveText waveText, Undertail undertail, int[] playAreaPropoties, GameLevel gameLevel) {
        super("sprites/Player.png", location, new Size(40, 40));
        this.healthText = healthText;
        this.scoreText = scoreText;
        this.highScoreText = highScoreText;
        this.waveText = waveText;
        this.undertail = undertail;
        this.gameLevel = gameLevel;
        this.playAreaProperties = playAreaPropoties;
        healthText.setHealthText(health);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.W) && pressedKeys.contains(KeyCode.D) && canMove(135)) {
            setMotion(5, 135d);
        } else if (pressedKeys.contains(KeyCode.D) && pressedKeys.contains(KeyCode.S) && canMove(45)) {
            setMotion(5, 45d);
        } else if (pressedKeys.contains(KeyCode.S) && pressedKeys.contains(KeyCode.A) && canMove(315)) {
            setMotion(5, 315d);
        } else if (pressedKeys.contains(KeyCode.A) && pressedKeys.contains(KeyCode.W) && canMove(225)) {
            setMotion(5, 225);
        } else if (pressedKeys.contains(KeyCode.W) && canMove(180)) {
            setMotion(5, 180d);
        } else if (pressedKeys.contains(KeyCode.D) && canMove(90)) {
            setMotion(5, 90d);
        } else if (pressedKeys.contains(KeyCode.S) && canMove(0)) {
            setMotion(5, 0d);
        } else if (pressedKeys.contains(KeyCode.A) && canMove(270)) {
            setMotion(5, 270d);
        } else {
            setSpeed(0);
        }
    }

    public boolean canMove(int angle) {
        double x = getAnchorLocation().getX();
        double y = getAnchorLocation().getY();

        int xPosArea = playAreaProperties[0] - 13;
        int yPosArea = playAreaProperties[1] -20;
        int width = playAreaProperties[2] - 13;
        int height = playAreaProperties[3] - 20;

        switch (angle) {
            case 0:
                if (y >= height + yPosArea) {
                    setAnchorLocationY(height + yPosArea);
                    return false;
                }
                break;
            case 45:
                if (y >= height + yPosArea) {
                    setAnchorLocationY(height + yPosArea);
                    return false;
                }
                if (x >= width + xPosArea) {
                    setAnchorLocationX(width + xPosArea);
                    return false;
                }
                break;
            case 90:
                if (x >= width + xPosArea) {
                    setAnchorLocationX(width + xPosArea);
                    return false;
                }
                break;
            case 135:
                if (x >= width + xPosArea) {
                    setAnchorLocationX(width + xPosArea);
                    return false;
                }
                if (y <= yPosArea) {
                    setAnchorLocationY(yPosArea);
                    return false;
                }
                break;
            case 180:
                if (y <= yPosArea) {
                    setAnchorLocationY(yPosArea);
                    return false;
                }
                break;
            case 225:
                if (y <= yPosArea) {
                    setAnchorLocationY(yPosArea);
                    return false;
                }
                if (x <= xPosArea) {
                    setAnchorLocationX(xPosArea);
                    return false;
                }
                break;
            case 270:
                if (x <= xPosArea) {
                    setAnchorLocationX(xPosArea);
                    return false;
                }
                break;
            case 315:
                if (x <= xPosArea) {
                    setAnchorLocationX(xPosArea);
                    return false;
                }
                if (y >= height + yPosArea) {
                    setAnchorLocationY(height + yPosArea);
                    return false;
                }
        }
        return true;
    }

    public void deathCheck() {
        if (this.health <= 0){
            undertail.setActiveScene(2);
        }
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof Bullet) {
                Bullet bullet = (Bullet) collider;
                if (bullet.canHit()) {
                    System.out.println("Hit By " + bullet + " Damage: " + bullet.getDamage());
                    this.health -= bullet.getDamage();
                    deathCheck();
                }
                bullet.setCanHit(false);
            } else if (collider instanceof Laser) {
                Laser laser = (Laser) collider;
                if (laser.canHit()) {
                    System.out.println("Hit By " + laser);
                    laser.setLastHit();
                    this.health -= laser.getDamage();
                    deathCheck();
                }
            } else if (collider instanceof Tile) {
                Tile tile = (Tile) collider;
                if (tile.canHit()) {
                    System.out.println("Hit By " + tile);
                    tile.setLastHit();
                    this.health -= tile.getDamage();
                    deathCheck();
                }
            } else if (collider instanceof Drop) {
                Drop drop = (Drop) collider;
                String typeDrop = drop.getTypeDrop();

                if (typeDrop == "Coin") {
                    increaseScore(50);
                    drop.remove();
                    gameLevel.spawnDrop();
                } else if (typeDrop == "Health") {
                    drop.remove();
                    increaseHealth(25);
                    gameLevel.spawnDrop();
                }

            }
        }
        healthText.setHealthText(health);
    }

    public void increaseScore(int amount) {
        score += amount;
        scoreText.setScoreText(score);
        if (score > undertail.highScore) {
            undertail.highScore = score;
            highScoreText.setHighScoreText(undertail.highScore);
        }
    }

    public void increaseWave(int amount) {
        wave+=amount;
        waveText.setWaveText(wave);
    }

    public void increaseHealth(int amount) {
        health += amount;
        healthText.setHealthText(health);
    }
}
