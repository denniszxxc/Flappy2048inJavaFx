package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Handler for quit game button
 *
 * @author dennisli
 */
class EndHandler implements EventHandler<ActionEvent> {

    /**
     * GameEngine to use.
     */
    private GameEngine gameEngine;

    /**
     * No argument constructor.
     */
    public EndHandler() {

    }

    /**
     * Constructor initializing gameEngine
     *
     * @param gameEngine
     */
    public EndHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Clear gameEngine's pane event happen.
     *
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        gameEngine.setScene(null);
    }
}
