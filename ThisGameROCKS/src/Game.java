import java.util.Date;
/**
 * This is my rough code for 2d RPG game. There is no user interface yet. Currently game is based on calling methods in Map and Player class.
 * @author Jakub
 */
public class Game 
{
	public int moves;
	public int movesLimit;
	private int [] gameDetails;
	
	

	/**
	 * gameDetails is param passed from the main class and contains zone index of initial map.
	 */
	public Game(int[] gameDetails) 
	{
		this.gameDetails = gameDetails;
		int []pScreenRadius = {2,2};
		
		Map map = new Map(gameDetails[0]);
		map.checkMap();
		
		int []playerPosition = {2,2}; 
		Player player = new Player(playerPosition, Letter.P, pScreenRadius);	
		   map.positionPlayer(player); // create player
		   ////1 up, 2 down, 3 right , 4 left
		   map.checkMap();
		   
		   map.movePlayer(player, 2);
		   map.checkMap();
		   map.movePlayer(player, 2);
		   map.checkMap();
		   map.movePlayer(player, 4);
		   map.checkMap();
		   map.movePlayer(player, 4);
		   map.checkMap();
		   map.movePlayer(player, 1);
		   map.checkMap();
		   map.movePlayer(player, 1);
		   map.checkMap();
		   
		   map.movePlayer(player, 1);
		   map.checkMap();
		   map.movePlayer(player, 4);
		   map.checkMap();
		   map.movePlayer(player, 4);
		   map.checkMap();
	
		   
      //     player.checkPlayerInventory();
           player.equipBestEq();
           player.checkPlayerEq();
           System.out.println();
          player.addPlayerExp(120);
         player.showPlayerExp();
         player.addPlayerExp(520);
         player.showPlayerExp();
         System.out.println();
         player.addPlayerExp(60);
         player.showPlayerExp();
	
//         Date date = new Date();
//         //This method returns the time in millis
//         long timeMilli = date.getTime();
//         System.out.println("Time in milliseconds using Date class: " + timeMilli);
         
	}
		
	public static void main(String [] args)
	{
		int []gameDetails = {1,1,1,1}; //first zone index, 
		Game g = new Game(gameDetails);
	}
}
