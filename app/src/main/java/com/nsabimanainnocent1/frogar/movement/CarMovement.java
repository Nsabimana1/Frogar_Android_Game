package com.nsabimanainnocent1.frogar.movement;

import android.animation.TimeAnimator;
import android.view.animation.Animation;

import com.nsabimanainnocent1.frogar.gameObjects.Car;

import java.util.ArrayList;
import java.util.Timer;

public class CarMovement extends TimeAnimator {
    private long last = 0;
    private long Frames_Per_Second = 5L;
    private long Interval = 1000000000L / Frames_Per_Second;
    private ArrayList<Car> allCars;

    public CarMovement(ArrayList<Car> cars){
        this.allCars = cars;
    }

    public void moveCars(){
        for (Car car: allCars){
            car.move();
        }
    }

    public void handle(long now) {
        if((now - last) > Interval){
            moveCars();
        }
        this.last = now;
    }

}
