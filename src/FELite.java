import javax.swing.JFrame;

public class FELite {
	//runner/driver class that controls the entire program 
	
	JFrame frame = new JFrame("FELite");
	
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	GamePanel gamePanel; 
	

	FELite() {
	gamePanel = new GamePanel();
	}
	
	public static void main(String[] args) { 
		//main method
		FELite game = new FELite();
		
		
		game.setup();
	}
	
	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.addKeyListener(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	
	
}
