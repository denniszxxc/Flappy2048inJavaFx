package model;

/**
 * Collector of all moving objects shown on screen
 *
 * @author dennisli
 */
public class GraphicalObjCollector {

    /**
     * The bird on screen.
     */
    private Bird bird;
    /**
     * A collector of pillars.
     */
    private PillarCollector pillarCollector;

    /**
     * No argument constructor initialize bird and pillar collector.
     */
    public GraphicalObjCollector() {
        bird = new Bird();
        pillarCollector = new PillarCollector();
    }

    /**
     * @return the bird
     */
    public Bird getBird() {
        return bird;
    }

    /**
     * @return the pillarCollector
     */
    public PillarCollector getPillarCollector() {
        return pillarCollector;
    }

    /**
     * Update all graphical object's properties using the time interval between
     * updates.
     *
     * @param updateInterval the time interval in milliseconds
     */
    public void updateAll(long updateInterval) {
        getBird().update(updateInterval);
        getPillarCollector().update(updateInterval);
    }

}
