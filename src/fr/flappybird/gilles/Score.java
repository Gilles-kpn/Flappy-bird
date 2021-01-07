package fr.flappybird.gilles;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Score {
	private ImageIcon uniteico,dizaineico,centaineico;
	private Image unite,dizaine,centaine;
	private int score = 0;
	public Score(int x) {
		this.score = x;
		if(this.score==0) {
			uniteico =new ImageIcon(getClass().getResource("/images/"+this.score+".png"));
			dizaineico =new ImageIcon(getClass().getResource("/images/"+this.score+".png"));
			centaineico =new ImageIcon(getClass().getResource("/images/"+this.score+".png"));
			this.unite = this.uniteico.getImage();
			this.dizaine = this.dizaineico.getImage();
			this.centaine = this.centaineico.getImage();
		}
			
			
		
	}
	public void setScore(int score) {
		this.score = score;
	}
	private Image load(int s) {
		ImageIcon temp = new ImageIcon(getClass().getResource("/images/"+s+".png"));
		return temp.getImage();
	}
	public Image getUnite() {
		if(this.score <10 && this.score>=1) {
			this.unite =load(this.score);
		}else if(this.score >9 && this.score<100){
			this.unite = load(this.score%10);
		}else if(this.score>99 && this.score<1000) {
			this.unite = load(((this.score%100)%10));
		}
		return unite;
	}
	public Image getDizaine() {
		if(this.score >9 && this.score<100){
			this.dizaine = load(this.score/10);
		}else if(this.score>99 && this.score<1000) {
			this.dizaine = load((this.score%100)/10);
		}
		return dizaine;
		
	}
	public Image getCentaine() {
		if(this.score>99 && this.score<1000) {
			this.centaine = load(this.score/100);
		}
		return centaine;
	}

}
