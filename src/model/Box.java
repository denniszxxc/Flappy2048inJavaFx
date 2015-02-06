package model;

import javafx.scene.paint.Color;

/**
 *
 * @author dennisli
 */
public class Box extends GraphicalObjs {

    /**
     * The Height and Width of a Box in pixel.
     */
    public static final int BOX_DIMENTION = 100;
    /**
     * the Power Value on a box. Eg val 3 mean box display 8 It equals -1 when a
     * virtual invaled box is needed
     */
    private int boxPowerValue;
    /**
     * the font size of text inside a box
     */
    private int fontSize;

    /**
     * no argument constructor
     */
    Box() {

    }

    /**
     * constructor seting boxPowerValue
     */
    Box(int boxPowerValue) {
        this.boxPowerValue = boxPowerValue;
    }

    /**
     * @return the boxPowerValue
     */
    public int getBoxValue() {
        return boxPowerValue;
    }

    /**
     * @param boxValue the boxPowerValue to set
     */
    public void setBoxValue(int boxValue) {
        this.boxPowerValue = boxValue;
    }

    /**
     * Return a integer font size appropriate to the Box's power value.
     *
     * @param boxPowerValue of a box. It should be larger than zero.
     * @return integer font size
     */
    public static int fontSize(int boxPowerValue) {
        switch (boxPowerValue) {
            case 1:
            case 2:
            case 3:
                return 56;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
                return 30;
            default:
                return 42;

        }
    }

    /**
     * Return a Color appropriate to the Box's power value.
     *
     * @param boxPowerValue of a box. It should be larger than 0
     * @return A Color.
     */
    public static Color boxColor(int boxPowerValue) {
        switch (boxPowerValue) {
            case 1:
                return Color.rgb(234, 232, 228);
            case 2:
                return Color.rgb(252, 238, 215);
            case 3:
                return Color.rgb(242, 177, 121);
            case 4:
                return Color.rgb(245, 149, 99);
            case 5:
                return Color.rgb(246, 124, 95);
            case 6:
                return Color.rgb(254, 109, 74);
            case 7:
                return Color.rgb(231, 202, 111);
            case 8:
                return Color.rgb(237, 204, 97);
            case 9:
                return Color.rgb(237, 200, 80);
            case 10:
                return Color.rgb(237, 220, 80);
            case 11:
                return Color.rgb(237, 197, 63);
            default:
                return Color.rgb(60, 58, 50);
        }

    }

    /**
     * Return a Color used for text on the box which is appropriate to the Box's
     * Power value.
     *
     * @param boxPowerValue of a box. It should be larger than 0
     * @return a Color
     */
    public static Color fontColor(int boxPowerValue) {
        switch (boxPowerValue) {
            case 1:
            case 2:
                return Color.rgb(96, 96, 96);
            default:
                return Color.rgb(249, 246, 242);
        }
    }

    /**
     * Upate the box position with respect to the time interval between update.
     *
     * @param updateInterval time in milliseconds.
     */
    @Override
    public void update(long updateInterval) {

        setX(getX() + getVelocityX() * updateInterval);
    }
}
