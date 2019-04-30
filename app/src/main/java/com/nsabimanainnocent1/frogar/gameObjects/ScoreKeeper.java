package com.nsabimanainnocent1.frogar.gameObjects;

public class ScoreKeeper {
    public Integer score;
    private Integer gameLevel, maxGameLevel = 10, scoreInterval = 10, maxScore = 100;
    private Integer playerHealth;
    private final Integer initialGameLevel = 1, initialPlayerHealth = 3, incrementCounter = 1, initialScore = 0;

    public ScoreKeeper(){
        gameLevel = initialGameLevel;
        playerHealth = initialPlayerHealth;
        this.score = initialScore;
    }
    public void increaseGameLevel(){
        this.gameLevel += incrementCounter;
    }

    public boolean hasReachedMaxLevel(){
        return this.gameLevel == maxGameLevel;
    }

    public boolean isHealthFinished(){
        return this.playerHealth == 0;
    }

    public Boolean hasReachedMaxScores(){
        return this.score == maxScore;
    }

    public Integer getGameLevel(){return this.gameLevel;}

    public Integer getScore(){return this.score;}

    public void increaseScore() {
        score += scoreInterval;
    }

    private void reduceHealth(){this.playerHealth -= incrementCounter;}

    public Integer getPlayerHealth(){return this.playerHealth;}

    public void updatePlayerHealth(boolean collisionHappened){
        if(collisionHappened) this.reduceHealth();
    }

    public void resetScoreKeeper(){
        this.score = initialScore;
        this.playerHealth = initialPlayerHealth;
    }
}
