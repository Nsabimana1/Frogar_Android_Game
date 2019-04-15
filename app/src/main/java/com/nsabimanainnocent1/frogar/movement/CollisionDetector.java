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
        Rect frogRect = new Rect(frog.getLeft(), frog.getTop(), frog.getRight(), frog.getBottom());
//        frogRect.left = (int)frog.getFrogLeft();
//        frogRect.right = (int)frog.getFrogRight();
//        frogRect.top = (int)frog.getFrogTop();
//        frogRect.bottom = (int)frog.getFrogBottom();
        return frogRect;
    }

    private Rect carToRect(Car car){
        Rect carRect = new Rect(car.getLeft(), car.getTop(),  car.getRight(), car.getBottom());
//        carRect.left = (int)car.getCarY();
//        carRect.right = (int)car.getCarTopRight();
//        carRect.top = (int)car.getCarX();
//        carRect.bottom = (int)car.getCarBottom();
        return carRect;
    }

    boolean checkWhetherCollided(){
        Rect frogRect = frogToRect(frog);

        Log.i("CollisionDetector", "FrogRect: " + frogRect);
        for(Car car: allCars) {
            Log.e("Entering collision", "In collition dection");
            Rect carRect = carToRect(car);
            Log.i("CollisionDetector", "carRect: " + carRect);
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
