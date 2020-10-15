import javax.swing.JOptionPane;

public class AreaBattle {
	public static void main(String[] args) {
		//after testing, program another action (like healing) to unit support
		
		//Unit(int HP, int Atk, int Spd, int Def, int Res, int Mag, int Lck, Affinity element, int x, int y, int width, int height)
		Unit Fred = new Unit(30, 10, 8, 5, 2, 2, 6, Affinity.FIRE, 20, 20, 20, 20, "Fred");
		Unit Runrun = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.AIR, 20, 21, 20, 20, "Runrun");
		
		while(Fred.HP >= 0 && Runrun.HP >= 0) {
			int attackoption = JOptionPane.showOptionDialog(null, "Choose an attack", "attack", 0, -1, null, new String [] {"ATK", "MAG"}, 0);
			//Fred's attack options
			if ( attackoption == 0) {
				//atk
				Fred.attack(Runrun, false);
			} else if (attackoption == 1) {
				//mag
				Fred.attack(Runrun, true);
			}
			if (Runrun.HP <= 0) {
				JOptionPane.showMessageDialog(null, "Fred won.");
				break;
			
			}
			
			attackoption = JOptionPane.showOptionDialog(null, "Choose an attack", "attack", 0, -1, null, new String [] {"ATK", "MAG"}, 0);
			//RR's attack options
			if (attackoption == 0) {
				//atk
				Runrun.attack(Fred, false);
			} else if (attackoption == 1) {
				//mag
				Runrun.attack(Fred, true);
			}
		if(Fred.HP <= 0) {
			JOptionPane.showMessageDialog(null, "Runrun won.");
			break;
		}
		
		}
		
		 
		
	}
}
