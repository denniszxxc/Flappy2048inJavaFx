package model;

import java.util.ArrayList;

/**
 * Store, created, delete Pillars in game
 *
 * @author dennisli
 */
public class PillarCollector extends GraphicalObjs {

    /**
     * interval in MilliSeconds between create 2 pillars
     */
    private long createPillarInterval;
    private long lastCreateInterval;
    private int newPillarBoxMinimunValue;
    private ArrayList<Pillar> pillars;

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
     * Add a pillar to col
     * @param newPillarBoxMinimunValuelector
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

    public Pillar getLeftmostPillar(){
        return getPillars().get(0);
    }
    
    
    /**
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
