/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 * Store position and values of graphical Objects shown on screen
 * 
 * @author dennisli
 */
public class GraphicalObjCollector {

    private Bird bird;
    private Background background;
    private PillarCollector pillars;
    
    public GraphicalObjCollector(){
        bird = new Bird();
        background = new Background();
        pillars = new PillarCollector();
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
     * @return the pillars
     */
    public PillarCollector getPillars() {
        return pillars;
    }

    /**
     * @param pillars the pillars to set
     */
    public void setPillars(PillarCollector pillars) {
        this.pillars = pillars;
    }

    /**
     * Update all graphically object's properties
     *
     * @param updateInterval the time interval to affect update
     */
    public void updateAll(long updateInterval) {
        getBird().update(updateInterval);
        // getBackground().update(updateInterval);
        // getPillars().update(updateInterval);
    }

}
