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

public class CarMovement extends TimerTask{
//    private long last = 0;
//    private long Frames_Per_Second = 5L;
//    private long Interval = 1000000000L / Frames_Per_Second;
    private ArrayList<Car> allCars;
    private Timer timer = new Timer();
    private Date date = new Date();
    private boolean isMoving;
    private long Time_Interval = 10;
    private GameStateUpdater gameStateUpdater;

    private Integer roadWidth = 0, roadHeight = 0;


    public CarMovement(ArrayList<Car> cars, GameStateUpdater gameStateUpdater) {
        this.allCars = cars;
        this.isMoving = false;
        this.gameStateUpdater = gameStateUpdater;
    }

    public void setRoadWidth(Integer roadWidth){this.roadWidth = roadWidth;}
    public void setRoadHeight(Integer roadHeight){this.roadHeight = roadHeight;}

    public void moveCars() {
        for(int i = 0; i <allCars.size(); i++){
            if (i % 2 == 0) {
                allCars.get(i).moveUp(roadWidth, roadHeight);
            }else {
                allCars.get(i).moveDown(roadWidth, roadHeight);
            }

            Log.i("Car " + allCars.get(i), "has is at position " + allCars.get(i).getCarY());
        }
//        for (Car car : allCars) {
//            car.move();
//        }
    }

    @Override
    public void run() {
        Log.i("CarMovement", "Hi, I moved!");
        moveCars();
        this.gameStateUpdater.changeGameState();
    }

    public void initiateMovement(TimerTask activity){
        if(!this.isMoving) {
            this.isMoving = true;
            Timer t = new Timer();
            t.scheduleAtFixedRate(activity, 0, this.Time_Interval);
        }
    }

    public void restCars(){
        this.isMoving = false;
        for(Car car: this.allCars){
            car.resetPosition();
        }
    }

//
//    public void handle(long now) {
//        if((now - last) > Interval){
//            moveCars();
//        }
//        this.last = now;
//    }

//    }

//    @Override
//    public long scheduledExecutionTime(){
//        return super.scheduledExecutionTime();
//    }


}
