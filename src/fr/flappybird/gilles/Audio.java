package fr.flappybird.gilles;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Audio {
	private Clip clip;
	public  Audio(String s) {
		try {
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource("/audio/sfx_"+s+".wav"));
			clip =AudioSystem.getClip();
			clip.open(audio);
		}catch(Exception e) {
			
			
		}
		
	}
	public Clip getClip() {
		return this.clip;
	}
	public void play() {
		this.clip.start();
	}
	public void stop() {
		this.clip.stop();
	}
	public static void playSound(String son) {
		Audio s = new Audio(son);
		s.play();
	}
}
