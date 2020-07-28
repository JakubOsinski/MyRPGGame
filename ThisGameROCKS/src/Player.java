
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import item_package.Armor;
import item_package.Armors;
import item_package.Helmets;
import item_package.Item;
import item_package.Weapon;
import item_package.WeaponType;
import item_package.Weapons;

/*
 * Endurance, Intelligence, Strength, Dexterity will be 4 main attributes in my game
endurance = max health + little bonus to defence
intelligence = mana + spell power
strength = physical damage bonus + armor/weapon requirements
dex = dodge + (accuracy? maybe?) + some weapon requirements
 */

public class Player
{
	//ArrayList<Unit> units;
	//ArrayList<Item> items;
	private int[] position;
	private Letter letter;
	private int[] screenRadius;
//	private Item[] inventory;
	private ArrayList<Item> inventory;
	private Item [] eq;
	
	private int gold = 0;
	private int[] playerAttributes; // Endurance, Intelligence, Strength, Dexterity, Luck
	HashMap<String, Integer> playerAttributes1; // Endurance, Intelligence, Strength, Dexterity, Luck
//	private ArrayList<Integer> playerStats; // max health, max mana, initiative, spell power, avoid, defence? accuracy?
	HashMap<String, Integer> playerStats;
	/**
	 * starting Endurance, Intelligence, Strength, Dexterity, Luck stats of player at level 1
	 */
	public final int[] initialPlayerAttributes= {2,2,2,2,2};
	private ArrayList<Integer> playerInfo; // level, current health, current mana, current initiative, current everything I guess?
	private ArrayList<Integer> playerGeneral; // level, current exp, exp to nxt lvl
	
	/**
	 * Starting player at level 1
	 */
	public Player(int[] position, Letter letter, int[] screenRadius) 
	{
		this.position = position;
		this.letter = letter;
		this.screenRadius = screenRadius;
		
		inventory = new ArrayList<Item>();
		eq = new Item[4]; // helmet, armour, weapon, ring
		
		playerAttributes = initialPlayerAttributes;

		playerStats = new HashMap<String, Integer>();
		playerAttributes1 = new HashMap<String, Integer>();
		playerInfo = new ArrayList<Integer>();
		playerGeneral =  new ArrayList<Integer>();
		
		fillInitialPlayerThings(); // level 1

	}
	/**
	 * Fully parameterized player
	 * Starting player at level 1
	 * @param position array with 2 ints representing the player coordinates on the map, index 0 = Y, index 1 = X.
	 * @param letter letter representing player on the map
	 * @param screenRadius array representing how far player can see on the map
	 * @param gold total player gold
	 * @param playerAttributes Endurance, Intelligence, Strength, Dexterity, Luck
	 * @param playerStats max health, max mana, initiative, spell power, dodge bonus, defence, accuracy
	 * @param inventory all player items
	 * @param current equipment being used by player
	 */
	public Player(int[] position, Letter letter, int[] screenRadius, int gold, int[] playerAttributes, HashMap playerStats, ArrayList<Item>inventory, Item[] eq) 
	{
		this.position = position;
		this.letter = letter;
		this.screenRadius = screenRadius;
		this.gold = gold;
		this.playerAttributes = playerAttributes;
		this.playerStats = playerStats;
		this.inventory = inventory;
		this.eq = eq;
	}	
	
	public Player() 
	{
		
	}
	
	/**
	 * Called in constructor when player object gets created. Fills the remaining player variables to default(level 1).
	 */
	public void fillInitialPlayerThings() {
		playerStats.put("Max Health", 50); 	playerStats.put("Max Mana", 20); playerStats.put("Initiative", 10); playerStats.put("Spell Power", 10);
		playerStats.put("Dodge", 10);  playerStats.put("Defence", 10);  playerStats.put("Accuracy", 10); 
		
		updatePlayerAttsMap();
	

		 playerInfo.add(playerStats.get("Max Health")); playerInfo.add(playerStats.get("Max Mana"));
		 playerGeneral.add(1); 	 playerGeneral.add(0);  playerGeneral.add(getExpToNextLVL(playerGeneral.get(0))); // level, current exp, exp req for next lvl
	}
	
	/**
	 * update hashMap playerAttributes1 with current playerAttributes which is int[]
	 * needs to be called every time playerAttributes is changed
	 */ 
	public void updatePlayerAttsMap() {
		playerAttributes1.put("Endurance", playerAttributes[0]);	playerAttributes1.put("Intelligence", playerAttributes[1]);	
		playerAttributes1.put("Strength", playerAttributes[2]);	playerAttributes1.put("Dexterity", playerAttributes[3]);	playerAttributes1.put("Luck", playerAttributes[4]);
	}
	
