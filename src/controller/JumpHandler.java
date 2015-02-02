/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;

/**
 *
 * @author dennisli
 */
class JumpHandler implements EventHandler<InputEvent> {

    private GameEngine gameEngine;

    public JumpHandler() {

    }

    public JumpHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    @Override
    public void handle(InputEvent event) {
        gameEngine.getGameboard().getGraphicalObjCollector().getBird().jump();
    }

}
