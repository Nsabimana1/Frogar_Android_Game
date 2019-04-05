package com.nsabimanainnocent1.frogar.movement;

import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;

import java.util.ArrayList;

public class CollisionDetector {
    private ArrayList<Car> allCars;
    private Frog frog;
    private boolean isCollided;
    private Integer nCollisions;

    public CollisionDetector(Frog frog, ArrayList<Car> allCars){
        this.frog = frog;
        this.allCars = allCars;
    }

    public void setImageListener(final ImageView image){
        image.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(){
            public void onGlobalLayout(){
                int height = image.getHeight();
                int width = image.getWidth();
                int x = image.getLeft();
                int y = image.getTop();
                image.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

        });
    }

}
