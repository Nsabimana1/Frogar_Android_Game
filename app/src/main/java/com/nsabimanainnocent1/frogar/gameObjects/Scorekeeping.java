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

    public void addPoint() {
        score += 1;
    }

    public int getScore() { return score; }

    public void reachedSide(){
        if(reachedRightZone){
            reachedLeftZone = false;
        }
        else{
            reachedLeftZone = true;
        }
    }

    public void frogScored(){
        if(xFrogPosition == leftScoreZone){
            reachedSide();
            addPoint();
        }else if(xFrogPosition == rightScoreZone){
            reachedSide();
            addPoint();
        }else{
            
        }
    }


}
