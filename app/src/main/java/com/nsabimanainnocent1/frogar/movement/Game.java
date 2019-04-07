package com.nsabimanainnocent1.frogar.movement;

import android.content.Context;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class Game {
    private ArrayList<Car> allCars = new ArrayList<>();
    private Frog frog;
    private FrogMovement frogMovement;
    private CarMovement carMovement;
    private int roadWidth, roadHeight;
    private GameStateUpdater gameStateUpdater;

    public Game(GameStateUpdater gameStateUpdater){
        this.gameStateUpdater = gameStateUpdater;
    }

    public void addCar(Car car){
        this.allCars.add(car);
    }

    public void setFrog(Frog frog) {
        this.frog = frog;
    }

    public void setCarMovement() {
        this.carMovement = new CarMovement(allCars, gameStateUpdater);
    }

    public void setFrogMovement(Context context) {
        this.frogMovement = new FrogMovement(frog, context);
    }

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
        carMovement.setRoadWidth(width);
        carMovement.setRoadHeight(height);
    }

    public void setCollisionDetector(){
        this.gameStateUpdater.setCollisionDetector(new CollisionDetector(frog, allCars));
    }


    public void starGame(){
//        this.carMovement.movement();
//        Timer t = new Timer();
//        t.scheduleAtFixedRate(carMovement, 0, 1000);
        this.carMovement.initiateMovement(carMovement);
        this.frogMovement.markActivate();
        this.frogMovement.activateFrog();
        gameStateUpdater.updateUI();
    }
}
