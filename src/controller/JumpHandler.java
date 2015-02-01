/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author dennisli
 */
class JumpHandler implements EventHandler<Event>  {

    private GameEngine gameEngine;
    public JumpHandler(){
        
    }
    
    public JumpHandler(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }
    
    @Override
    public void handle(Event event) {
        gameEngine.getGameboard().getGraphicalObjCollector().getBird().jump();
      
    }
    
}
