package controller;

import model.Bird;
import model.Box;
import model.GraphicalObjCollector;
import model.PillarCollector;
import model.Score;
import view.SoundEffect;

/**
 * Controller of collision between bird and pillar boxes.
 *
 * @author dennisli
 */
class CollisionController {

    /**
     * Constant pixel value of tolerance in box-bird collision.
     */
    private static final double collisionToleranceY = 40.0;

    /**
     * Bird object to use for collision check.
     */
    private Bird bird;
    /**
     * Collection of pillars to use for collision check.
     */
    private PillarCollector pillarCollector;
    /**
     * Height of canvas
     */
    private int canvasHeight;
    /**
     * Score object to update when collision happens.
     */
    private Score score;
    /**
     * SoundEffect obeject to use when collision happens.
     */
    private SoundEffect soundEffect;
    /**
     * State if bird collide when a unmatching box.
     */
    private boolean hitWrongBox;
    /**
     * State if the first colllision between a box and the bird.
     */
    private boolean firstCollision;

    /**
     * No argument constructor.
     */
    CollisionController() {
    }

    /**
     * Constructors initilize a range of obejects.
     *
     * @param goc a collector of graphical obejcts
     * @param canvasHeight Height of canvas
     * @param score the score of the game
     * @param soundEffect the soundeffect of the game.
     */
    CollisionController(GraphicalObjCollector goc, int canvasHeight,
            Score score, SoundEffect soundEffect) {
        bird = goc.getBird();
        pillarCollector = goc.getPillarCollector();
        this.canvasHeight = canvasHeight;
        this.soundEffect = soundEffect;

        this.score = score;
        firstCollision = false;
    }

    /**
     * Check if bird hits the bottom fo the game.
     *
     * @return true when bird hit bottom of game
     */
    public boolean birdHitBottom() {
        return bird.getY() + Bird.BIRD_HEIGHT > canvasHeight;
    }

    /**
     * Check bird-pillar collision and update bird.
     */
    public void birdPillarCollisonCheck() {
        if (birdInsidetPillar()) {
            if (firstCollision) {
                firstCollision = false;

                birdBoxFirstCollision();
            } else {
                bird.enterBoxGap(bird.getY());
            }
        } else {
            firstCollision = true;
            bird.setInsideBoxGap(false);
        }
    }

    /**
     * Check if hitting correct box and update hitWrongBox.
     */
    private void birdBoxFirstCollision() {
        Box highBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                + collisionToleranceY);
        Box lowBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                + Bird.BIRD_HEIGHT - collisionToleranceY);

        if (highBox != lowBox) {
            hitWrongBox = true;
        } else if (highBox.getBoxValue() != bird.getBirdPowerValue()) {
            hitWrongBox = true;
        } else {
            hitCorrectBox(highBox);
        }
    }

    /**
     * Update score, bird, box and pillarCollector when hitting the correct box.
     *
     * @param highBox the correct box the bird collide with
     */
    private void hitCorrectBox(Box highBox) {
        bird.setBirdPowerValue(bird.getBirdPowerValue() + 1);
        bird.enterBoxGap(highBox.getY());

        pillarCollector.setNewPillarBoxMinimunValue(bird.getBirdPowerValue());
        score.setCurrentScore(score.getCurrentScore() + 1);

        soundEffect.playHitCorrectBoxSound();
        highBox.setBoxValue(-1);
    }

    /**
     * Check if any parts of the bird is inside a pillar
     *
     * @return true when bird is inside a pillar
     */
    public boolean birdInsidetPillar() {
        double leftmostPillarPositionX = pillarCollector.getLeftmostPillar().getX();
        double birdRightEdgeX = bird.getX() + Bird.BIRD_WiDTH;
        return birdRightEdgeX > leftmostPillarPositionX
                && bird.getX() < leftmostPillarPositionX + Box.BOX_DIMENTION;
    }

    /**
     * @return the hitWrongBox
     */
    public boolean isHitWrongBox() {
        return hitWrongBox;
    }
}
