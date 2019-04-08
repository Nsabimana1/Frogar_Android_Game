package com.nsabimanainnocent1.frogar.movement;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;


public class GameStateUpdater {
    private TextView scoreView, healthView, gameLevelView;
    private Integer gameScore, healthScore, gameLevelValue;
    private CollisionDetector collisionDetector;
    private Intent intent;

    public GameStateUpdater(TextView scoreView, TextView healthView, TextView gameLevelView){
        this.scoreView = scoreView;
        this.healthView =  healthView;
        this.gameLevelView = gameLevelView;
        this.gameScore = 0; this.healthScore = 5; this.gameLevelValue = 1;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector) {
        this.collisionDetector = collisionDetector;
    }

    public void reduceHealth(){
        if (collisionDetector.checkWhetherCollided()){
            this.healthScore -= 1;
            Log.i("Collision happened", "Hi, We collided");
        }
    }

    public void increaseScore(){
        this.gameScore += 2;
    }

    public void changeGameState(){
        this.reduceHealth();
    }
}
