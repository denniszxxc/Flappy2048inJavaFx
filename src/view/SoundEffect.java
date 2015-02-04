/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.media.AudioClip;

/**
 *
 * @author dennisli
 */
public class SoundEffect {

    private AudioClip jumpSoundEffect;
    private AudioClip hitWallSoundEffect;
    private AudioClip hitCorrectBoxSoundEffect;
    
    public SoundEffect(){
        jumpSoundEffect = new AudioClip(getClass().getResource("/soundEffect/jump.wav").toString());
        hitWallSoundEffect = new AudioClip(getClass().getResource("/soundEffect/hit.wav").toString());
        hitCorrectBoxSoundEffect = new AudioClip(getClass().getResource("/soundEffect/bingo.wav").toString());
        
        jumpSoundEffect.setCycleCount(1);
        hitWallSoundEffect.setCycleCount(1);
        hitCorrectBoxSoundEffect.setCycleCount(1);
    }
    
    public void playJumpSound() {
        if (!jumpSoundEffect.isPlaying()) {
            jumpSoundEffect.play();
        }
    }
    
    public void playHitWallSound(){
        if (!hitWallSoundEffect.isPlaying()) {
            hitWallSoundEffect.play();
        }
    }
    
    public void playHitCorrectBoxSound() {
        if (!hitCorrectBoxSoundEffect.isPlaying()) {
            hitCorrectBoxSoundEffect.play();
        }
    }
}
