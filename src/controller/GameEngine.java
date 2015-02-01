/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import view.GameBoard;

/**
 *
 * @author dennisli
 */
public class GameEngine {
    public enum GameStatus{
        GAMESTART, GAMEPLAY, GAMEEND
    };
    
    public final int REFRESH_INTERVAL = 35;
    private long lastUpdateTime;
    private long currentUpdateTime;
    
    private GameBoard gameboard;
    private Pane pane;
    private StartHandler startHandler;
    private JumpHandler jumpHandler;
    
    private GameStatus gameStatus;
    
    public GameEngine(){
        gameboard = new GameBoard();
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
   
    public void startGame(){
        pane = new StackPane();
        gameStatus = GameStatus.GAMEPLAY;
        
    }
    
    /** 
     * Update models in the current refresh 
     * 
     * @param newUpdateTime the system time when methods is called 
     */
    public void update(long newUpdateTime){
        lastUpdateTime = currentUpdateTime;
        currentUpdateTime = newUpdateTime;
        
        
        
        if(gameStatus == GameStatus.GAMEPLAY){           
            gameboard.getGraphicalObjCollector().updateAll(currentUpdateTime - lastUpdateTime);
            pane = gameboard.drawGamePlay(pane , jumpHandler);
            
        } 

    }
       
}
