import java.util.Random;

import javax.swing.JOptionPane;

public class AreaBattle {
	public static void main(String[] args) {
		
		//Unit(int HP, int Atk, int Spd, int Def, int Res, int Mag, int Lck, Affinity element, int x, int y, int width, int height)
		Unit Fred = new Unit(30, 10, 8, 5, 2, 2, 6, Affinity.FIRE, 20, 20, 20, 20, "Fred"); // unit
		Unit Runrun = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.AIR, 20, 21, 20, 20, "Runrun"); // unit
		
		//other units to added /// remember to change values later and vary it
		Unit Night = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.WATER, 20, 21, 20, 20, "Night");
		Unit Child = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.AIR, 20, 21, 20, 20, "Child");
		Unit Tilly = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.EARTH, 20, 21, 20, 20, "Tilly");
		Unit Fraser = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.FIRE, 20, 21, 20, 20, "Fraser");
		
		int battlenumber = 1;
		
		int prologue = JOptionPane.showOptionDialog(null, "Welcome to the battle area. What would you like to do", "At the doorway", 0, -1, null, new String [] {"Read Instructions", "Start"}, 0);
		if (prologue == 0) {
			//instructions here
			JOptionPane.showMessageDialog(null, "You, the player, will decide the fate of two duelers. There will be different attack options, depending on the background of the dueler. ");
			JOptionPane.showMessageDialog(null, "When a dueler's HP reaches zero, the game will end. You may choose to play another round or forever leave the area.");
			prologue = prologue + 1;
		} 
		//randomUnits();{
			// random numbers for randomizing the units
			Random ballotnum = new Random();
			Random num22 = new Random();
		    // array to include units + including random values
			Unit[] fighters = {Fred, Runrun, Night, Child, Tilly, Fraser};
			Unit Unit1 = fighters[ballotnum.nextInt(7)];
			Unit Unit2 = fighters[num22.nextInt(7)];
			
			while (Unit1 == Unit2) {
				//to prevent someone from fighting themselves
				Random ballotnum2 = new Random();
				Random num222 = new Random();
			    
				Unit1 = fighters[ballotnum2.nextInt(7)];
				Unit2 = fighters[num222.nextInt(7)];
			}
			
			
			//battle number
			
		//}
		
		//basically i was trying to get a loop of battles, but i think the order and the way i have things are messing it up
			//so try to randomizeunits --> prologue --> commentary --> round starts
			
			
		//unit.name is your friend if you want to have the string form of the unit name
		//make below into a method and call it whenever a new round starts
		//new plan----
			//while ( battledesire == 0){
		    //randomUnits
			
			if (prologue == 1) {
				//starting the game
			JOptionPane.showMessageDialog(null, "So to start off, there are already two chosen fighters; they are called " + Unit1.name + " and " + Unit2.name + ". ");
			}
			JOptionPane.showMessageDialog(null, "Welcome to battle number " + battlenumber + "!!!");
			battlenumber = battlenumber + 1;
			
			//call round()
			//if (roundnumber > 5) {
			//JOptionPane.showConfirmDialog(null, "Do you wish to continue? ");
			//if yes --> new round
				//battledesire = battledesire + 1;
			//if no --> ask if leave area
			//if yes ---> leave and force close game
				//battledesire = battledesire + 1;
			//if no --> new round
			//}
			//}
			
			
			
			
		round();{
		while(Unit1.HP >= 0 && Unit2.HP >= 0) {
			int attackoption = JOptionPane.showOptionDialog(null, "Choose an attack", Unit1.name, 0, -1, null, new String [] {"ATK", "MAG"}, 0);
			//Unit1's attack options
			if ( attackoption == 0) {
				//atk
				Unit1.attack(Unit2, false);
			} else if (attackoption == 1) {
				//mag
				Unit1.attack(Unit2, true);
				if (Unit1.Mag == 1) {
					JOptionPane.showMessageDialog(null, Unit1.name + " does not have magic so nothing happens... ");
				}
				
			}
			if (Unit2.HP <= 0) {
				JOptionPane.showMessageDialog(null, Unit1.name + " won. ");
				break;
			
			}
			
			attackoption = JOptionPane.showOptionDialog(null, "Choose an attack",  String.valueOf(Unit2), 0, -1, null, new String [] {"ATK", "MAG"}, 0);
			//Unit2's attack options
			if (attackoption == 0) {
				//atk
				Unit2.attack(Unit1, false);
			} else if (attackoption == 1) {
				//mag
				attackoption = JOptionPane.showOptionDialog(null, "Choose an attack", String.valueOf(Unit2), 0, -1, null, new String [] {"HL", "MAG"}, 0);
				if (attackoption == 0) {
					Unit2.heal(Unit2, true);
				} else if (attackoption == 1) {
					Unit2.attack(Unit1, true);
				}
				
			}
		if(Unit2.HP <= 0) {
			JOptionPane.showMessageDialog(null, String.valueOf(Unit2)+" won.");
			break;
		}
		
		}
		}
		//if round is over then call unit randomizer then start round
		//include option of leaving area--
		// leave area -- choose between feeding pigeons or going to the park
		// if feed pigeons, player will return home and continue living their life as normal
		//if eat food, player will have fun at the park and have a realization that the battle area was defintely not normal. 
	}

	private static void randomUnits() {
		// TODO Auto-generated method stub
		
	}

	private static void round() {
		// TODO Auto-generated method stub
		
	}

	private static void test() {
		// TODO Auto-generated method stub
		
	}
}
