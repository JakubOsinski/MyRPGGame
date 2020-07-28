

import java.awt.List;
import java.util.ArrayList;

public class Maps 
{
//	private int [][]mapZonesExit1;
//	private static ArrayList<int[][]> z1;
	
	public Maps(int zone) 
	{
	
		InitializeMaps(zone);
	}
	
	public void InitializeMaps(int zone) 
	{
//		int x = 4; int y = 1;
//		int[] []map1 = new int[x][y]; //second is rows\/ 
//		int[] []map2 = new int[x][y]; 
//	//	checkTestMap(map1, x,y);
//		map1[0][0] = 1; 	map1[1][0] = y+1; map1[2][0] = 2; map1[3][0] = 3; // index of map, what index heading to?, entrance location x, entrance location y
//		map2[0][0] = 1; 	map2[1][0] = y-1; map2[2][0] = 1; map2[3][0] = 0;
//		z1.add(map1); 
//		z1.add(map2);
//	//	checkTestMap(map1, x,y);
//	//	checkTestMap(map2, x,y);
		//	fieldMap[enterExitZones.get(i)[2][0]][enterExitZones.get(i)[3][0]].setLetter(Letter.E);
	}
	
	public static void testMaps() 
	{
		
	}
	

	
public static void checkTestMap(int[][] map, int x, int y) //x and y of array
{
	System.out.println();
	for(int i = 0; i < 1;i++) 
	{
		for(int j = 0; j < 3;j++) {
			System.out.print("[" + map[j][i] + "] "); // check map
		}
	}
}

public static int[] getMapSizeByIndex(int nextZoneI) 
{
	int []mapSize = new int[2];
	switch(nextZoneI)
	{
	case 0: mapSize[0] = 7;  mapSize[1] = 7; 
	break;
	case 1: mapSize[0] = 5;  mapSize[1] = 5; 
	break;
	case 2: mapSize[0] = 8;  mapSize[1] = 8; 
	break;
	}
	return mapSize;
}



//public static void getLoot(int chestId)
//{
//	String loot;
//	switch(chestId)
//	{
//	case 1: loot ="1";
//		break;
//	case 2: loot ="2";
//	break;
//	case 3: loot ="3";
//	break;
//	}
//}

public static ArrayList<int[][]> getZoneExitsByID(int zone) 
{
	int []kd = {1,2};
	int x = 4; int y = 1;
	int[] []map1 = new int[x][y]; //second is rows\/ 
	int[] []map2 = new int[x][y]; 
	int size = 0;
	ArrayList<int[][]> zoneExits = new ArrayList<int[][]>();

	switch(zone)
	{
	case 1: map1[0][0] = 1; 	map1[1][0] = 2; map1[2][0] = 2; map1[3][0] = 4; // index of map, what index heading to?, y,x
	        map2[0][0] = 1; 	map2[1][0] = 0; map2[2][0] = 2; map2[3][0] = 0; // y,x
	        zoneExits.add(map1); 
	    	zoneExits.add(map2);
	        break;
	case 2:
	     	map1[0][0] = 2; 	map1[1][0] = 1; map1[2][0] = 3; map1[3][0] = 6;
	     	zoneExits.add(map1); 
	        break;
	
  case 0:
 //	map1[0][0] = 0; 	map1[1][0] = 1; map1[2][0] = 3; map1[3][0] = 5;
	  map1[0][0] = 0; 	map1[1][0] = 1; map1[2][0] = 3; map1[3][0] = 6;
 	zoneExits.add(map1); 
    break;
}
	return zoneExits;
}

public static int[] getNewZonePlayerPos(int[] playerExitPos, int[]lastMapSize, int[] newMapSize) 
//public static int[] getNewZonePlayerPos(int[] playerExitPos, int[] newMapSize) 
{
	int []newPlayerPos = new int[2];
	newPlayerPos = playerExitPos;
    //X
	if(playerExitPos[0] == 0) 
	{
		newPlayerPos[0] = (newMapSize[0]-1); 
	} else if (playerExitPos[0] == lastMapSize[0]-1) 
	{
		newPlayerPos[0] = 0;
	}  else {
		System.out.println(" playa exit pos X :" + playerExitPos[0]);
		System.out.println(" playa exit pos X :" + playerExitPos[0]);
		System.out.println(" playa exit pos X :" + playerExitPos[0]);
	}
	//Y
	if(playerExitPos[1] == 0)  
	{
		newPlayerPos[1] = (newMapSize[1]-1); 
	}else if (playerExitPos[0] == lastMapSize[0]-1) 
	{
		newPlayerPos[1] = 0;
	} else {
		System.out.println(" playa exit pos Y :" + playerExitPos[1]);
		System.out.println(" playa exit pos Y :" + playerExitPos[1]);
		System.out.println(" playa exit pos Y :" + playerExitPos[1]);
	}
	return newPlayerPos;
}


}
