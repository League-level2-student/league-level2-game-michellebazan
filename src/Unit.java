import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Unit extends GameObject{
//variables
	//stats
	String name;
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
	Unit(int HP, int Atk, int Spd, int Def, int Res, int Mag, int Lck, Affinity element, int x, int y, int width, int height, String Name){
		//The super keyword refers to superclass (parent) objects. It is used to call superclass methods,
		//and to access the superclass constructor. The most common use of the super keyword is to eliminate
		//the confusion between superclasses and subclasses that have methods with the same name
		super(x, y, width, height); 
		//right - value passed in, left - value we want to save in the unit
		this.HP = HP;
		this.Atk = Atk;
		this.Spd = Spd;
		this.Def = Def;
		this.Res = Res;
		this.Mag = Mag;
		this.Lck = Lck;
		this.element = element;
		this.name = Name;
		
	}
	void heal(Unit unit, boolean isMagic) {
		//HP = 
		
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
						Double damagetaken = Mag * getAffinityModifier(unit.element) - unit.Res;
						if (damagetaken < 0) {
							damagetaken = 0.0;
						}
						unit.HP = (int) (unit.HP - damagetaken); 
						//name is our unit, unit is other
					} else if (isMagic == false) {
						Double damagetaken = Atk * getAffinityModifier(unit.element) - unit.Def;
						if (damagetaken < 0) {
							damagetaken = 0.0;
						}
						unit.HP = (int) (unit.HP - damagetaken);
					}
					JOptionPane.showMessageDialog(null, unit.name + " health is at " + unit.HP);
					
				}
			numAttacks = numAttacks - 1;
			//if it passes --> atk per numAttacks
			//if fails --> nothing, turn passed
			}
			
			
		}
	}
	
	// air, fire, water, earth + multiplier on strength: .5, 1, 2,
	double getAffinityModifier(Affinity unitAffinity) {
		//checks if main element is air
		if(element == Affinity.AIR) {
			//double damage against earth
			if (unitAffinity == Affinity.EARTH) {
				//returns damage
				return 2;
			}
			//normal damage against water/air
			if (unitAffinity == Affinity.WATER || unitAffinity == Affinity.AIR) {
				//returns damage
				return 1;
			}
			//half damage against fire
			if (unitAffinity == Affinity.FIRE) {
				//returns damage
				return 0.5;
			}
			
		//checks if main element is earth
		} else if (element == Affinity.EARTH) {
			//double damage against water
			if (unitAffinity == Affinity.WATER) {
				//returns damage
				return 2;
			}
			//normal damage against fire/earth
			if (unitAffinity == Affinity.FIRE || unitAffinity == Affinity.EARTH) {
				//returns damage
				return 1;	
						}
			//half damage against air
			if (unitAffinity == Affinity.AIR) {
				//returns damage
				return 0.5;
			}
		
		//checks if main element is fire
		} else if (element == Affinity.FIRE) {
			//double damage against air
			if (unitAffinity == Affinity.AIR) {
				//returns damage
				return 2;	
						}
			//normal damage against earth/fire
			if (unitAffinity == Affinity.FIRE || unitAffinity == Affinity.EARTH) {
				//returns damage
				return 1;
			}
			//half damage against water
			if (unitAffinity == Affinity.WATER) {
				//returns damage
				return 0.5;
			} 
		//checks if main element is water
		} else if (element == Affinity.WATER) {
			//double damage against fire
			if (unitAffinity == Affinity.FIRE) {
				//returns damage
				return 2;
			}
			//normal damage against air/water
			if (unitAffinity == Affinity.WATER || unitAffinity == Affinity.AIR) {
				//returns damage
				return 1;
			}
			//half damage against earth
			if (unitAffinity == Affinity.EARTH) {
				//returns damage
				return 0.5;
			}
		}
		
		//returns zero
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
