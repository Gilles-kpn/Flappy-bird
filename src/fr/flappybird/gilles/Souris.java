package fr.flappybird.gilles;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Souris implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!Game.pan.getstartstate()&& !Game.pan.getprogressstate() && !Game.pan.getendstate()) {
			Game.pan.startGame();
			Game.pan.setstartstate(true);
			Game.pan.setprogressstate(true);
			Game.pan.setDx(1);
			Game.pan.oiseau.setJump(false); 
			
		}else if(Game.pan.getprogressstate() && !Game.pan.getendstate()) {
			Game.pan.oiseau.setJump(true);
			Audio.playSound("swooshing");
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
