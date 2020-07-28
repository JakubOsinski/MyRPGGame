package item_package;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Weapons 
{
	   public final static int WEAPONIDPREFIX = 3;
		
	 	public static Weapon getWeaponById(Weapon weapon, int weaponId) 
		{
			switch(weaponId) 
			{
			case 0: weapon.setItemId(WEAPONIDPREFIX +" " + weaponId);
			weapon.setWeaponId(weaponId); weapon.setWeaponType(WeaponType.FIST); weapon.setWeaponAttack(getWeaponAttackById(weaponId));
			weapon.setItemName("Fists"); weapon.setItemAttsReqs(getWeaponAttsReqById(weaponId));
	        break;
			case 1: weapon.setItemId(WEAPONIDPREFIX +" " + weaponId); weapon.setWeaponId(weaponId); weapon.setWeaponType(WeaponType.SWORD); weapon.setWeaponAttack(getWeaponAttackById(weaponId));
			weapon.setItemName("Short Sword"); weapon.setItemAttsReqs(getWeaponAttsReqById(weaponId));
			break;
			case 2: weapon.setItemId(WEAPONIDPREFIX +" " + weaponId); weapon.setWeaponId(weaponId); weapon.setWeaponType(WeaponType.AXE); weapon.setWeaponAttack(getWeaponAttackById(weaponId));
			weapon.setItemName("Short Axe"); weapon.setItemAttsReqs(getWeaponAttsReqById(weaponId));
			break;
			case 3: weapon.setItemId(WEAPONIDPREFIX +" " + weaponId); weapon.setWeaponId(weaponId); weapon.setWeaponType(WeaponType.BATTLEAXE); weapon.setWeaponAttack(getWeaponAttackById(weaponId));
			weapon.setItemName("Ogre Axe"); weapon.setItemAttsReqs(getWeaponAttsReqById(weaponId));
			break;
			}
			return weapon;
		}
	 	
	 	public static int[] getWeaponAttackById(int weaponId)
	 	{
	 		int[] weaponAttack = new int[3];
	 		switch(weaponId) 
	 		{
	 		case 0: weaponAttack[0] = 5; weaponAttack[1] = 5; weaponAttack[2] = 5;
	 		break;
	 		case 1: weaponAttack[0] = 4; weaponAttack[1] = 16; weaponAttack[2] = 1;// weaponAttack[1] = 1;
	 		break;
	 	case 2: weaponAttack[0] = 51; weaponAttack[1] = 202; weaponAttack[2] = 200;// weaponAttack[1] = 1;
	 	break;
	 	case 3: weaponAttack[0] = 355; weaponAttack[1] = 35; weaponAttack[2] = 45;// weaponAttack[1] = 1;
	 	break;
 		}	
	 		return weaponAttack;
	 	}
	 	
	 	public static HashMap<String, Integer> getWeaponAttsReqById(int weaponId) 
	 	{
	 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();
	 	//	ArrayList<HashMap<String,Integer>> weaponAttsReqs = new ArrayList<HashMap<String,Integer>>();
	 		switch(weaponId) 
	 		{
//	 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
//	 		break;
	 		case 1: attsReq.put("Strength", 1);  attsReq.put("Dexterity", 1);
			break;
	 		case 2: attsReq.put("Strength", 1);  attsReq.put("Dexterity", 1);
			break;
	 		case 3: attsReq.put("Strength", 1);  attsReq.put("Dexterity", 1);
	 		}
	 		return attsReq; 
	 	}
	 	
}
