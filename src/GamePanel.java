import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = MENU;

    int x = 500;
    int y = 800;
    //think about what kinds of classes - ex, units, fields
    	//class(es) based on main character, weapon/power MC 'throws', enemy
    	//an object manager. class - to update, draw and remove objects
    	//images for background + any characters 
    //questions for myself to think about while creating the final look of the game_-_-_-_-
    //how many units? Which ones? What kinds of classes?
    //should the game start with given units of random classes? //leaning towards yes
    //how should battles be like? one v one, group v group ?
    //duration of game? # of battles
    	//game state will need to change/update based on battles, should have a transition type thing in between fields (loading screen)
    //Should there be 'timed'/turn limited battles? //maybe towards the middle/end
    //an actual plot to the game or just have a goal introduced at the beginning
    //end state - should change based on fail/success model
    //should i learn how to do pixel art and make the characters or just borrow
    //what determines a 'win'? should the game reward the character for defeating enemies?
    //music/soundtrack?? should I create/code my own or borrow?
    //sound effects?
    //research previous older games to see what they look like
		//map(top view), when someone fights fades into a closer side view and shows the animation

    
    
    //already have
    	//set up different states - start(has text), middle(is just a black screen),
    	//end state(only a red screen)
    	//can switch between the 3 states
    
    
    Font titleFont;
    Font enterFont;
    Timer frameDraw;
    
    public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	
	GamePanel(){ 
    	titleFont = new Font("Arial", Font.PLAIN, 48);
    	enterFont = new Font("Arial", Font.PLAIN, 25);
    	// The first parameter is an i n t for how fast your want
    	//the timer to repeat. This is in milliseconds so 1000 
    	//is equal to 1 second. We want the game to run at 60 
    	//frames per second. So the first parameter will be 1000 / 60. 
    	frameDraw = new Timer(1000/60,this);
        frameDraw.start();

        //if (needImage) {
		//    loadImage ("space.png");
		//}
    }
	
	void startGame(){
    	
    }
    
    // 3 void methods for updating the game in each state
    void updateMenuState() { 
    	//empty
    }

    void updateGameState() { 
    	//empty
    	
    }
    
    void updateEndState()  { 
    	//empty
    }
    //3 void methods for drawing the game in each state
    void drawMenuState(Graphics g) {  
    	g.setColor(Color.BLUE);
    	g.fillRect(0, 0, FELite.WIDTH, FELite.HEIGHT);
    	
    	g.setFont(titleFont);
    	g.setColor(Color.LIGHT_GRAY);
    	g.drawString("FELite", x-325, y-700);
    	
    	g.setFont(enterFont);
    	g.drawString("Press ENTER to start", x-390, y-450);
    	
    	g.drawString("Press SPACE for instructions", x-430, y-300);
    }
    
    void drawGameState(Graphics g) {  

    	if (gotImage) {
        	g.drawImage(image,0,0, FELite.WIDTH, FELite.HEIGHT, null);

    	} else {
        	g.setColor(Color.BLACK);
        	g.fillRect(0, 0, FELite.WIDTH, FELite.HEIGHT);
        }
    	
    		
    }
    void drawEndState(Graphics g){  
    	g.setColor(Color.RED);
    	g.fillRect(0, 0, FELite.WIDTH, FELite.HEIGHT);
    }
    
    @Override
    public void paintComponent(Graphics g){
		//g.fillRect(10, 10, 100, 100);
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		   drawEndState(g);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();		    
		}else if(currentState == END){
		    updateEndState();
		}
		System.out.println("action");
		repaint();
		
	}

	
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//if (e.getKeyCode()==KeyEvent.VK_ENTER) {
	    //if (currentState == END) {
	    //    currentState = MENU;
	    //} else {
	    //    currentState++;
	    //}
		    
		    if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			    if (currentState == END) {
			    	currentState = MENU;
			    } else if(currentState == MENU){
			    	startGame();
			        currentState++;
			    	//currentState = GAME;
			    } else if (currentState == GAME) {
			        currentState++;
			    	//currentState = END;
			    }
			} 
			
			if (e.getKeyCode()==KeyEvent.VK_UP) {
			    System.out.println("UP");
			}
			else if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    System.out.println("DOWN");
			}
			else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			    System.out.println("RIGHT");
			}
			else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    System.out.println("LEFT");
			}
			//else if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			//}
		    
		    
		   
	}

	
}
