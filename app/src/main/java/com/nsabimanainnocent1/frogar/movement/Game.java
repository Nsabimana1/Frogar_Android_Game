package com.nsabimanainnocent1.frogar.movement;

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

    public void setFrogMovement() {
        this.frogMovement = new FrogMovement(frog);
    }

    public void setRoadDimension(Integer width, Integer height){
        this.roadWidth = width; this.roadHeight = height;
    }

    public void starGame(){
        this.carMovement.moveCars();
        carMovement.start();
    }
}
