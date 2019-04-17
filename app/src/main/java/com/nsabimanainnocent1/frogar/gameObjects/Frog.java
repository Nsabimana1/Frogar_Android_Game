package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

public class Frog {
    private float x;
    private float y;
    private float xVelocity;
    private float yVelocity;
    private ImageView frogImage;
    private float initXPosition = 0, initYPosition = 0;

    public Frog(float x, float y, ImageView frogImage){
        this.x = x;
        this.y = y;
        this.frogImage = frogImage;
        this.frogImage.setX(x); this.frogImage.setY(y);
    }

//    public float getFrogTop(){return frogImage.getY();}
//    public float getFrogBottom(){return frogImage.getY() + frogImage.getHeight();}
//    public float getFrogLeft(){return frogImage.getX();}
//    public float getFrogRight(){return frogImage.getX() + frogImage.getWidth();}


///testing purpose
    public Integer getTop(){return (int) frogImage.getY() - frogImage.getHeight()/ 3 ;}
    public Integer getLeft(){return (int) frogImage.getX() - frogImage.getWidth()/ 3 ;}
    public Integer getRight(){return (int) frogImage.getX() + frogImage.getWidth()/ 3 ;}
    public Integer getBottom(){return (int) frogImage.getY() + frogImage.getHeight()/ 3;}


    public void changePosition(float x, float y){
        restrictInBoundaries(x, y);
        frogImage.setTranslationX(this.x);
        frogImage.setTranslationY(this.y);
    }
    public void restrictInBoundaries(float x, float y){
        if(x < -180){
            this.x = -180;
        }else if(x > 180){
            this.x = 180;
        }else {
            this.x = x;
        }

        if(y < -220){
            this.y = -220;
        }else if(y > 220){
            this.y = 220;
        }else {
            this.y = y;
        }
    }


    public Float getX(){
        return this.x;
    }

    public float getY() {
        return y;
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
