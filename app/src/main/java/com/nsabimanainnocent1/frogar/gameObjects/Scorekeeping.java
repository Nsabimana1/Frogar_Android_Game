package com.nsabimanainnocent1.frogar.gameObjects;

public class Scorekeeping {

    public Scorekeeping(){
    }

    public int score = 0;
    public int leftScoreZone;
    public boolean reachedLeftZone = true;
    public int rightScoreZone;
    public boolean reachedRightZone = false;
    public int xFrogPosition;

    public void frogScored(){
        reachedSide();
        if(xFrogPosition == leftScoreZone){
            addPoint();
        }else if(xFrogPosition == rightScoreZone){
            addPoint();
        }
    }

    public void addPoint() {
        score += 1;
    }

    public void reachedSide(){
        if(reachedRightZone){
            reachedLeftZone = false;
        }
        else{
            reachedLeftZone = true;
        }
    }
}
