package com.nsabimanainnocent1.frogar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nsabimanainnocent1.frogar.gameObjects.Car;
import com.nsabimanainnocent1.frogar.gameObjects.Frog;
import com.nsabimanainnocent1.frogar.movement.Game;
import com.nsabimanainnocent1.frogar.movement.GameStateUpdater;

public class GameScreen extends AppCompatActivity {
    public ImageView imageViewRoad, frogImage, carImage1, carImage2;
    private TextView healthTitleView, scoreTitleView, scoreValueView, gameLevelView;
    private Button playButton, restartButton;
    private Integer scoreValue = 0;
    private Integer imageX = 0, imageY = 0;
    private Game game;
    private GameStateUpdater gameStateUpdater;

    private TextView testingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setComponents();
        initializeObjects();



        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game.starGame();
                imageX = imageViewRoad.getHeight();
                imageY = imageViewRoad.getWidth();
                testingView.setText(imageX.toString() + ", " + imageY.toString());
            }
        });


//        imageX = imageViewRoad.getX();
//        imageY = imageViewRoad.getY();
//        scoreValueView.setText(imageX.toString());
//        imageViewRoad.setX(new Float(4555));



//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setComponents(){
        imageViewRoad = findViewById(R.id.imageViewRoad);
        healthTitleView = findViewById(R.id.heathTitle);
        scoreTitleView = findViewById(R.id.scoreTitle);
        scoreValueView = findViewById(R.id.scoreValue);
        frogImage = findViewById(R.id.fromImage);
        playButton = findViewById(R.id.Play_Button);
        restartButton = findViewById(R.id.Restart_Button);
        carImage1 = findViewById(R.id.car1);
        carImage2 = findViewById(R.id.car2);

        testingView = findViewById(R.id.testing);
        gameLevelView = findViewById(R.id.gameLevel);
    }

    private void initializeObjects(){
        gameStateUpdater = new GameStateUpdater(scoreValueView, healthTitleView, gameLevelView);
        game = new Game(gameStateUpdater);
        game.setFrog(new Frog(frogImage.getX(), frogImage.getY(), frogImage));
        game.setFrogMovement(this);
        game.addCar(new Car(carImage1));
        game.addCar(new Car(carImage2));
        game.setCarMovement();
        game.setRoadDimension(imageViewRoad.getHeight(), imageViewRoad.getWidth());
        game.setCollisionDetector();
    }

    public void resetCarLocation(ImageView car, ImageView parent){
        float topOfCar = car.getY();
        if(topOfCar == parent.getHeight()){
            car.setY(0);
        }
    }

}
