package com.nsabimanainnocent1.frogar.movement;

import android.graphics.Rect;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class CollisionDetector {
    private ArrayList<Car> allCars;
    private Frog frog;
    private boolean isCollided = false;
    private Integer nCollisions;
    private static final int modifiedHitbox = 5;


    public CollisionDetector(Frog frog, ArrayList<Car> allCars){
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


        //TODO Will refactor later to clean up, still need to finish
   /* public boolean isCarAndFrogOverlap(Car car, Frog frog){
        boolean isOverlapping = false;
        float carX = car.getCarX(); //top left x
        float carY = car.getCarY(); // top left y
        float carWidth = car.getCarWidth();
        float carHeight = car.getCarHeight();
        float carRightCorners = carX + carWidth;
        float carBottomCorners = carY + carHeight;
        if((frogX >= carX && frogX <= carRightCorners) && (frogY >= carY && frogY <= carBottomCorners)){ //top left of frog is overlapping car
            isOverlapping = true;
        }else if((frogRightCorners >= carX && frogRightCorners <= carRightCorners) && (frogY >= carY && frogY <= carBottomCorners)) {//top right of frog is overlapping car
            isOverlapping = true;
        }else if((frogX >= carX && frogX <= carRightCorners) && (frogBottomCorners >= carY && frogBottomCorners <= carBottomCorners)){//bottom left of frog is overlapping car
            isOverlapping = true;
        }else if((frogRightCorners >= carX && frogRightCorners <= carRightCorners) && (frogBottomCorners >= carY && frogBottomCorners <= carBottomCorners)){//bottom right of frog is overlapping car
            isOverlapping = true;
            //for if cars corners overlap but frogs does not
        }else if((carX >= frogX && carX <= frogRightCorners) && (carY >= frogY && carY <= frogBottomCorners)){ //top left of car is overlapping frog
            isOverlapping = true;
        }else if((carRightCorners >= frogX && carRightCorners <= frogRightCorners) && (carY >= frogY && carY <= frogBottomCorners)) {//top right of car is overlapping frog
            isOverlapping = true;
        }else if((carX >= frogX && carX <= frogRightCorners) && (carBottomCorners >= frogY && carBottomCorners <= frogBottomCorners)){//bottom left of car is overlapping frog
            isOverlapping = true;
        }else if((carRightCorners >= frogX && carRightCorners <= frogRightCorners) && (carBottomCorners >= frogY && carBottomCorners <= frogBottomCorners)){//bottom right of car is overlapping frog
            isOverlapping = true;
        }
        return isOverlapping;
    } */

    boolean checkWhetherCollided(){
        Rect frogRect = frogToRect(frog);
        for(Car car: allCars) {
            Rect carRect = carToRect(car);
            if (Rect.intersects(frogRect,carRect)) {
                isCollided = true;
                break;
            }else{
                isCollided = false;
            }
        }
        return  isCollided;
    }
}
