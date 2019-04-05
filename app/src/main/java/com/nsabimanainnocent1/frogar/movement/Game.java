package com.nsabimanainnocent1.frogar.movement;

import android.app.Activity;
import android.content.Context;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;
import java.util.Timer;

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

    public void setCarMovement(Activity where) {
        this.carMovement = new CarMovement(cars);
    }

    public void setFrogMovement(Context context) {
        this.frogMovement = new FrogMovement(frog, context);
    }

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
    }

    public void starGame(){
//        this.carMovement.movement();
//        Timer t = new Timer();
//        t.scheduleAtFixedRate(carMovement, 0, 1000);
        this.carMovement.initiateMovement(carMovement);
        this.frogMovement.markActivate();
        this.frogMovement.activateFrog();

    }
}
