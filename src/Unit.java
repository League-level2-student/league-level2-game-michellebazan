import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Unit extends GameObject{
	//stats
	int HP;
	int Atk;
	int Spd;
	int Def;
	int Res;
	
	Affinity element; //can check what element = to
	
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	
	//each unit has diff. stats
	
	Unit(int HP, int Atk, int Spd, int Def, int Res, int x, int y, int width, int height){
		//The super keyword refers to superclass (parent) objects. It is used to call superclass methods,
		//and to access the superclass constructor. The most common use of the super keyword is to eliminate
		//the confusion between superclasses and subclasses that have methods with the same name
		super(x, y, width, height); 
		
		
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
