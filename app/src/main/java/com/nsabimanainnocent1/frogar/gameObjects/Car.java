package com.nsabimanainnocent1.frogar.gameObjects;

import android.graphics.Rect;
import android.widget.ImageView;

public class Car {
    private float x, y;
    private float velX, velY;
    private float startingPositionX, startingPositionY;
    private final float initialVelX = 2, initialVelY = 2;
    private int carDimensionDivisionFactor = 3;
    private ImageView carImage;
    private final int roadHeight  = 600;

    public Car(ImageView carImage){
        this.velX = initialVelX;
        this.velY = initialVelY;
        startingPositionX = carImage.getX();
        startingPositionY = carImage.getY();
        this.carImage = carImage;
        this.x = startingPositionX;
        this.y = startingPositionY;
    }

    // for testing purpose
    public Car(float x, float y){
        this.velX = initialVelX;
        this.velY = initialVelY;
        startingPositionX = x;
        startingPositionY = y;
        this.x = startingPositionX;
        this.y = startingPositionY;
    }
    public Integer getTop(){return (int) carImage.getY() - carImage.getHeight()/ carDimensionDivisionFactor ;}
    public Integer getLeft(){return (int) carImage.getX() - carImage.getWidth()/ carDimensionDivisionFactor ;}
    public Integer getRight(){return (int) carImage.getX() + carImage.getWidth()/ carDimensionDivisionFactor ;}
    public Integer getBottom(){return (int) carImage.getY() + carImage.getHeight()/ carDimensionDivisionFactor;}

    public Float getX(){return this.x;}
    public Float getY(){return this.y;}

    public void moveUp(){
        this.y -= velY;
        setMovementRange();
    }

    public void moveDown(){
        this.y += velY;
        setMovementRange();
    }

    public void resetPosition(){
        this.y = startingPositionY;
        carImage.setTranslationY(y);
    }

    private void setMovementRange(){
        if (this.y > startingPositionY + roadHeight && this.y > this.startingPositionY){
            this.y = startingPositionY;
        }

        if(this.y < this.startingPositionY && this.y < startingPositionY - roadHeight ){
            this.y = startingPositionY;
        }
        carImage.setTranslationY(this.y);
    }
}
