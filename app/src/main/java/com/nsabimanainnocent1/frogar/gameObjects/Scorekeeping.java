package com.nsabimanainnocent1.frogar.gameObjects;

import android.view.Display;
import android.view.WindowManager;

import com.nsabimanainnocent1.frogar.GameScreen;

public class Scorekeeping {

    public int score = 0;
    public int leftScoreZone;
    public boolean reachedLeftZone = true;
    public int rightScoreZone;
    public boolean reachedRightZone = false;
    public int frogPosition;

    public void addPoint() {
        score += 1;
    }

    public int getScore() { return score; }

    public void checkLeftScoreZone(){
        if(frogPosition == leftScoreZone){
            reachedLeftZone = true;
            reachedRightZone = false;
            addPoint();
        }else{

        }
    }

    public void checkRightScoreZone(){
        if(frogPosition == rightScoreZone){
            reachedRightZone = true;
            reachedLeftZone = false;
            addPoint();
        }else{
            
        }
    }

}
