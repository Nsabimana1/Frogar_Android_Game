package com.nsabimanainnocent1.frogar.gameObjects;

import com.nsabimanainnocent1.frogar.movement.FrogMovement;

public class Frog implements Object {
    private long x;
    private long y;
    private long xVelocity;
    private long yVelocity;

    public Frog(long x, long y){
        this.x = x;
        this.y = y;
    }

    FrogMovement frogMovement = new FrogMovement();

    @Override
    public void move() {
        xVelocity = frogMovement.getXVelocity();
        xSpeedCap();
        yVelocity = frogMovement.getYVelocity();
        ySpeedCap();
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
        if(frogMovement.getXVelocity() >= 50){
            setXVelocity(50);
        }else{

        }
    }

    public void ySpeedCap(){
        if(frogMovement.getYVelocity() >= 50){
            setYVelocity(50);
        }else{

        }
    }

}
