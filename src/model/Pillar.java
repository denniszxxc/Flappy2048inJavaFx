package model;

/**
 * Pillar in Game is formed by a stack of boxes
 *
 * @author dennisli
 */
public class Pillar extends GraphicalObjs {

    /**
     * Pillar's Initial X position
     */
    private static double PILLAR_INIT_X = 800;
    /**
     * Pillar's Initial Y position
     */
    private static double PILLAR_INIT_Y = 0;
    /**
     * Pillar's Initial velocity in X diection
     */
    private static double PILLAR_INIT_VELOCITY_X = -0.15;
    /**
     * Pillar's Initial velocity in Y diection
     */
    private static double PILLAR_INIT_VELOCITY_Y = 0;
    /**
     * Number of boxes in one pillar
     */
    private final int BOX_NUMBER = 6;

    /**
     * list of boxes of the pillar
     */
    private Box[] boxes;

    /**
     * No argument constructor
     */
    Pillar() {
        super.setX(PILLAR_INIT_X);
        super.setY(PILLAR_INIT_Y);
        super.setVelocityX(PILLAR_INIT_VELOCITY_X);
        super.setVelocityY(PILLAR_INIT_VELOCITY_Y);

        boxes = new Box[BOX_NUMBER];
        int[] valList = generateBoxValList(1);
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
     * @param boxMinValue
     */
    Pillar(int boxMinValue){
        super.setX(PILLAR_INIT_X);
        super.setY(PILLAR_INIT_Y);
        super.setVelocityX(PILLAR_INIT_VELOCITY_X);
        super.setVelocityY(PILLAR_INIT_VELOCITY_Y);

        boxes = new Box[BOX_NUMBER];
        int[] valList = generateBoxValList(boxMinValue);
        for (int i = 0; i < BOX_NUMBER; i++) {
            boxes[i] = new Box(valList[i]);
            boxes[i].setX(PILLAR_INIT_X);
            boxes[i].setY(Box.BOX_DIMENTION * i);
            boxes[i].setVelocityX(PILLAR_INIT_VELOCITY_X);
            boxes[i].setVelocityY(PILLAR_INIT_VELOCITY_Y);
        }
    }

    /**
     * @return the boxes
     */
    public Box[] getBoxes() {
        return boxes;
    }

    /**
     * Generate A random order List of (2,4,8,16,32,64)
     *
     * @return random order List of (2,4,8,16,32,64)
     */
    private int[] generateBoxValList(int boxMinValue) {
        int[] valList = new int[BOX_NUMBER];
        for (int i = 0, j = boxMinValue ; i < BOX_NUMBER; i++, j++) {
            valList[i] = j;
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
     * retrun the box in pillar using the a y position (counting from top at 0)
     * 
     * 
     * @param yPosition the y posistion in pixel 
     * @return Box in the pillar on the yposistion. 
     * Return a Box(-1) when y is smaller than -1
     */
    public Box getBox(double yPosition){
        if(yPosition >= 0){
            return boxes[ (int) Math.floor(yPosition / Box.BOX_DIMENTION)];
        } else {
            return new Box(-1);
        }
    }
    
    /**
     * Upate position of all boxes inside pillar
     * 
     * @param updateInterval time between current and last refresh
     */
    @Override
    public void update(long updateInterval) {
        super.setX(getX() + getVelocityX() * updateInterval);

        for (Box box : getBoxes()) {
            box.update(updateInterval);
        }
    }

}
