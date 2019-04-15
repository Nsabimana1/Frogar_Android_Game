package com.nsabimanainnocent1.frogar.gameObjects;

import android.graphics.Rect;
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
//
//    public float getCarY(){return carImage.getY();}
//    public float getCarX(){return carImage.getX();}
//    public float getCarBottom(){return carImage.getY() + carImage.getHeight();}
//    public float getCarTopRight(){return carImage.getX() + carImage.getWidth();}


    public Integer getTop(){return (int) carImage.getY() - carImage.getHeight()/ 3 ;}
    public Integer getLeft(){return (int) carImage.getX() - carImage.getWidth()/ 3 ;}
    public Integer getRight(){return (int) carImage.getX() + carImage.getWidth()/ 3 ;}
    public Integer getBottom(){return (int) carImage.getY() + carImage.getHeight()/ 3;}


    public void moveUp(Integer width, Integer height){
        this.y -= velY;
//        carImage.setY(this.y);
        setMovementRange(width, height);
    }

    public void moveDown(Integer width, Integer height){
        this.y += velY;
//        carImage.setY(this.y);
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
//        this.x = startingPositionX;
        this.y = startingPositionY;
        carImage.setTranslationY(y);
    }

    private void setMovementRange(Integer width, Integer height){
//        if (this.x <= width || this.x <= this.startingPositionX){
//            this.x = startingPositionX;
//        }
        if (this.y > startingPositionY + 600 && this.y > this.startingPositionY){
            this.y = startingPositionY;
        }

        if(this.y < this.startingPositionY && this.y < startingPositionY - 600 ){
            this.y = startingPositionY;
        }
        carImage.setTranslationY(this.y);
    }
}
