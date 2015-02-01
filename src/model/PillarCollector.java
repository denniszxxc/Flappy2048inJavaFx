/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private ArrayList<Pillar> pillars;
    private long lastCreateInterval;

    PillarCollector() {
        createPillarInterval = 3000;
        lastCreateInterval = 0;
        pillars = new ArrayList<Pillar>();
        createPillar();
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
     * Add a pillar to collector
     */
    public void createPillar() {
        getPillars().add(new Pillar());
    }

    /**
     * delete the oldest pillar
     */
    public void destoryOldestPillar() {
        getPillars().remove(0);
    }

    @Override
    public void update(long updateInterval) {
        lastCreateInterval += updateInterval;

        if (lastCreateInterval >= createPillarInterval) {
            createPillar();
            lastCreateInterval = 0;
        }

        for (Pillar pillar : getPillars()) {
            pillar.update(updateInterval);
        }
    }
}
