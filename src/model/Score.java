package model;

import java.util.LinkedList;

/**
 * Store and manipulate the game's current score and last 3 high score
 *
 * @author dennisli
 */
public class Score {

    /**
     * current score
     */
    private int currentScore;
    /**
     * list of 3 high score
     */
    private LinkedList<Integer> highScores;

    /**
     * No argument contructor
     */
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

    /**
     * Return the highscore of index i.
     * @param i the index in highScore list
     * @return a integer of score
     */
    public String getHighScore(int i) {
        return "" + highScores.get(i);
    }
}
