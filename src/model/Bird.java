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
public class Bird extends GraphicalObjs {

    public static final double BIRD_WiDTH = 100;
    public static final double BIRD_HEIGHT = 100;
    private static final double BIRD_INIT_X = 80;
    private static final double BIRD_INIT_Y = 200;
    private static final double BIRD_INIT_VELOCITY_X = 0;
    private static final double BIRD_INIT_VELOCITY_Y = 0;
    private static final double BIRD_GRAVITY = 0.0002;
    private static final double BIRD_JUMP_SPEED = -0.15;

    /**
     * The value of the bird, eg. 2,4,8...
     */
    private int birdValue;

    /**
     * state the bird is jumping
     */
    private boolean jumping;
    
    /**
     * state the bird is inside box gap
     */
    private boolean insideBoxGap;
    
    public Bird() {
        super.setX(BIRD_INIT_X);
        super.setY(BIRD_INIT_Y);
        super.setVelocityX(BIRD_INIT_VELOCITY_X);
        super.setVelocityY(BIRD_INIT_VELOCITY_Y);
        
        birdValue = 2;
        jumping = false;
        insideBoxGap = false;
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
     * @param insideBoxGap the insideBoxGap to set
     */
    public void setInsideBoxGap(boolean insideBoxGap) {
        this.insideBoxGap = insideBoxGap;
    }
    
    /**
     * Start the bird's jump movement
     */
    public void jump() {
        jumping = true;
        System.out.println("Jump!");
    }

    /**
     * handel when bird enter pillar(at the gap between of 2 boxes)
     * @param boxYCoord
     */
    public void enterBoxGap(double boxYCoord) {
        setInsideBoxGap(true);
        setY(boxYCoord);
        setVelocityY(0);
    }
    
    @Override
    public void update(long updateInterval) {
        if (jumping && !insideBoxGap) {
            super.setVelocityY(BIRD_JUMP_SPEED);
            jumping = false;
        }
        if(!insideBoxGap){
            super.setVelocityY(super.getVelocityY() + BIRD_GRAVITY * updateInterval);
        }
        super.setY(getY() + getVelocityY() * updateInterval);

    }

 }
