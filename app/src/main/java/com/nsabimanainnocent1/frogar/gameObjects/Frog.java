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

    public float getFrogX(){return x;}
    public float getFrogY(){return y;}
    public float getFrogTop(){return frogImage.getTop();}
    public float getFrogBottom(){return frogImage.getBottom();}
    public float getFrogLeft(){return frogImage.getLeft();}
    public float getFrogRight(){return frogImage.getRight();}
    public float getFrogWidth(){return frogImage.getWidth();}
    public float getFrogHeight(){return frogImage.getHeight();}

    public void changePosition(float x, float y){
        this.x = x;
        this.y = y;
        frogImage.setTranslationX(this.x);
        frogImage.setTranslationY(this.y);
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
