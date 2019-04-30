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
import com.nsabimanainnocent1.frogar.gameObjects.ScoreKeeper;
import com.nsabimanainnocent1.frogar.movement.Game;

import java.util.Timer;
import java.util.TimerTask;

public class GameScreen extends AppCompatActivity {
    public ImageView imageViewRoad, frogImage, carImage1, carImage2, carImage3, pBFull, pBHalf, pbEmpty;
    private TextView scoreValueView, gameLevelView;
    private Button playButton, restartButton;
    private Integer scoreValue = 0, initialTimerInterval = 40, timerInterval = initialTimerInterval;
    private Game game;
    private boolean isMoving = false;
    private Timer timer;
    private ScoreKeeper scoreKeeper;
    private final String tryAgainMessage = "Would you like to try again?";
    private final String nextLevelMessage = "Would you like to continue to the next level?";
    private final Integer reductionInterval = 10, fullHealth = 3, halfHealth = 2, lowHealth = 1;

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
                setTimer();
                rumTimer();
            }
        });

        restartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetButton();
                game.resetGame();
            }
        });
    }

    private void setComponents(){
        imageViewRoad = findViewById(R.id.imageViewRoad);
        pbEmpty = findViewById(R.id.ProgressBarEmpty);
        pBFull = findViewById(R.id.ProgressBarFull);
        pBHalf = findViewById(R.id.ProgressBarHalf);
        scoreValueView = findViewById(R.id.scoreValue);
        frogImage = findViewById(R.id.fromImage);
        playButton = findViewById(R.id.Play_Button);
        restartButton = findViewById(R.id.Restart_Button);
        carImage1 = findViewById(R.id.car1);
        carImage2 = findViewById(R.id.car2);
        carImage3 = findViewById(R.id.car3);
        gameLevelView = findViewById(R.id.gameLevel);
    }

    private void initializeObjects(){
        scoreKeeper = new ScoreKeeper();
        game = new Game();
        game.setFrog(new Frog(frogImage.getX(), frogImage.getY(), frogImage));
        game.setFrogMovement(this);
        game.addCar(new Car(carImage1));
        game.addCar(new Car(carImage2));
        game.addCar(new Car(carImage3));
        game.setCarMovement();
        game.setCollisionDetector();
        game.setScoreKeeper(scoreKeeper);
        pBFull.setVisibility(View.VISIBLE);
        pBHalf.setVisibility(View.INVISIBLE);
        pbEmpty.setVisibility(View.INVISIBLE);

    }
    public void resetButton(){
        this.initializeObjects();
    }

    public void manageHealthProgress(Boolean collisionHappened){
        if(collisionHappened && scoreKeeper.getPlayerHealth() == fullHealth){
            scoreKeeper.updatePlayerHealth(collisionHappened);
            changeHealthView(pBHalf, pBFull);
        }else if (collisionHappened && scoreKeeper.getPlayerHealth() == halfHealth){
            scoreKeeper.updatePlayerHealth(collisionHappened);
            changeHealthView(pbEmpty, pBHalf);
        }else if(collisionHappened && scoreKeeper.getPlayerHealth() == lowHealth){
            this.stopTimer();
            showDialogBox(tryAgainMessage);
        }
    }

    private void promptNextLevel(){
        if(scoreKeeper.hasReachedMaxScores()){
            stopTimer();
            setTimer();
            showDialogBox(nextLevelMessage);
        }
    }

    private void nextLevelSettings(){
        pBFull.setVisibility(View.VISIBLE);
        setTimer();
        scoreKeeper.increaseGameLevel();
        scoreKeeper.resetScoreKeeper();
        speedTimerInterval();
        rumTimer();
    }


    public void changeHealthView(ImageView toMakeVisibleImage, ImageView toHideImage){
        toMakeVisibleImage.setVisibility(View.VISIBLE);
        toHideImage.setVisibility(View.INVISIBLE);
    }

    public void updateUI(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assignUIValues();
            }
        });
    }

    public void assignUIValues(){
        this.scoreValue = scoreKeeper.getScore();
        this.scoreValueView.setText(scoreValue.toString());
        this.gameLevelView.setText("Level: " + scoreKeeper.getGameLevel().toString());
        this.manageHealthProgress(game.checkGameState());
        promptNextLevel();
    }

    public void changeGameState(){
        updateUI();
    }

    public void rumTimer(){
        if(!this.isMoving) {
            this.isMoving = true;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    game.getCarMovement().moveCars();
                    game.trackFrogMovementForScoring();
                    changeGameState();
                }
            }, 0, timerInterval);
        }
    }

    public void stopTimer(){
        timer.cancel();
        this.isMoving = false;
    }

    public void speedTimerInterval(){
        this.timerInterval -= reductionInterval;
    }

    public void setTimer(){
        this.timer = new Timer();
        this.timerInterval = initialTimerInterval;
    }

    public void resetGameSettings(){
        setTimer();
        game.resetCars();
        resetButton();
    }

    public void showDialogBox(final String message) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(GameScreen.this);
        builder.setCancelable(false);
        builder.setTitle("Game Status");
        builder.setMessage("Your Score was:" + scoreValue+". " + message);
        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                /// Todo write code here
                dialog.cancel();
                if(message.equals(nextLevelMessage)){
                    nextLevelSettings();
                }else{
                    resetGameSettings();
                }
            }
        })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /// Todo write code here
                        finish();
                    }
                });
        // Create the AlertDialog object and return it
        builder.create().show();
    }
}
