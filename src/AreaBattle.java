import java.util.Random;

import javax.swing.JOptionPane;

public class AreaBattle { // i think it was supposed to be called ArenaBattle but arena looks like a fake
							// word so the name is not going to change
	public static void main(String[] args) {
		// after testing, program another action (like healing) to unit support

		// Unit(int HP, int Atk, int Spd, int Def, int Res, int Mag, int Lck, Affinity
		// element, int x, int y, int width, int height)
		Unit Fred = new Unit(30, 10, 8, 5, 2, 2, 6, Affinity.FIRE, 20, 20, 20, 20, "Fred"); // starting unit
		Unit Runrun = new Unit(28, 4, 7, 3, 7, 9, 9, Affinity.AIR, 20, 21, 20, 20, "Runrun"); // starting unit

		// other units
		Unit Night = new Unit(27, 7, 7, 4, 8, 12, 4, Affinity.WATER, 20, 21, 20, 20, "Night");
		Unit Child = new Unit(26, 10, 9, 5, 4, 5, 5, Affinity.AIR, 20, 21, 20, 20, "Child");
		Unit Tilly = new Unit(28, 8, 7, 6, 6, 7, 5, Affinity.EARTH, 20, 21, 20, 20, "Tilly");
		Unit Fraser = new Unit(25, 9, 10, 5, 3, 3, 7, Affinity.FIRE, 20, 21, 20, 20, "Fraser");
		int round = 0;

		String l1 = " ";
		String l2 = " ";
		String l3 = " ";
		String l4 = " ";
		String l5 = " ";
		// prologue
		int prologue = JOptionPane.showOptionDialog(null,
				"Welcome  to  the  battle  area.  What  would  you  like  to  do", "At  the  doorway", 0, -1, null,
				new String[] { "Read  Instructions", "Start" }, 0);
		if (prologue == 0) {
			// instructions here
			JOptionPane.showMessageDialog(null,
					"There  are  two  duelers,  and  you  will  decide  the  fate  of  them.");
			JOptionPane.showMessageDialog(null,
					"There  will  be  different  attack  options,  depending  on  the  background  of  the  dueler.  ");
			JOptionPane.showMessageDialog(null,
					"Oh  and  background  means  that  each  dueler  has  their  own  elemental  affinity  and  abiltity  (magic  vs  physical  attack).  ");
			JOptionPane.showMessageDialog(null,
					"Anyways  when  a  dueler's  HP  reaches  zero,  the  game  will  end.  You  may  choose  to  play  another  round  or  forever  leave  the  area.  ");

			prologue = 1;

		}

		// one random can be used for different arrays/purposes. it does not hold random
		// numbers, it generates them.
		// ctrl shift f is to format the code
		Random ballotnum = new Random();

		// array to include units + including random values
		Unit[] fighters = { Fred, Runrun, Night, Child, Tilly, Fraser };
		Unit Unit1 = fighters[ballotnum.nextInt(fighters.length)]; // can add other fighters
		Unit Unit2 = fighters[ballotnum.nextInt(fighters.length)];

		while (Unit1.name == Unit2.name) {
			// makes sure that units will not be the same

			Unit1 = fighters[ballotnum.nextInt(fighters.length)];
			Unit2 = fighters[ballotnum.nextInt(fighters.length)];
		}

		JOptionPane.showMessageDialog(null,
				"So  to  start  off,  there  are  already  two  chosen  fighters;  they  are  called  " + Unit1.name
						+ "  and  " + Unit2.name + ".  ");

		// round =0
		while (round > -1) {// *************************************************************************************************************************************************

			if (round > 0) { // rounds that are not the very first one

				while (Unit1.name == Unit2.name || Unit1.HP <= 0 || Unit2.HP <= 0) {

					Unit1 = fighters[ballotnum.nextInt(fighters.length)];
					Unit2 = fighters[ballotnum.nextInt(fighters.length)];
					System.out.println(round);
				}
				JOptionPane.showMessageDialog(null, "For  this  round,  there  are  two  fighters;  they  are  called  "
						+ Unit1.name + "  and  " + Unit2.name + ".  ");
			}

			// attack while loop
			while (Unit1.HP > 0 && Unit2.HP > 0) {

				int attackoption = JOptionPane.showOptionDialog(null, "Choose  an  attack",
						Unit1.name + " " + Unit1.element, 0, -1, null, new String[] { "ATK", "MAG" }, 0);
				// Unit1's attack options
				if (attackoption == 0) {
					// atk
					Unit1.attack(Unit2, false);
				} else if (attackoption == 1) {
					// mag
					// Unit1.attack(Unit2, true);
					if (Unit1.Mag > 5) {

						attackoption = JOptionPane.showOptionDialog(null, "Choose  an  attack",
								Unit1.name + " " + Unit1.element, 0, -1, null, new String[] { "HL", "MAG" }, 0);
						if (attackoption == 0) {
							Unit1.heal(Unit1, true);
						} else if (attackoption == 1) {
							Unit1.attack(Unit2, true);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								Unit1.name + "  does  not  have  magic  so  nothing  happens...  ");
					}

				}
				if (Unit2.HP <= 0) {
					JOptionPane.showMessageDialog(null, Unit1.name + "  won.");

					if (round == 0) {
						l1 = Unit2.toString();
						System.out.println(l1);
						System.out.println(Unit2.name + " is out. ");
					} else if (round == 1) {
						l2 = Unit2.toString();
						System.out.println(l2);
						System.out.println(Unit2.name + " is out. ");
					} else if (round == 2) {
						l3 = Unit2.toString();
						System.out.println(l3);
						System.out.println(Unit2.name + " is out. ");
					} else if (round == 3) {
						l4 = Unit2.toString();
						System.out.println(l4);
						System.out.println(Unit2.name + " is out. ");
					} else if (round == 4) {
						l5 = Unit2.toString();
						System.out.println(l5);
						System.out.println(Unit2.name + " is out. ");
					}

					// end game result

					round += 1;
					if (round >= 5) {
						System.out.println(Unit1.name);
						JOptionPane.showMessageDialog(null, Unit1.name + "  won the battle arena.");
						break;
					}
					System.out.println(round);
					break;

				}

				attackoption = JOptionPane.showOptionDialog(null, "Choose  an  attack",
						Unit2.name + " " + Unit2.element, 0, -1, null, new String[] { "ATK", "MAG" }, 0);
				// Unit2's attack options
				if (attackoption == 0) {
					// atk
					Unit2.attack(Unit1, false);
				} else if (attackoption == 1) {
					// mag
					// Unit2.attack(Unit1, true);

					if (Unit2.Mag > 5) {

						attackoption = JOptionPane.showOptionDialog(null, "Choose  an  attack",
								Unit2.name + " " + Unit2.element, 0, -1, null, new String[] { "HL", "MAG" }, 0);
						if (attackoption == 0) {
							Unit2.heal(Unit2, true);
						} else if (attackoption == 1) {
							Unit2.attack(Unit1, true);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								Unit2.name + "  does  not  have  magic  so  nothing  happens...  ");
					}

				}

				if (Unit1.HP <= 0) {
					JOptionPane.showMessageDialog(null, Unit2.name + "  won.");

					if (round == 0) {
						l1 = Unit1.toString();
						System.out.println(l1);
						System.out.println(Unit1.name + " is out. ");
					} else if (round == 1) {
						l2 = Unit1.toString();
						System.out.println(l2);
						System.out.println(Unit1.name + " is out. ");
					} else if (round == 2) {
						l3 = Unit1.toString();
						System.out.println(l3);
						System.out.println(Unit1.name + " is out. ");
					} else if (round == 3) {
						l4 = Unit1.toString();
						System.out.println(l4);
						System.out.println(Unit1.name + " is out. ");
					} else if (round == 4) {
						l5 = Unit1.toString();
						System.out.println(l5);
						System.out.println(Unit1.name + " is out. ");
					}

					round += 1;
					if (round >= 5) {
						System.out.println(Unit2.name);
						JOptionPane.showMessageDialog(null, Unit2.name + "  won the battle arena.");
						break;
					}

					System.out.println(round);
					break;

				}

			} // fight while loop ends here
			if (round >= 5) {

				break;
			}
			if (round < 5) {
				int escape = JOptionPane.showOptionDialog(null, "Do  you  want  to  continue  in  the  battle  arena?",
						"arena", 0, 1, null, new String[] { "Yes", "No" }, 0);
				if (escape == 1) {
					JOptionPane.showMessageDialog(null,
							"You  leave  the  battle  arena  and  took  a  deep  breath.  The  air  tastes  crunchy  like  a  snicker  bar.");
					JOptionPane.showMessageDialog(null,
							"You  look  up  and  see  a  bird  pass  by.  You  realize  you  are  free  from  eternal  hell.");
					break;
				}
			}
			
			System.out.println(round);
			

		} ////////// *****************************************************************************************************************************************

	}
}