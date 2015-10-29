package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room1 extends Room {
	
	/**
	 * Constructor for this room
	 */
	public Room1()
	{
		setsRoomName("Room1");
		addNavigationPossibility("n", "north", "Room2");
		addNavigationPossibility("s", "south", "Room5");
		setsRoomWelcomeMessage("The room is lit by a few candles sitting on a table in front of you.");	
	}

	/**
	 * Function which gets called from the main game loop
	 */
	@Override
	public String doAction(Player oPlayer) {
		addNavigationPossibilityPlayerItems(oPlayer);
		RW.writeLine(getsRoomWelcomeMessage());	
		
		if (survivedFightAvailableMonsters(oPlayer) == false)
			return "DeathRoom";
		
		String sNextRoom = getNextRoom(oPlayer);
		return sNextRoom;

	}

	

}
