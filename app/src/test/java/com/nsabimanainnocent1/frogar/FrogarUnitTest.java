package com.nsabimanainnocent1.frogar;

import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;
import com.nsabimanainnocent1.frogar.gameObjects.ScoreKeeper;
import com.nsabimanainnocent1.frogar.movement.CollisionDetector;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FrogarUnitTest {
    private float startX = 200;
    private float startY = 300;
    private Car car = new Car(startX, startY);
    private ScoreKeeper scoreKeeper = new ScoreKeeper();
    private ArrayList<Car> cars = new ArrayList<>();
    private CollisionDetector collisionDetector;
    private Frog frog;

    @Before
    public void setUpData(){
        loadCars();
        frog = new Frog(startX, startY);
        collisionDetector = new CollisionDetector(frog, cars);
    }

    public void loadCars(){
        for(int i= 1; i < 3; i++){
            this.cars.add(new Car(startX, startX));
        }
    }

    //Theses two unit tests do not run because they have imageViews attached to them
//    @Test
//    public void testCollision(){
//        assertTrue(collisionDetector.checkWhetherCollided());
//    }
//
//    @Test
//    public void checkCarMovement(){
//        float start = car.getY();
//        car.moveDown();
//        assertTrue(start != car.getY());
//    }

    @Test
    public void testScores(){
        Integer initScore = scoreKeeper.getScore();
        scoreKeeper.increaseScore();
        Integer scoreAfterIncrement = scoreKeeper.getScore();
        assertTrue(initScore != scoreAfterIncrement);
    }

    @Test
    public void testGameLevels(){
        Integer initGameLevel = scoreKeeper.getGameLevel();
        scoreKeeper.increaseGameLevel();
        assertTrue(initGameLevel != scoreKeeper.getGameLevel());
    }

    @Test
    public void testPlayerHealth(){
        Integer initialHealth = scoreKeeper.getPlayerHealth();
        Boolean collisionHappened = true;
        scoreKeeper.updatePlayerHealth(collisionHappened);
        assertTrue(initialHealth != scoreKeeper.getPlayerHealth());
    }

    @Test
    public void testCarObject(){
        assertTrue(car != null);
    }

    @Test
    public void testLoadingCarObjects(){
        assertTrue(cars.size() > 1);
    }

    @Test
    public void testFrogObject(){
        assertTrue(frog != null);
    }
}