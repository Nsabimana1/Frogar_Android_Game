package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

public class Frog {
    private float x;
    private float y;
    private ImageView frogImage;
    private final float roadHeight = 220, roadWidth = 180;

    public Frog(float x, float y, ImageView frogImage){
        this.x = x;
        this.y = y;
        this.frogImage = frogImage;
        this.frogImage.setX(x); this.frogImage.setY(y);
    }

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
        if(x < - roadWidth){
            this.x = -roadWidth;
        }else if(x > roadWidth){
            this.x = roadWidth;
        }else {
            this.x = x;
        }

        if(y < - roadHeight){
            this.y = -roadHeight;
        }else if(y > roadHeight){
            this.y = roadHeight;
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

}
