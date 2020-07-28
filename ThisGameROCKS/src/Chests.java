import java.util.ArrayList;

import item_package.Armor;
import item_package.Armors;
import item_package.Helmets;
import item_package.Weapon;
import item_package.Weapons;

public class Chests 
{
	
	public static ArrayList<Integer> chestsLooted = new ArrayList<Integer>();
	
	
	//fill map zone with chests
	public static ArrayList<int[]> getChestsByID(int zone) 
	{
		ArrayList<int[]> chests = new ArrayList<int[]>();
		int[]chest1 = new int[4];
		
		switch(zone)
		{// index of map, id of chest, chest location(y,x)
		case 1: chest1[0] = 1; 	chest1[1] = 1; chest1[2] = 4; chest1[3] = 2; // index of map, id of chest, chest location(y,x)
		        chests.add(chest1);  
		        break;
		case 2:
			chest1[0] = 2; 	chest1[1] = 2; chest1[2] = 4; chest1[3] = 3;
		     	chests.add(chest1); 
		        break;
		case 0:
			chest1[0] = 3; 	chest1[1] = 3; chest1[2] = 4; chest1[3] = 3; // y, x
		     	chests.add(chest1); 
		        break;
//18051322O
		        //offedner 14017697L
	}//160767
		return chests;
	}
	
	//a player picks up contents of chest by chestId
	public static void getLootByChestId(Player player, int chestId) 
	{
		switch(chestId) 
		{ 
		case 1 : if( addLootedChest(chestId)) { System.out.println("chest 1"); player.setGold(player.getGold() + 10);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 1));
		player.addItem(Armors.getArmorById(new Armor(), 2)); player.addItem(Armors.getArmorById(new Armor(), 3)); player.addItem(Armors.getArmorById(new Armor(), 4)); player.addItem(Armors.getArmorById(new Armor(), 5)); 
		player.addItem(Armors.getArmorById(new Armor(), 6)); player.addItem(Armors.getArmorById(new Armor(), 7));  player.addItem(Armors.getArmorById(new Armor(), 8));
		
		
		player.addItem(Helmets.getHelmetById(new Armor(), 1));
		player.addItem(Helmets.getHelmetById(new Armor(), 2)); player.addItem(Helmets.getHelmetById(new Armor(), 3));};
		player.addItem(Weapons.getWeaponById(new Weapon(), 1));	player.addItem(Weapons.getWeaponById(new Weapon(), 2)); 	player.addItem(Weapons.getWeaponById(new Weapon(), 3)); //add weapon here  
	//	case 1 : addLootedChest(chestId) ? System.out.println("chest 1") : System.out.println("chest 1"); //; System.out.println("chest 1"); player.setGold(player.getGold() + 10);  System.out.println(player.getGold() + " : player gold \n");
		break;
		case 2 : if( addLootedChest(chestId)) { System.out.println("chest 2"); player.setGold(player.getGold() + 20);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 2));};
		break;
		case 3 : if( addLootedChest(chestId)) { System.out.println("chest 3"); player.setGold(player.getGold() + 30);  System.out.println(player.getGold() + " : player gold \n"); player.addItem(Armors.getArmorById(new Armor(), 3));};
		break;
		}
	}
	//player can only pick up chest once
	public static boolean addLootedChest(int chestId)
	{
		if(!chestsLooted.contains(chestId)) {
			chestsLooted.add(chestId);
			return true;
		}
		System.out.println(chestId + " : chest ID is already opened");
		return false;
	}
	
}
