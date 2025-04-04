package com.github.tedder130.undertail.wavehandler.Pattern;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.tedder130.undertail.scenes.GameLevel;

import java.util.ArrayList;
import java.util.List;

public abstract class Pattern extends DynamicRectangleEntity implements TimerContainer {

    protected GameLevel gameLevel;
    protected int[] playArea;
    protected int[] sizePlayer;
    private List<Timer> timers = new ArrayList<>();

    public Pattern(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(new Coordinate2D(-100, 100), new Size(1,1));
        this.gameLevel = gameLevel;
        this.playArea = playArea;
        this.sizePlayer = sizePlayer;
    }

    public abstract void generateEntities();

    @Override
    public void setupTimers() {
        addTimer(new PatternTimer(this));
    }

    @Override
    public List<Timer> getTimers() {
        return timers;
    }

    protected static class PatternTimer extends Timer {

        private Pattern patroon;

        protected PatternTimer(final Pattern patroon) {
            super(25);
            this.patroon = patroon;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            patroon.generateEntities();
        }
    }
}