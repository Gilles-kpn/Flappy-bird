package fr.flappybird.gilles;

public class Chrono implements Runnable {

		private final int pause = 15; //temps d'attente 3ms
	@Override
	public void run() {
		while(true){
			Game.pan.repaint(); 
			try {
				Thread.sleep(pause);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
