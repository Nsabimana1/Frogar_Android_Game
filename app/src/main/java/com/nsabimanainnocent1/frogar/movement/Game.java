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
    private int roadWidth, roadHeight;
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

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
        carMovement.setRoadWidth(width);
        carMovement.setRoadHeight(height);
    }

    public void setCollisionDetector(){
        this.collisionDetector = new CollisionDetector(frog, allCars);
        this.gameStateUpdater.setCollisionDetector(collisionDetector);
    }

    public Float getFrogX(){
        return this.frog.getX();
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
        Log.i("Game", "Entering checkScoring(); " + isFrogInRightCorner + "/" + wasFrogInRightCorner + ";" + isFrogInLeftCorner + "/" + wasFrogInLeftCorner);
        checkFrogPosition();
        if(isFrogInRightCorner && wasFrogInLeftCorner){
            Log.i("Game", "Score bump a");
            this.scores += 1;
            wasFrogInRightCorner = true;
            wasFrogInLeftCorner = false;
        }

        if(isFrogInLeftCorner && wasFrogInRightCorner){
            Log.i("Game", "Score bump b");
            this.scores += 1;
            wasFrogInLeftCorner = true;
            wasFrogInRightCorner = false;
        }
//        updateFrogPositionHistory();
    }

    public void checkFrogPosition(){
        this.isFrogInLeftCorner = (frog.getX() > 0 && frog.getX() < 20);
        this.isFrogInRightCorner = (frog.getX() > 640 && frog.getX() < 660);
    }

//    public void setCollisionDetector(){
//        this.collisionDetector = new CollisionDetector(frog, allCars);
//    }

    public void checkGameState(){
        boolean state = this.collisionDetector.checkWhetherCollided();
        if (state){
            Log.e("collision status", "We just colided");
        }else{
            Log.e("collision status", "We did not colide");
        }
    }

    public Integer getScores(){
        return this.scores;
    }

}
