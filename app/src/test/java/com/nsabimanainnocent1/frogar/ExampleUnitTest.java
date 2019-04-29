package com.nsabimanainnocent1.frogar;

import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private float startX = 200;
    private float startY = 300;
    private Car car = new Car(startX, startY);
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void frogRectangleCreated_isCorrect(){
    }

    @Test
    public void checkCarMovement(){

    }
}