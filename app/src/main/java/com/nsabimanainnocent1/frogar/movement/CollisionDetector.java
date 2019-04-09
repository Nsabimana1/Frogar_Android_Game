package com.nsabimanainnocent1.frogar.movement;

import android.graphics.Rect;
import android.util.Log;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

class CollisionDetector {
    private ArrayList<Car> allCars;
    private Frog frog;
    private boolean isCollided = false;
    private static final int modifiedHitBox = 5;

    CollisionDetector(Frog frog, ArrayList<Car> allCars){
        this.frog = frog;
        this.allCars = allCars;
    }

    private Rect frogToRect(Frog frog){
        Rect frogRect = new Rect();
        frogRect.left = frog.getFrogLeft();
        frogRect.right = frog.getFrogRight();
        frogRect.top = frog.getFrogTop();
        frogRect.bottom = frog.getFrogBottom();
        return frogRect;
    }

    private Rect carToRect(Car car){
        Rect carRect = new Rect();
        carRect.left = car.getCarLeft();
        carRect.right = car.getCarRight();
        carRect.top = car.getCarTop();
        carRect.bottom = car.getCarBottom();
        return carRect;
    }

    boolean checkWhetherCollided(){
        Rect frogRect = frogToRect(frog);
        for(Car car: allCars) {
            Log.e("Entering collision", "In collition dection");
            Rect carRect = carToRect(car);
            if (frogRect.intersect(carRect)) {
                Log.e("When colided", "We have surely colided");
                isCollided = true;
                break;
            }else{
                isCollided = false;
            }
        }
        return  isCollided;
    }
}