	/**
	 * How much exp does player require for next level?
	 * @param level = current player level
	 */
	public int getExpToNextLVL(int level) {
		int currentPlayerLevel = level;
		int nextLVLExpReq = 0;
		switch(currentPlayerLevel) 
		{
		case 1: nextLVLExpReq = 100;
		break;
		case 2: nextLVLExpReq = 300;
		break;
		case 3: nextLVLExpReq = 700;
		break;
		case 4: nextLVLExpReq = 2400;
		break;
		}
		return nextLVLExpReq - playerGeneral.get(1);
	}
	/**
	 * add exp to total player exp, update player level if exp conditions are met.
	 * @param exp exp gained from doing action like defeating enemy of completing quest
	 */
	public void addPlayerExp(int exp) 
	{
		int level = playerGeneral.get(0);
		int currentExp =playerGeneral.get(1);
		int expForNextLvl = getExpToNextLVL(playerGeneral.get(2));
	
		
		if(currentExp + exp >=  expForNextLvl) {
			playerGeneral.set(0, level+1);
			playerGeneral.set(1, (currentExp + exp));
			playerGeneral.set(2, getExpToNextLVL(level+1));
		}
	}
	/**
	 * print out player level, current experience, and experience to next level in the console
	 */
	public void showPlayerExp()  
	{
		System.out.println("Player level is : " + playerGeneral.get(0));
		System.out.println("Player Current Exp is : " + playerGeneral.get(1));
		System.out.println("Exp to next Level is : " + playerGeneral.get(2));
	}
	
	//getters and setters
	public void setScreenRadius(int[] screenRadius) 
	{
		this.screenRadius = screenRadius;
	}
	public int[] getScreenRadius() 
	{
		return screenRadius;
	}
	
	public void setPosition(int []position) {
	this.position = position;
}

public int[] getPosition() {
	return position;
}
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	public Letter getLetter() {
		return letter;
	}
////gameplay
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getGold() {
		return gold;
	}
	public void setPlayerAttributes(int []playerAttributes) {
		this.playerAttributes = playerAttributes;
	}
	public int[] getPlayerAttributes() {
		return playerAttributes;
	}
	public void setPlayerAttributes(int index, int n) {
		this.playerAttributes[index] = n;
	}
	
//	public void setPlayerStats(ArrayList<Integer> playerStats) 
//	{
//		this.playerStats = playerStats;
//	}
//	public ArrayList<Integer> getPlayerStats( ) 
	public HashMap<String, Integer> getPlayerStats()
	{
		return playerStats;
	}
	
	public int getPlayerStatsByKey(String key)
	{
		return playerStats.get(key);
	}
	//public void setPlayerStats(int index, Integer val) 
	
/**
 *changes player stats
 *@param key - stat key in the playerStats hash map
 *@param val - new value of stay key in playerStats hashMap
 */
	public void changePlayerStats(String key, int val)  // setPlayerStats
	{
	//	this.playerStats.get(key) = val;
		int newVal = val + this.playerStats.get(key);
		this.playerStats.remove(key);
		playerStats.put(key, newVal);
	}
	
	public ArrayList<Integer> getPlayerInfo() {
		return playerInfo;
	}
	public void setPlayerInfo(ArrayList<Integer> playerInfo) {
		this.playerInfo = playerInfo;
	}
	
////INVENTORY  INVENTORY INVENTORY INVENTORY INVENTORY INVENTORY

//	}
	public void setInventory(ArrayList<Item> inventory) 
	{
		this.inventory = inventory;
	}
	public ArrayList<Item> getInventory() 
	{
		return inventory;
	}
	
