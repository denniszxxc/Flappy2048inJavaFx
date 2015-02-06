package model;

import java.util.ArrayList;

/**
 * Collector of Pillars in game
 *
 * @author dennisli
 */
public class PillarCollector extends GraphicalObjs {

    /**
     * interval in MilliSeconds between create 2 pillars.
     */
    private long createPillarInterval;
    /**
     * Time interval of current time and last time creating new pillar.
     */
    private long lastCreateInterval;
    /**
     * Value of 2's Power to create new pillar with box with minimun value.
     */
    private int newPillarBoxMinimunValue;
    /**
     * A collection of pillar
     */
    private ArrayList<Pillar> pillars;

    /** 
     * No argument constructor
     */
    PillarCollector() {
        createPillarInterval = 5000;
        lastCreateInterval = 0;
        pillars = new ArrayList<Pillar>();
        newPillarBoxMinimunValue = 1;
        createPillar(newPillarBoxMinimunValue);
    }

    /**
     * @return the pillars
     */
    public ArrayList<Pillar> getPillars() {
        return pillars;
    }

    /**
     * @param pillars the pillars to set
     */
    public void setPillars(ArrayList<Pillar> pillars) {
        this.pillars = pillars;
    }

    /**
     * @param newPillarBoxMinimunValue the newPillarBoxMinimunValue to set
     */
    public void setNewPillarBoxMinimunValue(int newPillarBoxMinimunValue) {
        this.newPillarBoxMinimunValue = newPillarBoxMinimunValue;
    }
    
    /**
     * Add a pillar to colllector
     * @param newPillarBoxMinimunValue 
     */
    public void createPillar(int newPillarBoxMinimunValue) {
        getPillars().add(new Pillar(newPillarBoxMinimunValue));
    }

    /**
     * delete the oldest pillar
     */
    public void destoryOldestPillar() {
        getPillars().remove(0);
    }

    /**
     * 
     * @return the leftmost pillar, which is also oldest 
     */
    public Pillar getLeftmostPillar(){
        return getPillars().get(0);
    }
    
    
    /**
     * Update pillars inside collector, Create and delete pillar
     * 
     * @param updateInterval 
     */
    @Override
    public void update(long updateInterval) {
        lastCreateInterval += updateInterval;

        if (lastCreateInterval >= createPillarInterval) {
            createPillar(newPillarBoxMinimunValue);
            lastCreateInterval = 0;
        }
        
        if(getLeftmostPillar().getX() < -Box.BOX_DIMENTION){
            destoryOldestPillar();
        }

        for (Pillar pillar : getPillars()) {
            pillar.update(updateInterval);
        }
    }
}
