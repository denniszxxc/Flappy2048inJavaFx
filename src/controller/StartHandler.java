/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author dennisli
 */
class StartHandler implements EventHandler<ActionEvent> {

    GameEngine gameEngine;

    public StartHandler() {

    }

    public StartHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void handle(ActionEvent event) {
        gameEngine.startGame();
    }

}
