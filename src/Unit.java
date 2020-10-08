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
	//checks for images
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
	
	void attack(Unit unit, boolean isMagic) {
		//speed
		int numAttacks = 1;
		if (Spd >= unit.Spd+4) {
			//twice the attacks
			numAttacks = 2;
		}
		//hit rate + luck
		for (int i = 0; i < numAttacks; i++) {
			//battle of luck
			int trueHitRate = BASEHITRATE + Lck - unit.Lck;
			//random based on hit rate --> succeeds/fails
			//use  random to get a number between 1 and 100. 
			//if we get a number that's under true hit rate --> we can deal damage to the target unit using attack against their defense
			Random rand = new Random();

			//for each type of attack allowed based on spd
			while (numAttacks > 0){
				int randnum = rand.nextInt(101);
				if (randnum < trueHitRate) {
					//any attack - their defense = damage to their HP
					if(isMagic == true) {
						int damagetaken = Mag - unit.Res;
						unit.HP = unit.HP - damagetaken; 
					} else if (isMagic == false) {
						int damagetaken = Atk - unit.Def;
						unit.HP = unit.HP - damagetaken;
					}
				}
			numAttacks = numAttacks - 1;
			//if it passes --> atk per numAttacks
			//if fails --> nothing, turn passed
			}
			
			
		}
	}
	// air, fire, water, earth + multiplier on strength: .5, 1, 2,
	double getAffinityModifier(Affinity unitAffinity, boolean isMagic) {
		//checks if main element is air
		if(element == Affinity.AIR) {
			//double damage against earth
			if (unitAffinity == Affinity.EARTH) {
				//check if attack/magic then multiple it
				if(isMagic == true) {
					return Mag * 2;
				} else if (isMagic == false) {
					return Atk * 2;
				}
			}
			//normal damage against water/air
			if (unitAffinity == Affinity.WATER || unitAffinity == Affinity.AIR) {
				
			}
			//half damage against fire
			if (unitAffinity == Affinity.FIRE) {
				
			}
			
		//checks if main element is earth
		} else if (element == Affinity.EARTH) {
			//double damage against water
			if (unitAffinity == Affinity.WATER) {
				
			}
			//normal damage against fire/earth
			if (unitAffinity == Affinity.FIRE || unitAffinity == Affinity.EARTH) {
							
						}
			//half damage against air
			if (unitAffinity == Affinity.AIR) {
				
			}
		
		//checks if main element is fire
		} else if (element == Affinity.FIRE) {
			//double damage against air
			if (unitAffinity == Affinity.AIR) {
							
						}
			//normal damage against earth/fire
			if (unitAffinity == Affinity.FIRE || unitAffinity == Affinity.EARTH) {
				
			}
			//half damage against water
			if (unitAffinity == Affinity.WATER) {
				
			} 
		//checks if main element is water
		} else if (element == Affinity.WATER) {
			//double damage against fire
			if (unitAffinity == Affinity.FIRE) {
				
			}
			//normal damage against air/water
			if (unitAffinity == Affinity.WATER || unitAffinity == Affinity.AIR) {
				
			}
			//half damage against earth
			if (unitAffinity == Affinity.EARTH) {
				
			}
		}
		
		return 0;
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
