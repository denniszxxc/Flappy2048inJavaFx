package model;

/**
 * Bird is the main object player control and play with.
 *
 * @author dennisli
 */
public class Bird extends GraphicalObjs {

    /**
     * The width of bird.
     */
    public static final double BIRD_WiDTH = 100;
    /**
     * The Height of bird.
     */
    public static final double BIRD_HEIGHT = 100;
    /**
     * The initial X position of the bird on screen.
     */
    private static final double BIRD_INIT_X = 80;
    /**
     * * The initial Y position of the bird on screen.
     */
    private static final double BIRD_INIT_Y = 200;
    /**
     * * The initial X Velocity of the bird on screen.
     */
    private static final double BIRD_INIT_VELOCITY_X = 0;
    /**
     * The initial Y Velocity of the bird on screen.
     */
    private static final double BIRD_INIT_VELOCITY_Y = 0;
    /**
     * The downward gravity acting on the bird's Y direction.
     */
    private static final double BIRD_GRAVITY = 0.0004;
    /**
     * The upward Y velocity of bird when bird jump.
     */
    private static final double BIRD_JUMP_SPEED = -0.25;

    /**
     * The power value of the bird, 
     * eg. 3 means 2 power 3, The value display'll be 8.
     */
    private int birdPowerValue;

    /**
     * state the bird is jumping
     */
    private boolean jumping;
    
    /**
     * state the bird is inside box gap
     */
    private boolean insideBoxGap;
    
    /**
     * No argument constructor initializing paramenters.
     */
    public Bird() {
        super.setX(BIRD_INIT_X);
        super.setY(BIRD_INIT_Y);
        super.setVelocityX(BIRD_INIT_VELOCITY_X);
        super.setVelocityY(BIRD_INIT_VELOCITY_Y);
        
        birdPowerValue = 1;
        jumping = false;
        insideBoxGap = false;
    }

    /**
     * @return the birdPowerValue
     */
    public int getBirdPowerValue() {
        return birdPowerValue;
    }

    /**
     * @param birdPowerValue the birdPowerValue to set
     */
    public void setBirdPowerValue(int birdPowerValue) {
        this.birdPowerValue = birdPowerValue;
    }

    /**
     * @param insideBoxGap the insideBoxGap to set
     */
    public void setInsideBoxGap(boolean insideBoxGap) {
        this.insideBoxGap = insideBoxGap;
    }
    
    /**
     * Start the bird's jump movement. 
     */
    public void jump() {
        jumping = true;
    }

    /**
     * Handle when bird enter pillar(at the gap between of 2 boxes).
     * Freez the Y position to the box's Y position.
     * 
     * @param boxYCoord of a box 
     */
    public void enterBoxGap(double boxYCoord) {
        setInsideBoxGap(true);
        setY(boxYCoord);
        setVelocityY(0);
    }
    
    /**
     * Update Bird properties at every refresh.
     * 
     * @param updateInterval time interval bewteen refrest in nanoseconds 
     */
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
