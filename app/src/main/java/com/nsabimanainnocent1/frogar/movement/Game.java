package com.nsabimanainnocent1.frogar.movement;

import android.content.Context;
import android.util.Log;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class Game {
    private ArrayList<Car> allCars = new ArrayList<>();
    private Frog frog;
    private FrogMovement frogMovement;
    private CarMovement carMovement;
    private final int roadWidth = 180, scoreInterval = 10;
    private GameStateUpdater gameStateUpdater;
    private Integer scores = 0;
    private CollisionDetector collisionDetector;


    private boolean wasFrogInRightCorner = true, wasFrogInLeftCorner = true;
    private boolean isFrogInRightCorner = false, isFrogInLeftCorner = false;

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

    public void setCollisionDetector(){
        this.collisionDetector = new CollisionDetector(frog, allCars);
        this.gameStateUpdater.setCollisionDetector(collisionDetector);
    }

    public void starGame(){
        this.frogMovement.markActivate();
        this.frogMovement.activateFrog();
    }

    public void resetGame(){
        frogMovement.markDeActivate();
    }

    public CarMovement getCarMovement(){
        return this.carMovement;
    }

    public void checkScoring(){
        checkFrogPosition();
        if(isFrogInRightCorner && wasFrogInLeftCorner){
            this.scores += scoreInterval;
            wasFrogInLeftCorner = false;
            isFrogInRightCorner = false;
            wasFrogInRightCorner = true;
        }

        if(isFrogInLeftCorner && wasFrogInRightCorner){
            this.scores += scoreInterval;
            isFrogInLeftCorner = false;
            wasFrogInRightCorner = false;
            wasFrogInLeftCorner = true;
        }
    }

    public void checkFrogPosition(){
        this.isFrogInLeftCorner = (frog.getX() == -roadWidth);
        this.isFrogInRightCorner = (frog.getX() == roadWidth);
    }

    public boolean checkGameState(){
        boolean state = this.collisionDetector.checkWhetherCollided();
        if (state){
            resetCars();
        }
        return state;
    }

    public void resetCars(){
        carMovement.restCars();
    }

    public Integer getScores(){
        return this.scores;
    }

}
