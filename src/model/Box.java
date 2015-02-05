/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dennisli
 */
public class Box extends GraphicalObjs {

    public static final int BOX_DIMENTION = 100;
    /**
     * the Power Value on a box. 
     * Eg val 3 mean box display 8
     */
    private int boxPowerValue;
    /**
     * the font size of text on box
     */
    private int fontSize;

    Box() {

    }

    Box(int boxValue) {
        this.boxPowerValue = boxValue;
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
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public void update(long updateInterval) {

        setX(getX() + getVelocityX() * updateInterval);
    }
}
