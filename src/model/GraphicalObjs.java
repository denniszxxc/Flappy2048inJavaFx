package model;

/**
 * Abstracts of a graphical object that will be displayed to user, 
 *
 * @author dennisli
 */
public abstract class GraphicalObjs {

    /**
     * x position 
     */
    private double x;
    /**
     * y position 
     */
    private double y;
    /**
     * Velocity in X direction
     */
    private double velocityX;
    /**
     * Velocity in Y direction
     */
    private double velocityY;

    /**
     * update object properties based on time
     *
     * @param updateInterval the time used to update object properties
     */
    public abstract void update(long updateInterval);

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the velocityX
     */
    public double getVelocityX() {
        return velocityX;
    }

    /**
     * @param velocityX the velocityX to set
     */
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    /**
     * @return the velocityY
     */
    public double getVelocityY() {
        return velocityY;
    }

    /**
     * @param velocityY the velocityY to set
     */
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
}
