package com.nsabimanainnocent1.frogar;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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
    public ImageView imageViewRoad, frogImage, carImage1, carImage2, carImage3, pBFull, pBHalf, pbEmpty;
    private TextView healthTitleView, scoreTitleView, scoreValueView, gameLevelView;
    private Button playButton, restartButton;
    private Integer scoreValue = 0;
    private Integer imageX = 0, imageY = 0;
    private Game game;
    private GameStateUpdater gameStateUpdater;
    private Integer lives = 3;

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
        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton();
                game.starGame();
            }
        });


//        imageX = imageViewRoad.getX();
//        imageY = imageViewRoad.getY();
//        scoreValueView.setText(imageX.toString());
//        imageViewRoad.setX(new Float(4555));

    }

    private void setComponents(){
        imageViewRoad = findViewById(R.id.imageViewRoad);
        pbEmpty = findViewById(R.id.ProgressBarEmpty);
        pBFull = findViewById(R.id.ProgressBarFull);
        pBHalf = findViewById(R.id.ProgressBarHalf);
        healthTitleView = findViewById(R.id.heathTitle);
        scoreTitleView = findViewById(R.id.scoreTitle);
        scoreValueView = findViewById(R.id.scoreValue);
        frogImage = findViewById(R.id.fromImage);
        playButton = findViewById(R.id.Play_Button);
        restartButton = findViewById(R.id.Restart_Button);
        carImage1 = findViewById(R.id.car1);
        carImage2 = findViewById(R.id.car2);
        carImage3 = findViewById(R.id.car3);

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
        game.addCar(new Car(carImage3));
        game.setCarMovement();
        game.setRoadDimension(imageViewRoad.getHeight(), imageViewRoad.getWidth());
        game.setCollisionDetector();
        pBHalf.setVisibility(View.INVISIBLE);
        pbEmpty.setVisibility(View.INVISIBLE);
    }
    public void resetButton(){
        this.initializeObjects();
    }

    public void ProgressBar(Boolean collision){
        if(collision && lives == 2){
            pBFull.setVisibility(View.INVISIBLE);
            pBHalf.setVisibility(View.VISIBLE);
            lives -= 1;
            scoreValue -= 1;
        }
        else if(collision && lives == 1){
            pBHalf.setVisibility(View.INVISIBLE);
            pbEmpty.setVisibility(View.VISIBLE);
            lives -=1;
            scoreValue -= 1;
        }
        else if(lives == 0) {
            AlertDialog.Builder loseAlert = new AlertDialog.Builder(GameScreen.this);
            loseAlert.setMessage("Your Score was:" + scoreValue+". Would you like to try again?")
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                            resetButton();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

        }

    }
    public void updateLevel() {
        int level = 0;
        if (scoreValue % 10 == 10) {
            gameLevelView.setText("Level:" + level);
            level +=1;
        }
    }
    public int updateScore(boolean hasReachedGoal){
        scoreTitleView.setText("Score:" + scoreValue);
        return scoreValue += 10;
    }
    public static void updateUI(){
    }
}
