package view;

import javafx.scene.media.AudioClip;

/**
 * Sound effects of the game
 * @author dennisli
 */
public class SoundEffect {
    /**
     * Jump sound Effect
     */
    private AudioClip jumpSoundEffect;
    /**
     * Hit wall sound Effect
     */
    private AudioClip hitWallSoundEffect;
    /**
     * hit correct box sound Effect
     */
    private AudioClip hitCorrectBoxSoundEffect;
    
    /**
     * no argument constructor, reading all soundclips
     */
    public SoundEffect(){
        jumpSoundEffect = new AudioClip(getClass().getResource("jump.wav").toString());
        hitWallSoundEffect = new AudioClip(getClass().getResource("hit.wav").toString());
        hitCorrectBoxSoundEffect = new AudioClip(getClass().getResource("bingo.wav").toString());
        
        jumpSoundEffect.setCycleCount(1);
        hitWallSoundEffect.setCycleCount(1);
        hitCorrectBoxSoundEffect.setCycleCount(1);
    }
    
    /**
     * play jump sound.
     */
    public void playJumpSound() {
        if (!jumpSoundEffect.isPlaying()) {
            jumpSoundEffect.play();
        }
    }
    
    /**
     * play hit wall sound.
     */
    public void playHitWallSound(){
        if (!hitWallSoundEffect.isPlaying()) {
            hitWallSoundEffect.play();
        }
    }
    /**
     * play hit correct box sound.
     */
    public void playHitCorrectBoxSound() {
        if (!hitCorrectBoxSoundEffect.isPlaying()) {
            hitCorrectBoxSoundEffect.play();
        }
    }
}
