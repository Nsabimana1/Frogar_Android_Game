package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

public class Frog {
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

    public Float getX(){
        return this.x;
    }

    public float getY() {
        return y;
    }

    public void move() {
//        xVelocity = frogMovement.getXVelocity();
//        xSpeedCap();
//        yVelocity = frogMovement.getYVelocity();
//        ySpeedCap();
    }


    public void stop() {
        xVelocity = 0;
        yVelocity = 0;
    }


    public void slowDown() {
        this.xVelocity -= 10;
        this.yVelocity -= 10;
    }

    public void setXVelocity(long xSpeed){
        xVelocity = xSpeed;
    }

    public void setYVelocity(long ySpeed){
        yVelocity = ySpeed;
    }

}
