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
class Box extends GraphicalObjs{
    /**
     * the Value on a box
     */
   private int boxValue;
   /**
    * the font size of text on box
    */
   private int fontSize;

   
   Box(){
       
   } 
   
   Box(int boxValue){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
