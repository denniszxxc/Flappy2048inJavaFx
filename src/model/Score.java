/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.LinkedList;

/**
 * Store and manipulate the game's current score and last 3 high score
 *
 * @author dennisli
 */
public class Score {

    private int currentScore;
    private LinkedList<Integer> highScores;

    public Score() {
        currentScore = 0;
        highScores = new LinkedList<Integer>();
        highScores.add(0);
        highScores.add(0);
        highScores.add(0);
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
     * @return the highScores
     */
    public LinkedList<Integer> getHighScores() {
        return highScores;
    }

    /**
     * Insert currentScore into a sorted highScores Lists
     */
    public void updateHighscore() {
        
        for(int i = 0; i < highScores.size(); i++){
            if( currentScore > highScores.get(i)){
               highScores.add(i, currentScore);
               break;
            }
        }
        
        if(highScores.size() >3){
            highScores.remove(3);
        }
    }

    public String getHighScore(int i) {
        return "" + highScores.get(i);
    }
}
