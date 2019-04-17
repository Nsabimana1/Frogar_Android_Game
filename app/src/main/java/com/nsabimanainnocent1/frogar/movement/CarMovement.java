package com.nsabimanainnocent1.frogar.movement;

import android.animation.TimeAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;

import com.nsabimanainnocent1.frogar.gameObjects.Car;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CarMovement{
    private ArrayList<Car> allCars;
    private Timer timer = new Timer();
    private Date date = new Date();
    private long Time_Interval = 10;
    private GameStateUpdater gameStateUpdater;

    private Integer roadWidth = 0, roadHeight = 0;

    public CarMovement(ArrayList<Car> cars, GameStateUpdater gameStateUpdater) {
        this.allCars = cars;
        this.gameStateUpdater = gameStateUpdater;
    }

    public void setRoadWidth(Integer roadWidth){this.roadWidth = roadWidth;}
    public void setRoadHeight(Integer roadHeight){this.roadHeight = roadHeight;}

    public void moveCars() {
        for(int i = 0; i < allCars.size(); i++){
            if (i % 2 != 0) {
                allCars.get(i).moveUp(roadWidth, roadHeight);
            }else {
                allCars.get(i).moveDown(roadWidth, roadHeight);
            }
        }
    }

    public void restCars(){
        for(Car car: this.allCars){
            car.resetPosition();
        }
    }
}
