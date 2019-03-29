package com.nsabimanainnocent1.frogar.gameObjects;

public class Frog implements Object {
    private long x;
    private long y;
    private long velX;
    private long velY;

    public Frog(long x, long y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {

    }

    @Override
    public void stop() {
        velX = 0;
        velY = 0;
    }

    @Override
    public void speedUp() {

    }

    @Override
    public void slowDown() {

    }


}
