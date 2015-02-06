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
        jumpSoundEffect = new AudioClip(getClass().getResource("jump.wav").toString());
        hitWallSoundEffect = new AudioClip(getClass().getResource("hit.wav").toString());
        hitCorrectBoxSoundEffect = new AudioClip(getClass().getResource("bingo.wav").toString());
        
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
