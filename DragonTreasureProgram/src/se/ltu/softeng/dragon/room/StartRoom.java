package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class StartRoom extends Room{
	
	/**
	 * Constructor for this room
	 */
	public StartRoom(String sRoomName)
	{
		
		setsRoomName("StartRoom");
		addNavigationPossibility("e", "entering cave to your east.", "Room1");
	}

	/**
	 * Function which gets called from the main game loop
	 */
	@Override
	public String doAction(Player oPlayer) {
		addNavigationPossibilityPlayerItems(oPlayer);
		
		RW.writeLine("Welcome " + oPlayer.getsName() + " to your treasure hunt. Beware of the dragon!");
		RW.writeLine("You are standing outside a cave. There is a smell of sulfur coming from the opening");
		String sNextRoom = getNextRoom(oPlayer);
		RW.writeLine("As you enter the cave the entrance collapses behind you.");
		
		return sNextRoom;

	}

}
