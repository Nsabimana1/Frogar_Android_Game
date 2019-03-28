package com.nsabimanainnocent1.frogar;

public class Lives {

    public int lives = 3;

    public void subtractLife(int livesLeft){
        livesLeft -= 1;
        if(!hasLivesLeft(livesLeft)){
            //TODO add function/method
        }
    }

    public boolean hasLivesLeft(int livesLeft){
        boolean hasLives;
        if (livesLeft <= 0){
            hasLives = false;
        }else{
            hasLives = true;
        }
        return hasLives;
    }



}
