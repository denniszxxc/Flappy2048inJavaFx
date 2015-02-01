/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Store position and values of graphical Objects shown on screen
 *
 * @author dennisli
 */
public class GraphicalObjCollector {

    private Bird bird;
    private Background background;
    private PillarCollector pillarCollector;

    public GraphicalObjCollector() {
        bird = new Bird();
        background = new Background();
        pillarCollector = new PillarCollector();
    }

    /**
     * @return the bird
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * @param bird the bird to set
     */
    public void setBird(Bird bird) {
        this.bird = bird;
    }

    /**
     * @return the background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * @param background the background to set
     */
    public void setBackground(Background background) {
        this.background = background;
    }

    /**
     * @return the pillarCollector
     */
    public PillarCollector getPillarCollector() {
        return pillarCollector;
    }

    /**
     * @param pillarCollector the pillarCollector to set
     */
    public void setPillarCollector(PillarCollector pillarCollector) {
        this.pillarCollector = pillarCollector;
    }

    /**
     * Update all graphically object's properties
     *
     * @param updateInterval the time interval to affect update
     */
    public void updateAll(long updateInterval) {
        getBird().update(updateInterval);
        // getBackground().update(updateInterval);
        getPillarCollector().update(updateInterval);
    }

}
