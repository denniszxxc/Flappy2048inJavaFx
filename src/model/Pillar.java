/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Pillar in Game is formed by a stack of boxes
 *
 * @author dennisli
 */
public class Pillar extends GraphicalObjs {

    public static double PILLAR_WiDTH = 100;
    public static double PILLAR_HEIGHT = 600;
    private static double PILLAR_INIT_X = 800;
    private static double PILLAR_INIT_Y = 0;
    private static double PILLAR_INIT_VELOCITY_X = -0.15;
    private static double PILLAR_INIT_VELOCITY_Y = 0;
    private final int BOX_NUMBER = 6;

    private Box[] boxes;

    /**
     * Constructing a new pillar
     */
    Pillar() {
        super.setX(PILLAR_INIT_X);
        super.setY(PILLAR_INIT_Y);
        super.setVelocityX(PILLAR_INIT_VELOCITY_X);
        super.setVelocityY(PILLAR_INIT_VELOCITY_Y);

        boxes = new Box[BOX_NUMBER];
        int[] valList = generateBoxValList();
        for (int i = 0; i < BOX_NUMBER; i++) {
            boxes[i] = new Box(valList[i]);
            boxes[i].setX(PILLAR_INIT_X);
            boxes[i].setY(Box.BOX_DIMENTION * i);
            boxes[i].setVelocityX(PILLAR_INIT_VELOCITY_X);
            boxes[i].setVelocityY(PILLAR_INIT_VELOCITY_Y);
        }
    }

    /**
     * Constructing a new pillar with birds score as reference to box value
     *
     * @param birdValue
     */
    Pillar(int birdValue) {

    }

    /**
     * @return the boxes
     */
    public Box[] getBoxes() {
        return boxes;
    }

    /**
     * @param boxes the boxes to set
     */
    public void setBoxes(Box[] boxes) {
        this.boxes = boxes;
    }

    /**
     * Generate A random order List of (2,4,8,16,32,64)
     *
     * @return random order List of (2,4,8,16,32,64)
     */
    private int[] generateBoxValList() {
        int[] valList = new int[BOX_NUMBER];
        for (int i = 0; i < BOX_NUMBER; i++) {
            valList[i] = (int) Math.pow(2.0, i + 1.0);
        }

        for (int i = 0; i < BOX_NUMBER; i++) {
            int target = (int) (Math.random() * 5);
            int source = (int) (Math.random() * 5);
            int temp = valList[source];
            valList[source] = valList[target];
            valList[target] = temp;
        }

        return valList;
    }

    /**
     * retrun the box in pillar using the y position (counting from top at 0)
     * 
     * @param yPosition the y posistion in pixel 
     * @return Box in the pillar on the yposistion
     */
    public Box getBox(double yPosition){
        if(yPosition >= 0){
            return boxes[ (int) Math.floor(yPosition / Box.BOX_DIMENTION)];
        } else {
            return null;
        }
    }
    
    @Override
    public void update(long updateInterval) {
        super.setX(getX() + getVelocityX() * updateInterval);

        for (Box box : getBoxes()) {
            box.update(updateInterval);
        }
    }

}
