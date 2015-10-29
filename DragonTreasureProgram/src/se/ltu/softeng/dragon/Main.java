package se.ltu.softeng.dragon;

import se.ltu.softeng.dragon.room.Room;
import se.ltu.softeng.dragon.room.RoomManager;
import se.ltu.softeng.dragon.rw.*;

/**
 * Main class for the programm. This class is used for setting up the game and also for the game loop
 * @author cm
 *
 */
public class Main {
	
	private static boolean bGameOver = false;
	
	/**
	 * Entry method of the program
	 * @param argv
	 */
	public static void main(String[] argv)
	{
		RW.writeLine("Welcome to Dragon Treasure Version 2");
		RW.writeLine("Enter your Name");
		String sPlayerName = RW.readLine();
		
		Player oPlayer = new Player(sPlayerName);
		
		RoomManager oRoomManager = new RoomManager();
		Room oActRoom = oRoomManager.getRoom("StartRoom");
		String sNextRoom = "";
		String sActRoom = "";

		// game loop
		while (bGameOver == false)
		{
			sActRoom =  oActRoom.getsRoomName();
			
			// call the doAction method of one room and use the return String for the next room
			sNextRoom = oActRoom.doAction(oPlayer);
			
			if (sNextRoom == null || sNextRoom.equals(""))
			{
				sNextRoom = sActRoom;
			}

			oActRoom = oRoomManager.getRoom(sNextRoom);
			
			if (oActRoom == null)
			{
				RW.writeLine("There was an error with a non existing Room");
				RW.writeLine("Program will exit now");
				System.exit(1);
			}			
			
		}

	}
	/**
	 * Set the game to GameOver
	 */
	public static void setGameOver()
	{
		bGameOver = true;
	}

}
