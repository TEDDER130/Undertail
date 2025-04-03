package com.github.tedder130.undertail.Spawner.Patroonen;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.tedder130.undertail.entities.attack.Attack;

import java.util.ArrayList;

public abstract class Patronen implements TimerContainer {

    boolean[] patroonActive = new boolean[1];
    private static ArrayList<Patronen> patronen = new ArrayList<Patronen>();

    public abstract void update();

    public Patronen () {

    }

    public static void initPatronen() {  // Initialiseer patronen hier (bijvoorbeeld in je Game-class)
        patronen.add(new Patroon1());
//        patronen.add(new Patroon1());
//        patronen.add(new Patroon1());
//        patronen.add(new Patroon1());
//        patronen.add(new Patroon1());
    }

    public void setPatroonActive(int index) {
        this.patroonActive[index] = true;
    }

    public void updatePatroon() {
        for (int i = 0 ; i < patroonActive.length ; i++) {
            //if (patroonActive[i]) {
                patronen.get(i).update();
            //}
        }
    }

    @Override
    public void setupTimers() {
        addTimer(new Patronen.PatroonTimer(this));
    }

    protected static class PatroonTimer extends Timer {

        private Patronen patronen;

        protected PatroonTimer(final Patronen patronen) {
            super(10);
            this.patronen = patronen;
        }

        @Override
        public void onAnimationUpdate(final long timestamp) {
            patronen.updatePatroon();
        }
    }
}

