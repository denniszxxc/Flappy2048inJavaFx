/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * Pillar in Game is formed by a stack of boxes
 * @author dennisli
 */
class Pillar extends GraphicalObjs{
    private Box[] boxes;
    
    /**
     * Constructing a new pillar
     */
    Pillar(){
        
    }
    
    /**
     * Constructing a new pillar with birds score as reference to box value 
    * @param birdValue 
     */
    Pillar(int birdValue){
        
    }

    @Override
    public void update(long updateInterval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
