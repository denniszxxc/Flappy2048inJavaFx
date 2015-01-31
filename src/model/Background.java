/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;

/**
 * Background objects' information
 * @author dennisli
 */
public class Background extends GraphicalObjs{
    private Image cloud;
    private Image sky;

    /**
     * @return the cloud
     */
    public Image getCloud() {
        return cloud;
    }

    /**
     * @param cloud the cloud to set
     */
    public void setCloud(Image cloud) {
        this.cloud = cloud;
    }

    /**
     * @return the sky
     */
    public Image getSky() {
        return sky;
    }

    /**
     * @param sky the sky to set
     */
    public void setSky(Image sky) {
        this.sky = sky;
    }

    @Override
    public void update(long updateInterval) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
