package controller;

import javafx.event.EventHandler;
import javafx.scene.input.InputEvent;

/**
 * Handler when Jump is trigger
 * 
 * @author dennisli
 */
class JumpHandler implements EventHandler<InputEvent> {

    /**
     * The gameEngine to use.
     */
    private GameEngine gameEngine;

    /**
     * Empty No argument constructor.
     */
    public JumpHandler() {

    }

    /**
     * Constructor initializing gameEngine.
     * @param gameEngine 
     */
    public JumpHandler(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    /**
     * Update bird and play sound When jump event happens.
     * @param event 
     */
    @Override
    public void handle(InputEvent event) {
        gameEngine.getGameboard().getGraphicalObjCollector().getBird().jump();
        gameEngine.getSoundEffect().playJumpSound();
    }

}
