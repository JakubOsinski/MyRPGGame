package item_package;

import java.util.HashMap;

public class Armors 
{
     private final static int ARMORIDPREFIX = 2;
	
	public static Armor getArmorById(Armor armor, int armorId) 
	{
		switch(armorId) 
		{
		case 0: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(1); armor.setItemName("No Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 1: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(3); armor.setItemName("Cape"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 2: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(5); armor.setItemName("Leather Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 3: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(6); armor.setItemName("Steel Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 4: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(8); armor.setItemName("Scale Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 5: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(9); armor.setItemName("Plate Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 6: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(11); armor.setItemName("Bronze Armor"); armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 7: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(10); armor.setItemName("Royal Armor"); 	armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		case 8: armor.setItemId(ARMORIDPREFIX +" " + armorId); armor.setArmorId(armorId); armor.setArmorDefence(140); armor.setItemName("Metal Armor"); 	armor.setItemAttsReqs(getArmorAttsReqById(armorId));
		break;
		}
		return armor;
	}
	
 	public static HashMap<String, Integer> getArmorAttsReqById(int armorId) 
 	{
 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();

 		switch(armorId) 
 		{
// 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
// 		break;
 		case 1: attsReq.put("Strength", 5);  attsReq.put("Dexterity", 0); 
		break;
 		case 2: attsReq.put("Strength", 5);  attsReq.put("Dexterity", 0);
		break;
 		case 3: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
 		break;
 		case 4: attsReq.put("Strength", 6);  attsReq.put("Dexterity", 0);
		break;
 		case 5: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
		break;
 		case 6: attsReq.put("Strength", 4);  attsReq.put("Dexterity", 0);
 		break; 	
 		case 7: attsReq.put("Strength", 6);  attsReq.put("Dexterity", 0);
 		break; 	
 		case 8: attsReq.put("Strength", 12);  attsReq.put("Dexterity", 0);
 		break; 	
 		}
 		return attsReq; 
 	}

}
