package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

public class Car {
    private float x, y;
    private float velX, velY;
    private float startingPositionX, startingPositionY;
    private final float initialVelX = 2, initialVelY = 2;
    private int speedFactor = 2;
    private ImageView carImage;

    public Car(ImageView carImage){
        this.velX = initialVelX;
        this.velY = initialVelY;
        startingPositionX = carImage.getX();
        startingPositionY = carImage.getY();
        this.carImage = carImage;
        this.x = startingPositionX;
        this.y = startingPositionY;
    }

    public float getCarX(){return x;}
    public float getCarY(){return y;}
    public float getFrogTop(){return carImage.getTop();}
    public float getFrogBottom(){return carImage.getBottom();}
    public float getFrogLeft(){return carImage.getLeft();}
    public float getFrogRight(){return carImage.getRight();}
    public float getCarWidth(){return carImage.getWidth();}
    public float getCarHeight(){return carImage.getHeight();}

//    @Override
//    public void move() {
////        this.x += velX;
//        this.y += velY;
////        carImage.setTranslationX(this.x);
//        carImage.setTranslationY(this.y);
//    }

    public void moveUp(Integer width, Integer height){
        this.y -= velY;
        carImage.setTranslationY(this.y);
        setMovementRange(width, height);
    }

    public void moveDown(Integer width, Integer height){
        this.y += velY;
        carImage.setTranslationY(this.y);
        setMovementRange(width, height);
    }


    public void stop() {
        this.velX = 0;
        this.velY = 0;
    }

    public void speedUp() {
        this.velX *= speedFactor;
        this.velX *= speedFactor;
    }


    public void slowDown() {
        this.velX /= speedFactor;
        this.velX /= speedFactor;
    }

    public void resetPosition(){
        this.x = startingPositionX;
        this.y = startingPositionY;
    }

    private void setMovementRange(Integer width, Integer height){
//        if (this.x <= width || this.x <= this.startingPositionX){
//            this.x = startingPositionX;
//        }
        if (this.y > startingPositionY + 800 && this.y > this.startingPositionY){
            this.y = startingPositionY;
        }

        if(this.y < this.startingPositionY && this.y < startingPositionY - 800 ){
            this.y = startingPositionY;
        }
        carImage.setTranslationY(this.y);
    }
}
