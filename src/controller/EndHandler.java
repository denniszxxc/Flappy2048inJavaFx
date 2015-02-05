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
class EndHandler implements EventHandler<ActionEvent> {

    private GameEngine gameEngine;

    public EndHandler() {

    }

    public EndHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void handle(ActionEvent event) {
        gameEngine.setScene(null);
    }
}
