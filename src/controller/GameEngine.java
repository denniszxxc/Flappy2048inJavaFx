package controller;

import java.util.concurrent.TimeUnit;
import javafx.scene.layout.Pane;
import model.Score;
import view.GameBoard;
import view.SoundEffect;

/**
 * Store game board and control between game status.
 * @author dennisli
 */
public class GameEngine {

    /**
     * Game status that represent what status the game is on.
     */
    public enum GameStatus {

        /**
         * Game is on start screen
         */
        GAMESTART,
        /**
         * Game is playing
         */
        GAMEPLAY,
        /**
         * Game is on end Screen
         */
        GAMEEND
    };

    /**
     * Time interval between each update or games in milliseconds.
     */
    public final int REFRESH_INTERVAL = 10;
    /**
     * System nano time when the last time update is called.
     */
    private long lastUpdateTime;
    /**
     * System nano time when the current update is called.
     */
    private long currentUpdateTime;

    /**
     * The score of the game.
     */
    private Score score;
    /**
     * The sound clips of the game.
     */
    private SoundEffect soundEffect;
    /**
     * The board drawing all objects to screen.
     */
    private GameBoard gameboard;
    /**
     * The pane updated by gameboard and access by main Stage.
     */
    private Pane pane;
    /**
     * Handler pressing start and restart button.
     */
    private final StartHandler startHandler;
    /**
     * Handler when mouse click and keypress during gameplay.
     */
    private final JumpHandler jumpHandler;
    /**
     * Handler pressing quit button.
     */
    private final EndHandler endHandler;
    /**
     * Controller update collision between bird and pillar.
     */
    private CollisionController collisionController;

    /**
     * Current game status.
     */
    private GameStatus gameStatus;

    /**
     * No arguments construcor
     */
    public GameEngine() {
        score = new Score();
        soundEffect = new SoundEffect();
        gameboard = new GameBoard(score);
        lastUpdateTime = 0;
        gameStatus = GameStatus.GAMESTART;
        startHandler = new StartHandler(this);
        jumpHandler = new JumpHandler(this);
        endHandler = new EndHandler(this);

        pane = gameboard.startScreen(startHandler);
    }

    /**
     * @return the gameboard
     */
    public GameBoard getGameboard() {
        return gameboard;
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

    /**
     * @return the soundEffect
     */
    public SoundEffect getSoundEffect() {
        return soundEffect;
    }

    /**
     * Update pane and score when game ends.
     */
    public void endGame() {
        soundEffect.playHitWallSound();
        gameStatus = GameStatus.GAMEEND;
        score.updateHighscore();
        pane = gameboard.endScreen(startHandler, endHandler);
    }

    /**
     * Initialize pane, score and collision controller when game start.
     */
    public void startGame() {
        pane = gameboard.initGamePlay(jumpHandler);
        gameStatus = GameStatus.GAMEPLAY;
        collisionController = new CollisionController(
                gameboard.getGraphicalObjCollector(), gameboard.CANVAS_HEIGHT,
                score, soundEffect);
        score.setCurrentScore(0);
    }

    /**
     * Update models and pane when refresh
     *
     * @param newUpdateTime the system time when methods is called
     */
    public void update(long newUpdateTime) {
        lastUpdateTime = currentUpdateTime;
        currentUpdateTime = newUpdateTime;
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(currentUpdateTime - lastUpdateTime);

        if (gameStatus == GameStatus.GAMEPLAY) {
            gameboard.getGraphicalObjCollector().updateAll(durationInMs);
            pane = gameboard.drawGamePlay(pane);

            collisionController.birdPillarCollisonCheck();

            if (collisionController.birdHitBottom()
                    || collisionController.isHitWrongBox()) {
                endGame();
            }

        }

    }

}
