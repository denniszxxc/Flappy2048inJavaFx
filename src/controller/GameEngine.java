/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import view.GameBoard;

/**
 *
 * @author dennisli
 */
public class GameEngine {
    private long lastUpdateTime;
    private long currentUpdateTime;
    public final int REFRESH_INTERVAL = 35;
    
    private GameBoard gameboard;
    private Pane pane;
    private StartHandler startHandler;
    
    
    public GameEngine(){
        gameboard = new GameBoard();
        lastUpdateTime = 0;
              
        startHandler = new StartHandler(this);
        
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
        pane = gameboard.draw();
    }
    
    /** 
     * Update models in the current refresh 
     * 
     * @param newUpdateTime the system time when methods is called 
     */
    public void update(long newUpdateTime){
        lastUpdateTime = currentUpdateTime;
        currentUpdateTime = newUpdateTime;
        
        //pane = gameboard.draw();

    }
       
}