	/**
	 * adds type Item item to player inventory whenever player acquires a new item.
	 */
	public void addItem(Item item) 
	{
		inventory.add(item);
	}	
	/**
	 * loop through player inventory and print each item name and id to the console
	 */
	public void checkPlayerInventory() 
	{
		for(int i = 0; i < inventory.size(); i++) 
		{
			System.out.println("Item " + (i+1) + " :" + inventory.get(i).getItemName());
			System.out.println("Item ID : " +inventory.get(i).getItemId());
		}
		System.out.println();
	}
	/**
	 * split each item into subtype (int itemType), then find best piece of equipment for this specific type of e
	 * first split player inventory into categories, weapons, armours, helmets etc. Then based on selected criteria equip this item for player.
	 * criteria = for weapons best total damage is chosen, for armor and helmets highest armour items will be chosen.
	 * equipBestEq() finds specific item types in whole player inventory, then sends all same type items to findBestEqItem() for it to find best item.
	 */
	public void equipBestEq()
	{
	     ArrayList<Item> tempItemStyle = new ArrayList<Item>();
	     int itemType = 1;
	     char itemType1 = (char)(itemType + '0');
	     
	     while(itemType != 5) { // 5 = how many item types there are?
	 for(int i =0; i < inventory.size();i++) 
	 {
		 if(inventory.get(i).getItemId().charAt(0) == itemType1) {
			 tempItemStyle.add(inventory.get(i));
		 }
	 }
	 if(tempItemStyle.size() != 0) {
	eq[itemType-1] = findBestEqItem(itemType, tempItemStyle); //
	 }
	 itemType++; //start looking for next best piece of eq
	 itemType1 = (char)(itemType + '0');
	 tempItemStyle.clear(); 
	}
		
	}
	public void test() {
		{
			System.out.println(inventory.get(inventory.size()-1).getItemName());
		System.out.print("0 : ");	System.out.println(((Weapon)inventory.get(inventory.size()-1)).getWeaponAttack()[0]);
		System.out.print("1 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-1)).getWeaponAttack()[1]);
		System.out.print("2 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-1)).getWeaponAttack()[2]);
			System.out.println("");
		}
		System.out.println(inventory.get(inventory.size()-2).getItemName());
		System.out.print("0 : ");	System.out.println(((Weapon)inventory.get(inventory.size()-2)).getWeaponAttack()[0]);
		System.out.print("1 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-2)).getWeaponAttack()[1]);
		System.out.print("2 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-2)).getWeaponAttack()[2]);
		System.out.println();
		System.out.println(inventory.get(inventory.size()-3).getItemName());
		System.out.print("0 : ");	System.out.println(((Weapon)inventory.get(inventory.size()-3)).getWeaponAttack()[0]);
		System.out.print("1 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-3)).getWeaponAttack()[1]);
		System.out.print("2 : ");		System.out.println(((Weapon)inventory.get(inventory.size()-3)).getWeaponAttack()[2]);
		System.out.println();
	}
	/**
	 *Find strongest item for player to wear out of tempItemStyle which is arrayList of Item with all items with itemType type in playre possession.
	 */
	public Item findBestEqItem(int itemType,   ArrayList<Item> tempItemStyle) 
	{
	//	Item strongestItem = tempItemStyle.get(0);
		Item strongestItem = null;
		int highestArmor = -1;
		
		for(int i =0; i < tempItemStyle.size();i++) 
		{ 
			switch(itemType) 
			{
			case 1:   if(checkItemAttsReqs(tempItemStyle.get(i), 1)) {  if(((Armor)tempItemStyle.get(i)).getArmorDefence() > highestArmor) {strongestItem = tempItemStyle.get(i); highestArmor = ((Armor)tempItemStyle.get(i)).getArmorDefence(); } }
			break;
			case 2:  if(checkItemAttsReqs(tempItemStyle.get(i), 1)) { if(((Armor)tempItemStyle.get(i)).getArmorDefence() > highestArmor) {strongestItem = tempItemStyle.get(i); highestArmor = ((Armor)tempItemStyle.get(i)).getArmorDefence(); } }
			break;
//			case 3: findStrongestWeapon(tempItemStyle);
//			break;
			}
			}
		if(itemType == 3) {
			strongestItem = findStrongestWeapon1(tempItemStyle);
		}
		if(strongestItem == null) 
		{
		//	strongestItem = equipBaseEq(strongestItem, itemType);
		 
		   return equipBaseEq(strongestItem, itemType);
		}
		return strongestItem;
	}
	/**
	 *If no items of this class before were found equip base items, e.g fists for weapon, no helmet/armor for helmet and armor respectively.
	 */
	public Item equipBaseEq(Item baseItem, int itemType) 
	{
		switch(itemType)
		{
		case 1: baseItem = Helmets.getHelmetById(new Armor(), 0);
		break;
		
		case 2: baseItem = Armors.getArmorById(new Armor(), 0);
		break;
		
		case 3: 	baseItem = Weapons.getWeaponById(new Weapon(), 0);
		break;
		}
		
		return baseItem;
	}
	
	// find strongest weapon based on their one strongest attack type from array.
/*
	public Item findStrongestWeapon(ArrayList<Item> tempItemStyle) 
	{// slash, pierce, blunt 
		int [] bestWeaponIndex = {0,0,0}; // index in player weapons,
		Item strongestWeapon = null;
		
		for(int i =0; i < tempItemStyle.size();i++) 
		{
	//		for(int j = 0; j < tempItemStyle.get(i).get)
			for(int j = 0; j < ((Weapon)tempItemStyle.get(i)).getWeaponAttack().length; j++)
			{
//System.out.println(((Weapon)tempItemStyle.get(i)).getWeaponAttack()[j]);
				System.out.println(tempItemStyle.get(i).getItemName() + " : importnt" + " : " + i);
				if(bestWeaponIndex[2] < ((Weapon)tempItemStyle.get(i)).getWeaponAttack()[j]) 
				{
					bestWeaponIndex[2] = ((Weapon)tempItemStyle.get(i)).getWeaponAttack()[j]; // new highest dmg
					bestWeaponIndex[1] = j; // pierce? slash? hack?
					bestWeaponIndex[0] = i; // index
				}
			}
		}
		System.out.println(bestWeaponIndex[0] + " is the strongest weapon");
		System.out.println(bestWeaponIndex[1] + " is the strongest weapon");
		System.out.println(bestWeaponIndex[2] + " is the strongest weapon");
		System.out.println(tempItemStyle.get(bestWeaponIndex[0]).getItemName() + " yo");
		return tempItemStyle.get(bestWeaponIndex[0]);
	}
	*/
//	find strongest weapon based on their one strongest attack type from array.
	/**
	 *Find strongest weapon based on their one strongest attack type from array.
	 */
	public Item findStrongestWeapon1(ArrayList<Item> tempItemStyle)  {
		int [] highestDmgWeaponsIndex = new int[tempItemStyle.size()]; // index in player weapons,
		int strongestWeaponDMGsum = 0;
		Item strongestWeapon = null;
		for(int i =0; i < tempItemStyle.size();i++) 
		{
			for(int j = 0; j < ((Weapon)tempItemStyle.get(i)).getWeaponAttack().length; j++)
			{
			
				highestDmgWeaponsIndex[i] = highestDmgWeaponsIndex[i] + ((Weapon)tempItemStyle.get(i)).getWeaponAttack()[j];
			  
			}
			  if(checkItemAttsReqs(tempItemStyle.get(i), 2))	{//
			if(highestDmgWeaponsIndex[i] > strongestWeaponDMGsum) 
			{
				strongestWeaponDMGsum = highestDmgWeaponsIndex[i];
				strongestWeapon = tempItemStyle.get(i);
			}
			  }
		} 
//		if(strongestWeapon == null ) { 
//		//	findBaseEq();
//			System.out.println("PASPASP[APSAPSDPADPSADPA");
//	//		strongestWeapon = Weapons.getWeaponById(((Weapon)strongestWeapon), 0);
//			strongestWeapon = Weapons.getWeaponById(new Weapon(), 0);
//		}
		return strongestWeapon;
	}	
	
	/**
	 *check if playerAttributes like Strength, Dexterity or level are high enough for player to equip this item.
	 */
	public boolean checkItemAttsReqs(Item item, int itemType) //itemType 1 = armor, itemType 2 = weapon
	{ //returns false if the player does not meet item requirements
		Object[] attsKeyArray  =  playerAttributes1.keySet().toArray();	
		for(int i = 0; i < attsKeyArray.length; i++)
		{
			if(item.getItemAttsReqs().containsKey(attsKeyArray[i])) {
				
				if(item.getItemAttsReqs().get(attsKeyArray[i]) > this.playerAttributes1.get(attsKeyArray[i])) {
				return false;	
				}	
			}
		}
//		for(int i = 0; i < attsKeyArray.length; i++)
//		{
//		       int valOfStrength = item.getItemAttsReqs().get("Strength");
//		       int valOfStrength22 = this.playerAttributes1.get("Strength");
//		}
		return true;
	}
	
	/**
	 *Print current eq of player to the console
	 */
	public void checkPlayerEq() 
	{//check player eq. if no item equipped, equip standard eq. fist for weapon, naked for armors(0 armor)
	
		System.out.println("Player EQ");
		System.out.println( "Helmet Def : " + ((Armor)eq[0]).getArmorDefence() );
	
	//	System.out.println( "necklece Def : " + ((Armor)eq[1]).getArmorDefence() );
		System.out.println( "Armor Def : " + ((Armor)eq[1]).getArmorDefence() );
		
		System.out.println( "Strongest weapon name  : " + eq[2].getItemName());
		System.out.println( "Strongest weapon Slash : " + ((Weapon)eq[2]).getWeaponAttack()[0] );
		System.out.println( "Strongest weapon Pierce : " + ((Weapon)eq[2]).getWeaponAttack()[1] );
		System.out.println( "Strongest weapon Bash : " + ((Weapon)eq[2]).getWeaponAttack()[2] );	
	}

}
