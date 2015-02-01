/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.TimeUnit;

/**
 * Bird is the main object player control and play with
 * 
 * @author dennisli
 */
public class Bird extends GraphicalObjs{
    private static int BIRD_INIT_X = 80;
    private static int BIRD_INIT_Y = 200;
    private static double BIRD_INIT_VELOCITY_X = 0;
    private static double BIRD_INIT_VELOCITY_Y = 0;
    private static double BIRD_GRAVITY = 0.05;
    private static double BIRD_JUMP_SPEED = 5.0;
    
    /**
     * The value of the bird, eg. 2,4,8...
     */
    private int birdValue;
    
    /**
     * state the bird is jumping
     */
    private boolean jumping;
    
    public Bird(){
        super.setX(BIRD_INIT_X); 
        super.setY(BIRD_INIT_Y);
        super.setVelocityX(BIRD_INIT_VELOCITY_X);
        super.setVelocityY(BIRD_INIT_VELOCITY_Y);
        
    }
    
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
        jumping = true;
        System.out.println("Jump!");
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

    @Override
    public void update(long updateInterval) {
        if(jumping){
            super.setVelocityY(BIRD_JUMP_SPEED);
            jumping = false;
        }
        long durationInMs = TimeUnit.NANOSECONDS.toMillis(updateInterval);

        super.setVelocityY(super.getVelocityY() - BIRD_GRAVITY);
           
        super.setY( getY() + (int) Math.round(getVelocityY()* durationInMs));
        
        System.out.println(getY());
    }
    
}
