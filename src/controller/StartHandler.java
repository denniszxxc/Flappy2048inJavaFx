package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handler for game start
 * @author dennisli
 */
class StartHandler implements EventHandler<ActionEvent> {

    /**
     * The gameEngine to use.
     */
    private GameEngine gameEngine;

    /** 
     * Empty no argument constructor.
     */
    public StartHandler() {

    }

    /**
     * Constructor initializing gameEngine.
     * @param gameEngine 
     */
    public StartHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Handle Start game.
     * @param event 
     */
    @Override
    public void handle(ActionEvent event) {
        gameEngine.startGame();
    }

}
