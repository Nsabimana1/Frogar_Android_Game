package com.nsabimanainnocent1.frogar.gameObjects;

public class Lives {

    public Lives(){}

    public int lives = 3;

    public void subtractLife(){
        lives -= 1;
        if(!hasLivesLeft()){
            //TODO add function/method that connects to game screen
        }else{

        }
    }

    private boolean hasLivesLeft(){
        if (lives <= 0){
            return false;
        }else{
            return true;
        }
    }



}
