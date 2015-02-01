/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashSet;
import java.util.Set;
import javafx.scene.image.Image;

/**
 * Background objects' information
 *
 * @author dennisli
 */
public class Background extends GraphicalObjs {

    private final double BG_INIT_X = 0;
    private final double BG_INIT_Y = 0;
    private final double BG_VELOCITY_X = 0.005;
    private final double BG_VELOCITY_Y = 0.0;

    private Image cloud;
    private Image sky;

    public Background() {
        super.setX(BG_INIT_X);
        super.setY(BG_INIT_Y);
        super.setVelocityX(BG_VELOCITY_X);
        super.setVelocityY(BG_VELOCITY_Y);
    }

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
