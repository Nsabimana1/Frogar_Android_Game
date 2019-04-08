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
    private Integer scores = 0;

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

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
        carMovement.setRoadWidth(width);
        carMovement.setRoadHeight(height);
    }

    public void setCollisionDetector(){
        this.gameStateUpdater.setCollisionDetector(new CollisionDetector(frog, allCars));
    }

    public Float getFrogX(){
        return this.frog.getFrogX();
    }



    public void starGame(){
//        this.carMovement.movement();
//        Timer t = new Timer();
//        t.scheduleAtFixedRate(carMovement, 0, 1000);
//        this.carMovement.initiateMovement(carMovement);
        this.frogMovement.markActivate();
        this.frogMovement.activateFrog();
//        gameStateUpdater.updateUI();
    }

    public void resetGame(){
        frogMovement.markDeActivate();
    }

    public CarMovement getCarMovement(){
        return this.carMovement;
    }

    public void updateFrogPositionHistory(){
        this.wasFrogInLeftCorner = !this.wasFrogInLeftCorner;
        this.wasFrogInRightCorner = !this.isFrogInRightCorner;
        this.isFrogInRightCorner = !this.isFrogInRightCorner;
        this.isFrogInLeftCorner = !this.isFrogInLeftCorner;
    }

    public void checkScoring(){
        checkFrogPosition();
        if(isFrogInRightCorner && wasFrogInLeftCorner){
            this.scores += 1;
            wasFrogInRightCorner = true;
            wasFrogInLeftCorner = false;
        }

        if(isFrogInLeftCorner && wasFrogInRightCorner){
            this.scores += 1;
            wasFrogInLeftCorner = true;
            wasFrogInRightCorner = false;
        }
//        updateFrogPositionHistory();
    }

    public void checkFrogPosition(){
        if(frog.getFrogX() > 0 && frog.getFrogX() < 20){
            this.isFrogInLeftCorner = true;
        }

        if(frog.getFrogX() > 648 && frog.getFrogX() < 650){
            this.isFrogInRightCorner = true;
        }
    }

    public Integer getScores(){
        return this.scores;
    }

}
