/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Bird is the main object player control and play with
 * 
 * @author dennisli
 */
public class Bird {
    /**
     * The value of the bird, eg. 2,4,8...
     */
    private int birdValue;
    
    /**
     * state the bird is jumping
     */
    private boolean jumping;
    
    /**
     * @return the birdValue
     */
    public int getBirdValue() {
        return birdValue;
    }

    /**
     * @param birdValue the birdValue to set
     */
    public void setBirdValue(int birdValue) {
        this.birdValue = birdValue;
    }

    /**
     * @return the jumping
     */
    public boolean isJumping() {
        return jumping;
    }

    /**
     * @param jumping the jumping to set
     */
    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     * Start the bird's jump movement 
     */
    public void jump(){
        
    }
    
    /**
     * handle when bird collide with game boundary
     */
    public void collideWithBoundary(){
        
    }
    
    /**
     * handel when bird enter pillar(at the gap between of 2 boxes)
     */
    public void enterBoxGap(){
        
    }
    
}
