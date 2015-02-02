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

/**
 *
 * @author dennisli
 */
class CollisionController {

    private static final double collisionToleranceX = -5.5;
    private static final double collisionToleranceY = 10.0;

    private Bird bird;
    private PillarCollector pillarCollector;
    private int canvasHeight;
    private boolean hitWrongBox;

    CollisionController() {
    }

    CollisionController(GraphicalObjCollector goc, int canvasHeight) {
        bird = goc.getBird();
        pillarCollector = goc.getPillarCollector();
        this.canvasHeight = canvasHeight;
        hitWrongBox = false;
    }

    public boolean birdHitBottom() {
        return bird.getY() + Bird.BIRD_HEIGHT > canvasHeight;
    }

    public void birdPillarCollisonCheck() {
        if (birdRightHitPillar()) {
            Box highBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                    + collisionToleranceY);
            Box lowBox = pillarCollector.getLeftmostPillar().getBox(bird.getY()
                    + Bird.BIRD_HEIGHT - collisionToleranceY);
            if (highBox != lowBox) {
                hitWrongBox = true;
            } else if(highBox.getBoxValue() != bird.getBirdValue()) { 
                hitWrongBox = true;
            } else {
                bird.setBirdValue(bird.getBirdValue() * bird.getBirdValue());
                //score
                bird.enterBoxGap(highBox.getY());
            }
        } else if(birdInsidetPillar()) {
            bird.enterBoxGap(bird.getY());
        }
    }

    public boolean birdRightHitPillar() {
        double leftmostPillarPositionX = pillarCollector.getLeftmostPillar().getX();
        double BirdPillarDistance = leftmostPillarPositionX - 
                (bird.getX() + Bird.BIRD_WiDTH);
        
        return BirdPillarDistance < 0 && BirdPillarDistance > collisionToleranceX;
    }

    public boolean birdInsidetPillar() {
        double leftmostPillarPositionX = pillarCollector.getLeftmostPillar().getX();
        double birdRightEdgeX = bird.getX() + Bird.BIRD_WiDTH;
        return birdRightEdgeX > leftmostPillarPositionX
                && leftmostPillarPositionX < leftmostPillarPositionX + Box.BOX_DIMENTION;
    }
    /**
     * @return the hitWrongBox
     */
    public boolean isHitWrongBox() {
        return hitWrongBox;
    }
}
