import  java.util.Random;

import  javax.swing.JOptionPane;

public  class  AreaBattle  {  //i  think  it  was  supposed  to  be  called  ArenaBattle  but  arena  looks  like  a  fake  word  so  the  name  is  not  going  to  change
	public  static  void  main(String[]  args)  {
		//after  testing,  program  another  action  (like  healing)  to  unit  support                 
		
		//Unit(int  HP,  int  Atk,  int  Spd,  int  Def,  int  Res,  int  Mag,  int  Lck,  Affinity  element,  int  x,  int  y,  int  width,  int  height)
		Unit  Fred  =  new  Unit(30,  10,  8,  5,  2,  2,  6,  Affinity.FIRE,  20,  20,  20,  20,  "Fred");  //starting  unit
		Unit  Runrun  =  new  Unit(28,  4,  7,  3,  7,  9,  9,  Affinity.AIR,  20,  21,  20,  20,  "Runrun");  //starting  unit
		
		//other  units
		Unit  Night  =  new  Unit(27,  7,  7,  4,  8,  12,  4,  Affinity.WATER,  20,  21,  20,  20,  "Night");
		Unit  Child  =  new  Unit(26,  10,  9,  5,  2,  5,  5,  Affinity.AIR,  20,  21,  20,  20,  "Child");
		Unit  Tilly  =  new  Unit(28,  8,  7,  6,  6,  7,  5,  Affinity.EARTH,  20,  21,  20,  20,  "Tilly");
		Unit  Fraser  =  new  Unit(25,  9,  10,  5,  2,  3,  7,  Affinity.FIRE,  20,  21,  20,  20,  "Fraser");
		int  round  =  0;
		//prologue
		int  prologue  =  JOptionPane.showOptionDialog(null,  "Welcome  to  the  battle  area.  What  would  you  like  to  do",  "At  the  doorway",  0,  -1,  null,  new  String  []  {"Read  Instructions",  "Start"},  0);
		if  (prologue  ==  0){
			//instructions  here
			JOptionPane.showMessageDialog(null,  "There  are  two  duelers,  and  you  will  decide  the  fate  of  them.");
			JOptionPane.showMessageDialog(null,  "There  will  be  different  attack  options,  depending  on  the  background  of  the  dueler.  ");
			JOptionPane.showMessageDialog(null,  "Oh  and  background  means  that  each  dueler  has  their  own  elemental  affinity  and  abiltity  (magic  vs  physical  attack).  ");
			JOptionPane.showMessageDialog(null,  "Anyways  when  a  dueler's  HP  reaches  zero,  the  game  will  end.  You  may  choose  to  play  another  round  or  forever  leave  the  area.  ");
			
			prologue=1;
			
		}
		
		Random  ballotnum  =  new  Random();
		Random  num22  =  new  Random();
	        //  array  to  include  units  +  including  random  values
		Unit[]  fighters  =  {Fred,  Runrun,  Night,  Child,  Tilly,  Fraser};
		Unit  Unit1  =  fighters[ballotnum.nextInt(7)];
		Unit  Unit2  =  fighters[num22.nextInt(7)];
		
		while  (Unit1.name  ==  Unit2.name)  {
			//makes  sure  that  units  will  not  be  the  same
			Random  ballotnum22  =  new  Random();
			Random  num2222  =  new  Random();
	
			Unit1  =  fighters[ballotnum22.nextInt(7)];
			Unit2  =  fighters[num2222.nextInt(7)];
		}
		
		JOptionPane.showMessageDialog(null,  "So  to  start  off,  there  are  already  two  chosen  fighters;  they  are  called  "  +  Unit1.name  +  "  and  "  +  Unit2.name  +  ".  ");
		
		//repeats  until  player  wishes  to  leave  arena
		//round  =  0  ,,,  first  loop  it  begins  at  0
		//bug  starts(?)  here  *******************************************************************************************************
		//thoughts  on  bug - - - - - - - - - - - - - - - - - - - - - - - -
				//it  forcefully  breaks  the  game  after  2-3  rounds
				//very  inconsistent  in  the  expected  outcome  of  clicking  buttons
					//ex/  going  to  the  next  round  and  repeats  who  is  fighting  multiple  times
					//ex/  i  play  it  through  one  time  and  it  closes  after  the  first  round.  i  play  it  again  and  
					//it  lasts  past  the  first  round  (with  the  same  code)
			//bug  can  become  even  worse,  breaks  after  the  first  round  ///  became  worse  after  I  changed  line  60  to  round  >  0.
			//the  bug  is  involved  with  integer  round, not with attackoptions or anything else
		
		while  (round  >  -1)  {//*************************************************************************************************************************************************
			
			if(round>1)  {  //rounds  that  are  not  the  very  first  one  
				Random  ballotnum2  =  new  Random();
				Random  num222  =  new  Random();
		
				Unit1  =  fighters[ballotnum2.nextInt(7)];
				Unit2  =  fighters[num222.nextInt(7)];
				
				while  (Unit1.name  ==  Unit2.name)  {
					//makes  sure  that  units  will  not  be  the  same
					Random  ballotnum22  =  new  Random();
					Random  num2222  =  new  Random();
			
					Unit1  =  fighters[ballotnum22.nextInt(7)];
					Unit2  =  fighters[num2222.nextInt(7)];
			}
			
			}
			
		if  (round  >=1)  {
			JOptionPane.showMessageDialog(null,  "For  this  round,  there  are  two  fighters;  they  are  called  "  +  Unit1.name  +  "  and  "  +  Unit2.name  +  ".  ");
		}
		
		//below is not involved with bug
		while(Unit1.HP  >=  0  &&  Unit2.HP  >=  0)  {
			
			int  attackoption  =  JOptionPane.showOptionDialog(null,  "Choose  an  attack",  Unit1.name,  0,  -1,  null,  new  String  []  {"ATK",  "MAG"},  0);
			//Unit1's  attack  options
			if  (  attackoption  ==  0)  {
				//atk
				Unit1.attack(Unit2,  false);
			}  else  if  (attackoption  ==  1)  {
				//mag
				//Unit1.attack(Unit2,  true);
				if(Unit1.Mag  >  5)  {
					
					attackoption  =  JOptionPane.showOptionDialog(null,  "Choose  an  attack",  Unit1.name,  0,  -1,  null,  new  String  []  {"HL",  "MAG"},  0);
					if  (attackoption  ==  0)  {
						Unit1.heal(Unit1,  true);
					}  else  if  (attackoption  ==  1)  {
						Unit1.attack(Unit2,  true);
					}
				}
				else  {
					JOptionPane.showMessageDialog(null,  Unit1.name  +  "  does  not  have  magic  so  nothing  happens...  ");
				}
				
				
			}
			if  (Unit2.HP  <=  0)  {
				JOptionPane.showMessageDialog(null,  Unit1.name  +  "  won.");
				//round++;
				break;
			
			}
			
			attackoption  =  JOptionPane.showOptionDialog(null,  "Choose  an  attack",    Unit2.name,  0,  -1,  null,  new  String  []  {"ATK",  "MAG"},  0);
			//Unit2's  attack  options
			if  (attackoption  ==  0)  {
				//atk
				Unit2.attack(Unit1,  false);
			}  else  if  (attackoption  ==  1)  {
				//mag
				//Unit2.attack(Unit1,  true);
				
				if  (Unit2.Mag  >  5)  {
					
					attackoption  =  JOptionPane.showOptionDialog(null,  "Choose  an  attack",  Unit2.name,  0,  -1,  null,  new  String  []  {"HL",  "MAG"},  0);
					if  (attackoption  ==  0)  {
						Unit2.heal(Unit2,  true);
					}  else  if  (attackoption  ==  1)  {
						Unit2.attack(Unit1,  true);
					}
				}
				else  {
					JOptionPane.showMessageDialog(null,  Unit2.name  +  "  does  not  have  magic  so  nothing  happens...  ");
				}
				
			}
			
		if  (Unit2.HP  <=  0)  {
			JOptionPane.showMessageDialog(null,  Unit2.name  +  "  won.");
			//round++;
			break;
		}
		
		}
		
		int  escape  =  JOptionPane.showOptionDialog(null,  "Do  you  want  to  continue  in  the  battle  arena?",  "arena",  0,  1,  null,  new  String  []  {"Yes",  "No"},  0);;
		if  (escape  ==  1)  {
			JOptionPane.showMessageDialog(null,  "You  leave  the  battle  arena  and  took  a  deep  breath.  The  air  tastes  crunchy  like  a  snicker  bar.");
			JOptionPane.showMessageDialog(null,  "You  look  up  and  see  a  bird  pass  by.  You  realize  you  are  free  from  eternal  hell.");
			break;
		}  
		round++; //increasing round to at least 1
		
		//below  does  not  affect  bug -- its just extra and i cant even test it since the bug stops me
		if  (round==10)  {
			System.out.println("...");
		}  else  if  (round  ==20)  {
			System.out.println("Don't  you  get  tired  of  fighting?");
		}  else  if  (round  ==  30)  {
			System.out.println("Have  you  thought  about  what  outside  is  like?");
		}  else  if(round  ==  40)  {
			System.out.println("I  recommend  leaving  soon.");
		}else  if(round==50)  {
			System.out.println("I  warned  you");
			break;
		}
		
		}//////////*****************************************************************************************************************************************
		
	}
}