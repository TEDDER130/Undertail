package com.github.tedder130.undertail.wavehandler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.tedder130.undertail.entities.Player;
import com.github.tedder130.undertail.scenes.GameLevel;

import java.util.ArrayList;
import java.util.List;

public class WaveHandler extends DynamicRectangleEntity implements TimerContainer {

    private GameLevel gameLevel;
    private Player player;
    private List<Timer> timers = new ArrayList<>();
    private int delay = 1000;
    private int counter = 0;
    private int lastRandom;
    private int random;

    public WaveHandler(GameLevel gameLevel, Player player) {
        super(new Coordinate2D(-100,-100), new Size(1,1));
        this.gameLevel = gameLevel;
        this.player = player;
    }

    public void newWave() {
        while (random == lastRandom) {
            random = (int) (Math.random() * 5);
        }

        if (random == 0) {
            gameLevel.spawnWave("barrage");
        } else if (random == 1) {
            gameLevel.spawnWave("chessboard");
        } else if (random == 2) {
            gameLevel.spawnWave("crossfire");
        } else if (random == 3) {
            gameLevel.spawnWave("containment");
        } else if (random == 4) {
            gameLevel.spawnWave("cross");
        }

        lastRandom = random;

        if (counter % 5 == 0) {
            player.increaseWave(1);
            delay-=5;
            gameLevel.decreaseIndication();
        }
        counter++;
    }

    @Override
    public void setupTimers() {
        System.out.println("Wave timer ran");
        addTimer(new WaveTimer(this));
    }

    @Override
    public List<Timer> getTimers() {
        return timers;
    }

    protected static class WaveTimer extends Timer {

        private WaveHandler waveHandler;

        protected WaveTimer(final WaveHandler waveHandler) {
            super(waveHandler.delay);
            this.waveHandler = waveHandler;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            waveHandler.newWave();
        }
    }
}
