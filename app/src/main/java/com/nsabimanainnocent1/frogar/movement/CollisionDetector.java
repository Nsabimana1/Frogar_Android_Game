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

    public CollisionDetector(Frog frog, ArrayList<Car> allCars){
        this.frog = frog;
        this.allCars = allCars;
    }

    private Rect frogToRect(Frog frog){
        Rect frogRect = new Rect(frog.getLeft(), frog.getTop(), frog.getRight(), frog.getBottom());
        return frogRect;
    }

    private Rect carToRect(Car car){
        Rect carRect = new Rect(car.getLeft(), car.getTop(),  car.getRight(), car.getBottom());
        return carRect;
    }

    boolean checkWhetherCollided(){
        Rect frogRect = frogToRect(frog);
        for(Car car: allCars) {
            Rect carRect = carToRect(car);
            if (frogRect.intersect(carRect)) {
                isCollided = true;
                break;
            }else{
                isCollided = false;
            }
        }
        return  isCollided;
    }
}
