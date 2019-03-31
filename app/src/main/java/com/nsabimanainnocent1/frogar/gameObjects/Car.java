package com.nsabimanainnocent1.frogar.gameObjects;

import com.nsabimanainnocent1.frogar.gameObjects.Object;

public class Car implements Object {
    private long x;
    private long y;
    private long velX;
    private long velY;
    private final int speedFactor = 2;

    public Car(long x, long y, long velX, long velY){
        this.x = x;
        this.y = x;
        this.velX = velX;
        this.velY = velY;
    }


    @Override
    public void move() {
        this.x += velX;
        this.y += velY;
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

    private void moveInRange(Integer width, Integer height){

    }
}
