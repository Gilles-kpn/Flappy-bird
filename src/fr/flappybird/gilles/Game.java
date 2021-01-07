package fr.flappybird.gilles;
import javax.swing.*;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;
	public static Panel pan =new Panel();
	JButton tap = new JButton();
	
	public Game() {
		this.setTitle("Flappy Bird By Gilles");
		this.setSize(400,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setContentPane(pan);
		this.setFocusable(true);
		this.setResizable(false);
		this.setVisible(true);
		
	}

}
