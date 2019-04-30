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

    public CarMovement(ArrayList<Car> cars) {
        this.allCars = cars;
    }

    public void moveCars() {
        for(int i = 0; i < allCars.size(); i++){
            if (i % 2 != 0) {
                allCars.get(i).moveUp();
            }else {
                allCars.get(i).moveDown();
            }
        }
    }

    public void restCars(){
        for(Car car: this.allCars){
            car.resetPosition();
        }
    }
}
