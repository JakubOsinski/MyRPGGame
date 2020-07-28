package item_package;

import java.util.HashMap;

public class Helmets 
{
     private final static int ARMORIDPREFIX = 1;
	
 	public static Armor getHelmetById(Armor helmet, int helmetId) 
	{
		switch(helmetId) 
		{
		case 0:
		 helmet.setItemId(ARMORIDPREFIX +" " + helmetId); helmet.setArmorId(helmetId); helmet.setArmorDefence(1); helmet.setItemName("No Helmet");
			helmet.setItemAttsReqs(getHelmetAttsReqById(helmetId));
		
		break;
		case 1: helmet.setItemId(ARMORIDPREFIX +" " + helmetId); helmet.setArmorId(helmetId); helmet.setArmorDefence(20); helmet.setItemName("Knight Helmet");
		helmet.setItemAttsReqs(getHelmetAttsReqById(helmetId));
		break;
		case 2: helmet.setItemId(ARMORIDPREFIX +" " + helmetId); helmet.setArmorId(helmetId); helmet.setArmorDefence(22); helmet.setItemName("Viking Helmet");
		helmet.setItemAttsReqs(getHelmetAttsReqById(helmetId));
		break;
		case 3: helmet.setItemId(ARMORIDPREFIX +" " + helmetId); helmet.setArmorId(helmetId); helmet.setArmorDefence(8); helmet.setItemName("Steel Helmet");
		helmet.setItemAttsReqs(getHelmetAttsReqById(helmetId));
		break;
		}
		return helmet;
	}
 	
 	public static HashMap<String, Integer> getHelmetAttsReqById(int helmetId) 
 	{
 		HashMap<String, Integer> attsReq = new HashMap<String, Integer>();

 		switch(helmetId) 
 		{
// 		case 0: attsReq.put("Strength", 0);  attsReq.put("Dexterity", 0);
// 		break;
 		case 1: attsReq.put("Strength", 5);  attsReq.put("Dexterity", 0);
		break;
 		case 2: attsReq.put("Strength", 3);  attsReq.put("Dexterity", 0);
		break;
 		case 3: attsReq.put("Strength", 3);  attsReq.put("Dexterity", 0);
 		}
 		return attsReq; 
 	}
 	
}