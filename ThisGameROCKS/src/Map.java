import java.util.ArrayList;
/**
 * The game takes place on map. entering specific coordinates in a map triggers action like battle, chest pick up or enter/exit to new map(zone)
 * Map is represented as 2d array of Strings and its elements are represented by letters. C = chest, P = Player, X = empty space, E = previous/next map
 * @author Jakub
 */
public class Map
{
	/**
	 * fieldMap[][] is the player's current map
	 */
	private Field fieldMap[][];
	
	private int mapIndex;
	private int [] mapSize;
	private ArrayList<int[][]> mapExits;
	private ArrayList<int[]> mapChests;

	/**
	 * Each map zone and its elements is set up in the Maps class.
	 * pass the zone int to the Map constructor in order to create new map zone by pulling details from the Maps class.
	 */
	public Map(int zone) 
	{
		this.mapIndex = zone;
		this.mapSize = Maps.getMapSizeByIndex(zone);
		this.mapExits = Maps.getZoneExitsByID(zone);
		this.mapChests = Chests.getChestsByID(zone);
		
		fieldMap = new Field[mapSize[0]][mapSize[1]];
		fillMap(Letter.X, mapExits, mapChests);
	}
//start Map getters and setters
	public Field[][] getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(Field[][] fieldMap) {
		this.fieldMap = fieldMap;
	}

	public int getMapIndex() {
		return mapIndex;
	}

	public void setMapIndex(int mapIndex) {
		this.mapIndex = mapIndex;
	}
	public int[] getMapSize() {
		return mapSize;
	}

	public void setMapSize(int []mapSize) {
		this.mapSize = mapSize;
	}
	public ArrayList<int[][]> getMapExits() {
		return mapExits;
	}
	public void setMapExits(ArrayList<int[][]> mapExits) {
		this.mapExits = mapExits;
	}
	//end Map getters and setters
	
	/**
	 * out.println() the current map the player is in to the console
	 */
	public void checkMap() {
	//	if (player {) td
	//	checkPlayerMap1(); td
		System.out.println("checkMap called\n");
		for(int i = 0; i < fieldMap.length;i++) 
		{
			for(int j = 0; j < fieldMap.length;j++) {
				System.out.print(fieldMap[i][j].getLetter() + " "); // check map
		//		System.out.print(":" + fieldMap[i][j].getIndex()+ " ");// check index
			}
			System.out.println();
		}
	}
	/**fill adventure map with action elements like chests, exits, NPCs and monsters
	 * 
	 * @param letter fill the whole map with this letter initially,  blank space is represented by X
	 * @param enterExitZones if the map contains EXIT ZONES, place them on the map by changing from letter X to E
	 * @param chests if the map contains TRESURE CHESTS, place them on the map by changing from letter C to E
	 */
	public void fillMap(Letter letter, ArrayList<int[][]> enterExitZones, ArrayList<int[]> chests) {
		fillMap(letter, enterExitZones);
		for(int i = 0; i < chests.size(); i++) 
		{
			fieldMap[chests.get(i)[2]][chests.get(i)[3]].setLetter(Letter.C);
		}
	}
	
	public void fillMap(Letter letter, ArrayList<int[][]> enterExitZones) {
		fillMap(letter);
		for(int i = 0; i < enterExitZones.size(); i++)
		{
			fieldMap[enterExitZones.get(i)[2][0]][enterExitZones.get(i)[3][0]].setLetter(Letter.E);
		}
	}
	
	
	public void fillMap(Letter l) 
	{
		int index = 0;
			for(int i = 0; i < fieldMap.length;i++)
			{
				for(int j = 0; j < fieldMap.length;j++)
				{
					fieldMap[i][j] = new Field(index, Letter.X);
					index++;
				}
			}	
	}
	
	
	/**
	 *position player on the map and check if he is interacting with any object after successful movement.
	 */
	public void positionPlayer(Player player) 
	{
             int []pPos = player.getPosition();
     //        System.out.println("player letter " + player.getLetter() + " : Y :" + pPos[0] + " : X : " +pPos[1]);
             
             if(pPos[0] >= mapSize[0]) 
             {//so it doesn't go out of bounds after transition
            	 pPos[0] = mapSize[0]-1;
             }
             if(pPos[1] >= mapSize[1]) 
             {
            	 pPos[1] = mapSize[1]-1;
             }
             
		fieldMap[pPos[0]][pPos[1]].setLetter(player.getLetter()); // position in map becomes player
	}

