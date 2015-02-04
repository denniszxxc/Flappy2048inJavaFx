/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.concurrent.TimeUnit;
import javafx.scene.layout.Pane;
import model.Score;
import view.GameBoard;
import view.SoundEffect;

/**
 *
 * @author dennisli
 */
public class GameEngine {

    public enum GameStatus {

        GAMESTART, GAMEPLAY, GAMEEND
    };

    public final int REFRESH_INTERVAL = 25;
    private long lastUpdateTime;
    private long currentUpdateTime;

    private Score score;
    private SoundEffect soundEffect;
    private GameBoard gameboard;
    private Pane pane;
    private final StartHandler startHandler;
    private final JumpHandler jumpHandler;
    private CollisionController collisionController;
    
    private GameStatus gameStatus;

    public GameEngine() {
        score = new Score();
        soundEffect = new SoundEffect();
        gameboard = new GameBoard(score);
        lastUpdateTime = 0;
        gameStatus = GameStatus.GAMESTART;
        startHandler = new StartHandler(this);
        jumpHandler = new JumpHandler(this);
        
        pane = gameboard.startScreen(startHandler);
    }

    /**
     * @return the lastUpdateTime
     */
    public long getLastUpdate() {
        return lastUpdateTime;
    }

    /**
     * @param lastUpdate the lastUpdateTime to set
     */
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdateTime = lastUpdate;
    }

    /**
     * @return the gameboard
     */
    public GameBoard getGameboard() {
        return gameboard;
    }

    /**
     * @param gameboard the gameboard to set
     */
    public void setGameboard(GameBoard gameboard) {
        this.gameboard = gameboard;
    }

    /**
     * @return the pane
     */
    public Pane getPane() {
        return pane;
    }

    /**
     * @param pane the pane to set
     */
    public void setScene(Pane pane) {
        this.pane = pane;
    }

    /**
     * @return the soundEffect
     */
    public SoundEffect getSoundEffect() {
        return soundEffect;
    }

    public void endGame() {
        gameStatus = GameStatus.GAMEEND;
        score.updateHighscore();
        pane = gameboard.endScreen(startHandler);
    }

    public void startGame() {
        pane = gameboard.initGamePlay(jumpHandler);
        gameStatus = GameStatus.GAMEPLAY;
        collisionController = new CollisionController(
                gameboard.getGraphicalObjCollector(), gameboard.CANVAS_HEIGHT, 
                score, soundEffect );
        score.setCurrentScore(0);
    }

    /**
     * Update models in the current refresh
     *
     * @param newUpdateTime the system time when methods is called
     */
    public void update(long newUpdateTime) {
        lastUpdateTime = currentUpdateTime;
        currentUpdateTime = newUpdateTime;
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(currentUpdateTime - lastUpdateTime);
        
        if (gameStatus == GameStatus.GAMEPLAY) {
            gameboard.getGraphicalObjCollector().updateAll(durationInMs);
            pane = gameboard.drawGamePlay(pane);

            collisionController.birdPillarCollisonCheck();

            if (collisionController.birdHitBottom()
                    || collisionController.isHitWrongBox()) {
                soundEffect.playHitWallSound();
                endGame();
            }

        }

    }

}
