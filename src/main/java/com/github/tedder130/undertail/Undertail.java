package com.github.tedder130.undertail;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.tedder130.undertail.scenes.GameLevel;

public class Undertail extends YaegerGame {

    @Override
    public void setupGame() {
        setGameTitle("Undertail");
        setSize(new Size(800, 600));
    }


    @Override
    public void setupScenes(){
        //addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        //addScene(2, new GameOverScreen(this));
    }

    public static void main(String[] args) {
        launch(args);
    }
}