	/**
	 *player changes position, after the move check if player is interacting with any action fields and if so take according action in regard to what field the player is on.
	 * This is main way in which the player moves around the map. 
	 * @param player
	 * @param move 1 = go up 1 index in 2d array = Y=Y-1-;. 2 = down = Y=Y+1;; 3 = right = X=X+1; 4 = left = X=X-1;
	 */
	public void movePlayer(Player player, int move) 
	{
		System.out.println();
		boolean moved = false;
		String moveFailMsg = "";
		int[] pPos = player.getPosition();
		int []oldPlayerPos = {pPos[0],pPos[1]};
		if(pPos[0] >= mapSize[0] || pPos[1] >= mapSize[1]) 
		{
			System.out.println("movePlayer() potential error : playerPosition is out of map size");
			return;
	//	return false;	
		} 
	//	fieldMap[pPos[0]][pPos[1]].setLetter(Letter.X);
		//if player can move in desired direction, move to this position.
		switch(move) 
		{
	//	case 1: if(index - 4 > 0) { playerCoordinates[0]--; } // up   index = index-4; 
		case 1: if(pPos[0] > 0) { pPos[0]--; moved = true;} else { moveFailMsg = "can't go up";  } // up   index = index-4; 
		break;
	//	case 2: if(index + 4 < 16) {playerCoordinates[0]++; } // down
		case 2: if(pPos[0] < (mapSize[0] -1))   { pPos[0]++; moved = true;} else { moveFailMsg = "can't go down";  }
		break;
		case 3: if(pPos[1] < (mapSize[1] -1)) { pPos[1]++; moved = true; }  else { moveFailMsg = "can't go right";  } // right
		break;
		case 4: if(pPos[1] > 0) { pPos[1]--; moved = true;} else { moveFailMsg = "can't go left";  } // left
		break;
		}
		
		
		 // check for player interaction with elements
			boolean transition = false;
			transition = checkTransition(player);
			boolean chestPickup = false;
			chestPickup = checkChest(player);


			positionPlayer(player);
		if(moved) {
		
		if(!transition)	{
	for(int i =0; i < mapExits.size(); i++) 
	{ //
		if(mapExits.get(i)[2][0] == oldPlayerPos[0] && mapExits.get(i)[3][0] == oldPlayerPos[1]) 
		{
		
			fieldMap[oldPlayerPos[0]][oldPlayerPos[1]].setLetter(Letter.E);
		
			i =  mapExits.size();//finish after exit letter is set
		} else {
			fieldMap[oldPlayerPos[0]][oldPlayerPos[1]].setLetter(Letter.X);
		}
	}

	//so the C doesn't get deleted after player goes on it[taking it might delete it tho]
	for(int j =0; j < mapChests.size(); j++) 
	{ //
		if(mapChests.get(j)[2] == oldPlayerPos[0] && mapChests.get(j)[3] == oldPlayerPos[1]) 
		{
			fieldMap[oldPlayerPos[0]][oldPlayerPos[1]].setLetter(Letter.C);
	
			j =  mapChests.size();//finish after exit letter is set
		} else {
		}
	}
	
		} 
	}else {
		System.out.println(moveFailMsg);
	}
	}
	
