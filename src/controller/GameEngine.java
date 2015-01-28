/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.GameBoard;

/**
 *
 * @author dennisli
 */
public class GameEngine {
    private double lastUpdate;
    private GameBoard gameboard;
    /**
     * @return the lastUpdate
     */
    public double getLastUpdate() {
        return lastUpdate;
    }

    /**
     * @param lastUpdate the lastUpdate to set
     */
    public void setLastUpdate(double lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    /** 
     * Update models in the current refresh 
     * 
     * @param updateInterval the time between last update and this update start 
     */
    public void update(double updateInterval){
        
    }
    
}
