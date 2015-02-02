/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Store and manipulate the game's current score and last 3 high score
 *
 * @author dennisli
 */
public class Score {

    private int currentScore;
    private ArrayList<Integer> highScore;

    public Score(){
        currentScore = 0;
        highScore = new ArrayList<Integer>();
    }
    
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
    public ArrayList<Integer> getHighScore() {
        return highScore;
    }
    
    /**
     * Insert currentScore into a sorted highScore Lists
     */
    public void updateHighscore(){
        
        highScore.add(currentScore);
        Collections.sort(highScore);
    }
}
