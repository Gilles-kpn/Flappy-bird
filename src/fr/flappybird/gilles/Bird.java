package fr.flappybird.gilles;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Bird {
	private int birdx,birdy, position,birdwidth,birdheight;
	private boolean jump;
	private Image bird;
	private ImageIcon birdico ;
	
	
	public Bird() {
		birdico = new ImageIcon(getClass().getResource("/images/yellowbird-midflap.png"));
		bird =birdico.getImage();
		birdx= 2;
		birdy = 288;
		birdwidth = 34;
		birdheight = 24;
		
	}


	public int getBirdx() {
		return birdx;
	}


	public void setBirdx(int birdx) {
		this.birdx = birdx;
	}


	public int getBirdy() {
		return birdy;
	}


	public void setBirdy(int birdy) {
		this.birdy = birdy;
	}


	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}

	public int getBirdwidth() {
		return birdwidth;
	}



	public int getBirdheight() {
		return birdheight;
	}

	public boolean isJump() {
		return jump;
	}


	public void setJump(boolean jump) {
		this.jump = jump;
	}


	public Image getBird() {
		return bird;
	}
	public void setBird(String s) {
		this.birdico =new ImageIcon(getClass().getResource("/images/"+s));
		this.bird =this.birdico.getImage();
	}
	//p
	
	

}
