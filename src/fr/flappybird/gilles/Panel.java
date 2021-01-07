package fr.flappybird.gilles;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel{
	private static final long serialVersionUID = 1L;
	public Bird oiseau = new Bird();
	private int dx =0,backgroundx =0,backgroundx2 = 400,basex =0,basex2=336;
	private Image background,base,stop,start,background2 ;
	private ImageIcon backgroundico,baseico,stopico,image,startico;
	private boolean end = false,progress =false,started =false;
	private int compteursaut;
	private int score = 0;
	private Score Score = new Score(score);
	private Thread actualise = new Thread(new Chrono());
	private Obstacle obst = new Obstacle(150);
	private Obstacle obst2 = new Obstacle(this.obst.getPositionX()+this.aleatoire(105, 275));
	private Obstacle obst3 = new Obstacle(this.obst2.getPositionX()+this.aleatoire(175, 275));
	private ArrayList<Obstacle> obstlist ;
	public Panel() {
		super();
		backgroundico = this.composantimg("background-day.png");
		this.background = this.backgroundico.getImage();
		this.background2 = this.backgroundico.getImage();
		baseico = this.composantimg("base.png");
		this.base= this.baseico.getImage();
		stopico = this.composantimg("gameover.png");
		this.stop =this.stopico.getImage(); 
		startico = this.composantimg("message.png");
		this.start = this.startico.getImage();
		this.compteursaut=0;
		this.addMouseListener(new Souris());
		obst.setActive(true);
		obstlist =new ArrayList<Obstacle>();
		this.obstlist.add(obst);
		this.obstlist.add(obst2);
		this.obstlist.add(obst3);
		
		}
		
	

	public void startGame() {
		this.actualise.start();
	}
	
	public void stopGame() {
		try {
			this.actualise.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


 
	//to paint compornent on  jpanels
	public void paintComponent(Graphics g2) {
		
		// drawing background  OK
		g2.drawImage(this.background, this.backgroundx,0,400,this.getHeight(),this);
		g2.drawImage(this.background2, this.backgroundx2,0,400,this.getHeight(),this);
		
		//drawBird  OK
		g2.drawImage(this.oiseau.getBird(),this.oiseau.getBirdx(),this.oiseau.getBirdy(),this.oiseau.getBirdwidth(),this.oiseau.getBirdheight(),this);
		 
		//draw obstacle
		for(int i =0 ; i<this.obstlist.size(); i++) {
			Obstacle temp = this.obstlist.get(i);
			g2.drawImage(temp.getDownpipe(),temp.getPositionX(),temp.getDownpipestart(),40,this.getHeight()-temp.getDownpipestart(),this);
			g2.drawImage(temp.getHightpipe(),temp.getPositionX(),0,40,temp.getTrouY(),this);
			if(this.oiseau.getBirdx()+this.oiseau.getBirdwidth()+2>= temp.getPositionX()) {
				temp.setActive(true);
			}
			if(this.oiseau.getBirdx()>temp.getPositionX()+40 ) {
				temp.setActive(false);
				
			}
			if(temp.isActive()) {
				if((this.oiseau.getBirdy()+this.oiseau.getBirdheight() >= temp.getDownpipestart()) && (this.oiseau.getBirdx()+this.oiseau.getBirdwidth()>=temp.getPositionX())) {
					if((this.oiseau.getBirdx()<=temp.getPositionX()+70)) {
						Audio.playSound("hit");
						this.end =true;
					} 
				} 
				if((this.oiseau.getBirdy()<temp.getTrouY())&& (this.oiseau.getBirdx()+this.oiseau.getBirdwidth() > temp.getPositionX())) {
					if(this.oiseau.getBirdx()<=temp.getPositionX()+42) {
						Audio.playSound("hit");
						this.end =true;
					}
				} 
				if(this.oiseau.getBirdx()+this.oiseau.getBirdwidth() == temp.getPositionX()+20) {
					this.score++;
					Audio.playSound("point");
					this.Score.setScore(score);
				}
			}
			if(this.obstlist.get(0).getPositionX()+70<0) {
				this.obstlist.add(new Obstacle(this.obstlist.get(this.obstlist.size()-1).getPositionX()+this.aleatoire(150, 250)));
				this.obstlist.remove(0);
			}
			
		}
		g2.drawImage(this.obst.getDownpipe(),this.obst.getPositionX(),this.obst.getDownpipestart(),40,this.getHeight()-this.obst.getDownpipestart(),this);
		g2.drawImage(this.obst.getHightpipe(),this.obst.getPositionX(),0,40,this.obst.getTrouY(),this);
		//draw base OK
		g2.drawImage(this.base,this.backgroundx,this.getHeight()-60,400,60, this);
		g2.drawImage(this.base,this.backgroundx2,this.getHeight()-60,400,60, this);
		
		
		//draw Score
		g2.drawImage(this.Score.getCentaine(),this.getWidth()-72,1,24,36,this);
		g2.drawImage(this.Score.getDizaine(),this.getWidth()-48,1,24,36,this);
		g2.drawImage(this.Score.getUnite(),this.getWidth()-24,1,24,36,this);
		//game status OK 
		if(!started){
			g2.drawImage(this.start,(this.getWidth()/2)-92, (this.getHeight()/2)-150,182,300, this);
			
		}else if(started && end) {
			g2.drawImage(this.stop, (this.getWidth()/2)-80, (this.getHeight()/2)-21,192,42, this);
			this.started =true;
			this.end = true;
			this.actualise.stop();
			
		} 
		//the bird fall and ecrase
		if(this.oiseau.getBirdy()+this.oiseau.getBirdheight() == 500) {
			Audio.playSound("die");
			this.end =true;
			this.dx = 0; 
		} 
		//Jump
		if(this.oiseau.isJump() ) {
			this.compteursaut++; //incrementation du saut
			//mettons l'oiseau blue
			this.oiseau.setBird("yellowbird-upflap.png");
			
				//ascension
				if(this.compteursaut <20) { 
					if(this.oiseau.getBirdy() <= 10) {
						
					}else { 
						this.oiseau.setBirdy(this.oiseau.getBirdy()-2);
					}
				}else if(this.compteursaut==21) {
					this.oiseau.setBird("yellowbird-midflap.png");
				}else if(this.compteursaut>21) {
					//chute
					this.oiseau.setJump(false);
					this.oiseau.setBird("yellowbird-upflap.png");
					this.compteursaut =0;
					
			}
			
		}
		//minimumadvace on x
		if(this.oiseau.getBirdx() <= 100) {
			this.oiseau.setBirdx(this.oiseau.getBirdx()+1);
		}
		// to set fall of bird
		if(!this.oiseau.isJump()) {
			//define the red bird 
			this.oiseau.setBird("yellowbird-downflap.png");
			// add 1 for each  tour to 
			this.oiseau.setBirdy(this.oiseau.getBirdy()+1);
			
		}//
		this.backgroundmove();
		/*
		
		System.out.println(
		"Abscisse de l'oiseau en X: "+this.oiseau.getBirdx()+"\n"
	  + "Abscisse de l'oiseau en Y: "+this.oiseau.getBirdy()+"\n"
	  + "Taille de la fenetre en X: "+this.getWidth()+"\n"
	  + "Hauteur de la fenetre (Y): "+this.getHeight()+"\n"
	  + "Etat saut de l'oiseau    : "+this.oiseau.isJump()+"\n"
	  + "Score dans le jeu        : "+this.score+"\n"
	  + "###############################"
		);
		*/
		
	} 
	// load image
	private ImageIcon composantimg(String imgname) { 
			this.image = new ImageIcon(getClass().getResource("/images/"+imgname));
			return image;
	}
	//bird deplacement
	public void backgroundmove() {
		
		this.backgroundx = this.backgroundx-this.dx;
		this.basex = this.basex -this.dx;
		this.backgroundx2 = this.backgroundx2-this.dx;
		this.basex2 = this.basex2 -this.dx;
		if(this.backgroundx == -401) {
			this.backgroundx =400;
		}else if(this.backgroundx2 == -401) {
			this.backgroundx2= 400;
		}
		
		for(int i=0;i<this.obstlist.size();i++) {
			this.obstlist.get(i).setPositionX(this.obstlist.get(i).getPositionX()-this.dx);
			
		}
	}
	//dx
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}


	
	//end state of game if end=true game stop else game continue
	public boolean getendstate() {
		return this.end;
	}
	public void setendstate(boolean x) {
		this.end = x;
	}
	
	//start game state
	public boolean getstartstate() {
		return this.started;
	}
	public void setstartstate(boolean x) {
		this.started = x;
	}
	
	//progress game state
	public boolean getprogressstate() {
		return this.progress;
	}
	public void setprogressstate(boolean x) {
		this.progress =x;
	}
	private int aleatoire(int min,int max) {
		int n =(int) (min+ (Math.random() * (max-min)));
		return n;
	}


}
