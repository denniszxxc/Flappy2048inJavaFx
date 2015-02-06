package model;

/**
 * Abstracts of graphical objects will be displayed to user, having x,y property
 * and velocity. Properties will be change by update method.
 *
 * @author dennisli
 */
public abstract class GraphicalObjs {

    private double x;
    private double y;
    private double velocityX;
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
