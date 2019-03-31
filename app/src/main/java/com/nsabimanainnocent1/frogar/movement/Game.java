package com.nsabimanainnocent1.frogar.movement;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class Game {
    private ArrayList<Car> cars = new ArrayList<>();
    private Frog frog;

    private Game(){}

    private void addCar(Car car){
        this.cars.add(car);
    }

}
