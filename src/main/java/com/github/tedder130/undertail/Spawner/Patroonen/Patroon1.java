package com.github.tedder130.undertail.Spawner.Patroonen;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.tedder130.undertail.entities.attack.Attack;

import java.util.List;

public class Patroon1 extends Patronen {

    public Patroon1(){
        System.out.println("Patroon1 Constructor");
    }


    public void update() {
        //System.out.println(getTimers());
        System.out.println("Patroon1 update");
    }

    @Override
    public List<Timer> getTimers() {
        return List.of();
    }

    //als timer meer dan 1000 milli dan set boolean[0] op false;


}
