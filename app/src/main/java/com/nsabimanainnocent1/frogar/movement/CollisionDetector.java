package com.nsabimanainnocent1.frogar.movement;

import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class CollisionDetector {
    private ArrayList<Car> allCars;
    private Frog frog;
    private boolean isCollided;
    private Integer nCollisions;
    public static final int modifiedHitbox = 5;

    public CollisionDetector(Frog frog, ArrayList<Car> allCars){
        this.frog = frog;
        this.allCars = allCars;
    }

    public void resetCarLocation(ImageView car, ImageView parent){
        float topOfCar = car.getY();
        if(topOfCar == parent.getHeight()){
            car.setY(0);
        }
    }
        //TODO Will refactor later to clean up, still need to finish
    public boolean isCarAndFrogOverlap(Car car, Frog frog){
        boolean isOverlapping = false;
        float carX = car.getCarX(); //top left x
        float carY = car.getCarY(); // top left y
        float carWidth = car.getCarWidth();
        float carHeight = car.getCarHeight();
        float carRightCorners = carX + carWidth;
        float carBottomCorners = carY + carHeight;
        float frogX = frog.getFrogX() + modifiedHitbox;
        float frogY = frog.getFrogY()+ modifiedHitbox;
        float frogWidth = frog.getFrogWidth() - modifiedHitbox;
        float frogHeight = frog.getFrogHieght() - modifiedHitbox;
        float frogRightCorners = frogX + frogWidth;
        float frogBottomCorners = frogY + frogHeight;
        if((frogX >= carX && frogX <= carRightCorners) && (frogY >= carY && frogY <= carBottomCorners)){
            isOverlapping = true;
        } else if ((frogRightCorners >= carX && frogRightCorners <= carRightCorners) && (frogY >= carY && frogY <= carBottomCorners)) {
            isOverlapping = true;
        }
        return isOverlapping;
    }

    public void checkForCollision(){


    }



}
