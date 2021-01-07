package fr.flappybird.gilles;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Obstacle {
	private int positionX,TrouY,trouheight;
	private ImageIcon Hight,Down;
	private Image hightpipe,downpipe;
	private int downpipestart;
	private boolean active;
	
	public Obstacle(int x) {
		this.positionX = x;
		this.TrouY = this.aleatoire(250, 400);
		this.trouheight = this.aleatoire(75, 125);
		this.Hight = new ImageIcon(getClass().getResource("/images/pipe-green.png"));
		this.downpipe =this.Hight.getImage();
		this.Down= new ImageIcon(getClass().getResource("/images/pipe-green2.png"));
		this.hightpipe = this.Down.getImage();
		this.downpipestart = this.TrouY + this.trouheight;
		this.setActive(false);
	}
	
	public int getTrouheight() {
		return trouheight;
	}
	
	private int aleatoire(int min,int max) {
		int n =(int) (min+ (Math.random() * (max-min)));
		return n;
	}


	public int getPositionX() {
		return positionX;
	}
	
	public void setPositionX(int x) {
		this.positionX = x;
	}


	public int getTrouY() {
		return TrouY;
	}


	public Image getHightpipe() {
		return hightpipe;
	}


	public Image getDownpipe() {
		return downpipe;
	}

	public int getDownpipestart() {
		return downpipestart;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}