	/**
	 *Check if player coordinates equal to zone exit coordinates of current map, if so and other conditions are met, the player enters new zone via enterNewZone
	 */
	public boolean checkTransition(Player player) {
		for(int i = 0; i < mapExits.size(); i++) 
		{
			System.out.println("mapIndex :  " + mapIndex);
			if(mapExits.get(i)[0][0] == mapIndex) 
			{
		//		System.out.println("currentZone = enterExitZones.get(i)[0][0]" +  " :::" + currentZone);
                if(player.getPosition()[0] == mapExits.get(i)[2][0] && player.getPosition()[1] == mapExits.get(i)[3][0]) {
                	System.out.println("player is on exit");
                	int []previousEntraceIndex = {player.getPosition()[0],player.getPosition()[1]};
                	enterNewZone(mapIndex, mapExits.get(i)[1][0],previousEntraceIndex, player);
                	return true;
                }
			}
		}
		return false;
	}

	/**
	 *Position player accordingly in the new zone, fill the map with elements(chests, monsters, exits) based on new zone index
	 * @param currentMapIndex last map index
	 * @param nextMapIndex new zone index, load the map based on this int.
	 * @param previousEntraceIndex what coordinates was the player on before he entered new zone?
	 * @param player position player in the new zone accordingly to his coordinates in last map zone
	 */
	private void enterNewZone(int currentMapIndex, int nextMapIndex, int[] previousEntraceIndex, Player player) 
	{
		System.out.println(nextMapIndex + " next map index");
		this.mapIndex = nextMapIndex;
		int []newMapSize = Maps.getMapSizeByIndex(nextMapIndex);
		this.mapSize = newMapSize;
		
		this.mapExits = Maps.getZoneExitsByID(nextMapIndex);
		this.mapChests = Chests.getChestsByID(nextMapIndex);
		fieldMap = new Field[mapSize[0]][mapSize[1]];
		fillMap(Letter.X, mapExits, mapChests);
		
		System.out.println(currentMapIndex + ": currentMapIndex");
		System.out.println(nextMapIndex + ":  nextMapIndex");
		System.out.println(mapIndex + ":  mapIndex");
		
	int playerPosAfterExit[] =	getTransitionPlayerPos(player, Maps.getMapSizeByIndex(currentMapIndex));
	player.setPosition(playerPosAfterExit);
	}
	
	/**
	 * if the exit zone in last map was located in right corner, the player position enters new zone on the left side, entering from Y index 0(top of the map)
	 * would mean the player is positioned at new map size -1(bottom) coordinate Y
	 */
	public int[] getTransitionPlayerPos(Player player, int []lastMapSize) 
	{
		int []newPlayerPos = new int[2];
		int []playerExitPos = new int[2];
	
		playerExitPos = player.getPosition();
		System.out.println(playerExitPos[0] + " Y");	
		System.out.println(playerExitPos[1] + " X");	

	    //Y
		if(playerExitPos[0] == 0) 
		{
			newPlayerPos[0] = (mapSize[0]-1); 
		} else if (playerExitPos[0] == lastMapSize[0]-1) 
		{
			newPlayerPos[0] = 0;
		}  else {
			System.out.println(" playa exit pos Y :" + playerExitPos[0]);
			newPlayerPos[0] = 	playerExitPos[0];
		}
		//X
		if(playerExitPos[1] == 0)  
		{
			newPlayerPos[1] = (mapSize[1]-1); 
		}else if (playerExitPos[1] == lastMapSize[1]-1) 
		{
			newPlayerPos[1] = 0;
		} else {
			System.out.println(" playa exit pos X :" + playerExitPos[1]);
			newPlayerPos[1] = 	playerExitPos[1];
		}
	return newPlayerPos;
	}
	
	/**
	 *check if player position equals position of a chest, if so and chest wasn't picked before - player gains its contents
	 */
	public boolean checkChest(Player player) {
		for(int i =0; i< mapChests.size(); i++)
		{
			if(player.getPosition()[0] == mapChests.get(i)[2] && player.getPosition()[1] == mapChests.get(i)[3] ) 
			{
				Chests.getLootByChestId(player, mapChests.get(i)[1]);
			//	}
			}
		}
		return false;
	}
	

}