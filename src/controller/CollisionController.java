/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Bird;
import model.Box;
import model.GraphicalObjCollector;
import model.PillarCollector;
import model.Score;
import view.SoundEffect;

/**
 *
 * @author dennisli
 */
class CollisionController {

    private static final double collisionToleranceY = 40.0;

    private Bird bird;
    private PillarCollector pillarCollector;
    private int canvasHeight;
    private boolean hitWrongBox;
    private Score score;
    private SoundEffect soundEffect;
    private boolean firstCollision;

    CollisionController() {
    }

    CollisionController(GraphicalObjCollector goc, int canvasHeight, 
            Score score, SoundEffect soundEffect) {
        bird = goc.getBird();
        pillarCollector = goc.getPillarCollector();
        this.canvasHeight = canvasHeight;
        hitWrongBox = false;
        this.score = score;
        this.soundEffect = soundEffect;
        
        firstCollision = false;
    }

    public boolean birdHitBottom() {
        return bird.getY() + Bird.BIRD_HEIGHT > canvasHeight;
    }

    public void birdPillarCollisonCheck() {
        if(birdInsidetPillar()) {
            if (firstCollision) {
                firstCollision = false;
                
                Box highBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                        + collisionToleranceY);
                Box lowBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                        + Bird.BIRD_HEIGHT - collisionToleranceY);

                if (highBox != lowBox) {
                    hitWrongBox = true;
                } else if (highBox.getBoxValue() != bird.getBirdValue()) {
                    hitWrongBox = true;
                } else {
                    bird.setBirdValue(bird.getBirdValue() * 2);
                    pillarCollector.setNewPillarBoxMinimunValue(bird.getBirdValue());
                    score.setCurrentScore(score.getCurrentScore() + bird.getBirdValue());
                    bird.enterBoxGap(highBox.getY());
                    soundEffect.playHitCorrectBoxSound();
                }
            } else {
                bird.enterBoxGap(bird.getY());
            }
        } else {
            firstCollision = true;
            bird.setInsideBoxGap(false);
        }
    }

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
