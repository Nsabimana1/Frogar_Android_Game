package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Object;

public class Car implements Object {
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

    @Override
    public void move() {
//        this.x += velX;
        this.y += velY;
//        carImage.setTranslationX(this.x);
        carImage.setTranslationY(this.y);
    }

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

    @Override
    public void stop() {
        this.velX = 0;
        this.velY = 0;
    }

    @Override
    public void speedUp() {
        this.velX *= speedFactor;
        this.velX *= speedFactor;
    }

    @Override
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
        if (this.y > startingPositionY + 600){
            this.y = startingPositionY;
        }

        if(this.y < this.startingPositionY){
            this.y = startingPositionY + 600;
        }
        carImage.setTranslationY(this.y);
    }
}
