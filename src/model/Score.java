/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Store and manipulate the game's current score and last 3 high score
 *
 * @author dennisli
 */
public class Score {

    private int currentScore;
    private int[] highScore;

    /**
     * @return the currentScore
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * @param currentScore the currentScore to set
     */
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * @return the highScore
     */
    public int[] getHighScore() {
        return highScore;
    }

    /**
     * @param highScore the highScore to set
     */
    public void setHighScore(int[] highScore) {
        this.highScore = highScore;
    }
}
