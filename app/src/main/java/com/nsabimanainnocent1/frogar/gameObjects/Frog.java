package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.movement.FrogMovement;

public class Frog implements Object {
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private ImageView frogImage;

    public Frog(float x, float y, ImageView frogImage){
        this.x = x;
        this.y = y;
        this.frogImage = frogImage;
    }

    public int getFrogTop(){return frogImage.getTop();}
    public int getFrogBottom(){return frogImage.getBottom();}
    public int getFrogLeft(){return frogImage.getLeft();}
    public int getFrogRight(){return frogImage.getRight();}


    public void changePosition(float x, float y){
        this.x = x;
        this.y = y;
        frogImage.setTranslationX(this.x);
        frogImage.setTranslationY(this.y);
    }

    @Override
    public void move() {
//        xVelocity = frogMovement.getXVelocity();
//        xSpeedCap();
//        yVelocity = frogMovement.getYVelocity();
//        ySpeedCap();
    }

    @Override
    public void stop() {
        xVelocity = 0;
        yVelocity = 0;
    }

    @Override
    public void speedUp() {

    }

    @Override
    public void slowDown() {

    }

    public void setXVelocity(long xSpeed){
        xVelocity = xSpeed;
    }

    public void setYVelocity(long ySpeed){
        yVelocity = ySpeed;
    }

    public void xSpeedCap(){
//        if(frogMovement.getXVelocity() >= 50){
//            setXVelocity(50);
//        }else{
//
//        }
    }

    public void ySpeedCap(){
//        if(frogMovement.getYVelocity() >= 50){
//            setYVelocity(50);
//        }else{
//
//        }
    }

}
