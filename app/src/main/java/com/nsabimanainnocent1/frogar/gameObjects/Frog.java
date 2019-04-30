package com.nsabimanainnocent1.frogar.gameObjects;

import android.widget.ImageView;

public class Frog {
    private float x, y;
    private ImageView frogImage;
    private final float roadHeight = 220, roadWidth = 180;
    private Integer divisionFactor = 3;

    public Frog(float x, float y, ImageView frogImage){
        this.x = x;
        this.y = y;
        this.frogImage = frogImage;
        this.frogImage.setX(x); this.frogImage.setY(y);
    }

    public Frog(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Integer getTop(){return (int) frogImage.getY() - frogImage.getHeight()/ divisionFactor ;}
    public Integer getLeft(){return (int) frogImage.getX() - frogImage.getWidth()/ divisionFactor ;}
    public Integer getRight(){return (int) frogImage.getX() + frogImage.getWidth()/ divisionFactor ;}
    public Integer getBottom(){return (int) frogImage.getY() + frogImage.getHeight()/ divisionFactor;}

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
}
