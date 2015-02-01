/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author dennisli
 */
public class Box extends GraphicalObjs {
    public static final int BOX_DIMENTION = 100;
    /**
     * the Value on a box
     */
    private int boxValue;
    /**
     * the font size of text on box
     */
    private int fontSize;

    Box() {

    }

    Box(int boxValue) {
        this.boxValue = boxValue;
    }

    /**
     * @return the boxValue
     */
    public int getBoxValue() {
        return boxValue;
    }

    /**
     * @param boxValue the boxValue to set
     */
    public void setBoxValue(int boxValue) {
        this.boxValue = boxValue;
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
