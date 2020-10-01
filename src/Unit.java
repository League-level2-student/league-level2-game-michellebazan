import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;

public class Unit extends GameObject{
//variables
	//stats
	int HP;
	int Atk;
	int Spd;
	int Def;
	int Res;
	int Mag;
	int Lck;
	Affinity element; //can check what element is equal to
	final static int BASEHITRATE = 85;
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	//constructor
	Unit(int HP, int Atk, int Spd, int Def, int Res, int Mag, int Lck, Affinity element, int x, int y, int width, int height){
		//The super keyword refers to superclass (parent) objects. It is used to call superclass methods,
		//and to access the superclass constructor. The most common use of the super keyword is to eliminate
		//the confusion between superclasses and subclasses that have methods with the same name
		super(x, y, width, height); 
	}
	
	void attack(Unit unit) {
		//speed
		int numAttacks = 1;
		if (Spd >= unit.Spd+4) {
			//twice the attacks
			numAttacks = 2;
		}
		//hit rate + luck
		for (int i = 0; i < numAttacks; i++) {
			//
			int trueHitRate = BASEHITRATE + Lck - unit.Lck;
			//random based on hit rate --> succeeds/fails
			Random rand = new Random();
			
			//if it passes --> atk per numAttacks
			//if fails --> nothing, turn passed
			
		}
	}
	
	void update(){
		//may or may not be needed here, depends on project development
	}
	
	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
        g.fillRect(x, y, width, height);
        
        if (gotImage) {
        	g.drawImage(image, x, y, width, height, null);
        } else {
        	g.setColor(Color.BLUE);
        	g.fillRect(x, y, width, height);
        }
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
	
}
