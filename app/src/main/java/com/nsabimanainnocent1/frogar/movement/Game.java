package com.nsabimanainnocent1.frogar.movement;

import android.content.Context;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class Game {
    private ArrayList<Car> cars = new ArrayList<>();
    private Frog frog;
    private FrogMovement frogMovement;
    private CarMovement carMovement;
    private int roadWidth, roadHeight;
    public Game(){
    }

    public void addCar(Car car){
        this.cars.add(car);
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }

    public void setCarMovement() {
        this.carMovement = new CarMovement(cars);
    }

    public void setFrogMovement(Context context) {
        this.frogMovement = new FrogMovement(frog, context);
    }

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
    }

    public void starGame(){
        this.carMovement.moveCars();
        this.frogMovement.markActivate();
        this.frogMovement.activateFrog();

    }
}
