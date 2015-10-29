package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.monster.Beast;
import se.ltu.softeng.dragon.monster.Monster;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room3 extends Room{

	/**
	 * Constructor for this room
	 */
	public Room3()
	{
		setsRoomName("Room3");
		addNavigationPossibility("e", "see an exit to the east", "EndRoom");
		addNavigationPossibility("s", "south", "Room4");
		addNavigationPossibility("w", "west", "Room2");
		
		// adding a monster
		Monster oMonster = new Beast("Fluffy",1);
		addMonster(oMonster);
				
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
