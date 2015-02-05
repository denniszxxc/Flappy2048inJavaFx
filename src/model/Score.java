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
    private int highestScore;

    public Score(){
        currentScore = 0;
        highestScore = 0;
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
     * @return the highestScore
     */
    public int getHighestScore() {
        return highestScore;
    }
    
    /**
     * Insert currentScore into a sorted highestScore Lists
     */
    public void updateHighscore(){
        if(currentScore > highestScore ){
            highestScore =  currentScore ;
        }
    }
}
