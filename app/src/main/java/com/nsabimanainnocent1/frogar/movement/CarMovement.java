package com.nsabimanainnocent1.frogar.movement;

import android.view.animation.Animation;

import com.nsabimanainnocent1.frogar.gameObjects.Car;

import java.util.ArrayList;
import java.util.Timer;

public class CarMovement extends Timer {
    private long last = 0;
    private long Frames_Per_Second = 5L;
    private long Interval = 1000000000L / Frames_Per_Second;
    private ArrayList<Car> cars;

    public CarMovement(ArrayList<Car> cars){
        this.cars = cars;
    }

    public void moveCars(){

    }
}
