package com.github.tedder130.undertail.wavehandler.Patronen;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.tedder130.undertail.scenes.GameLevel;

import java.util.ArrayList;
import java.util.List;

public abstract class Patroon extends DynamicRectangleEntity implements TimerContainer {

    protected GameLevel gameLevel;
    protected int[] playArea;
    protected int[] sizePlayer;
    private List<Timer> timers = new ArrayList<>();

    public Patroon(GameLevel gameLevel, int[] playArea, int[] sizePlayer) {
        super(new Coordinate2D(-100, 100), new Size(1,1));
        this.gameLevel = gameLevel;
        this.playArea = playArea;
        this.sizePlayer = sizePlayer;
    }

    public abstract void generateEntities();

    @Override
    public void setupTimers() {
        System.out.println("Setup timers ran");
        addTimer(new PatroonTimer(this));
    }

    @Override
    public List<Timer> getTimers() {
        return timers;
    }

    protected static class PatroonTimer extends Timer {

        private Patroon patroon;

        protected PatroonTimer(final Patroon patroon) {
            super(25);
            this.patroon = patroon;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            System.out.println("Patroon update ran");
            patroon.generateEntities();
        }
    }
}