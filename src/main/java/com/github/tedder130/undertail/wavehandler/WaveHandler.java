package com.github.tedder130.undertail.wavehandler;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.tedder130.undertail.scenes.GameLevel;
import com.github.tedder130.undertail.wavehandler.Patronen.Patroon;

import java.util.ArrayList;
import java.util.List;

public class WaveHandler extends DynamicRectangleEntity implements TimerContainer {

    private GameLevel gameLevel;
    private List<Timer> timers = new ArrayList<>();
    private int lastRandom;
    private int random;

    public WaveHandler(GameLevel gameLevel) {
        super(new Coordinate2D(-100,-100), new Size(1,1));
        this.gameLevel = gameLevel;
    }

    public void newWave() {

        while (random == lastRandom) {
            random = (int) (Math.random() * 4);
        }

        if (random == 0) {
            gameLevel.spawnWave("barrage");
        } else if (random == 1) {
            gameLevel.spawnWave("chessboard");
        } else if (random == 2) {
            gameLevel.spawnWave("crossfire");
        } else if (random == 3) {
            gameLevel.spawnWave("containment");
        }

        lastRandom = random;
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
            super(1000);
            this.waveHandler = waveHandler;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            waveHandler.newWave();
        }
    }
}
