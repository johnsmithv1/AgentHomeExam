package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Key;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room5 extends Room{

	/**
	 * Constructor for this room
	 */
	public Room5()
	{
		setsRoomName("Room5");
		addNavigationPossibility("n", "north", "Room1");
		addNavigationPossibility("e", "east", "Room4");
		
		// adding a key
		Key oKey = new Key("Magick Key");
		oKey.setoNavigationPossibility("p", "picking up a the key lying on the floor.", "Room5");
		oKey.setsPickingUpMessage("You picked up the key");
		oKey.setsChangeRoomMessageAfterPickingUp("You see an empty room");
		addItem(oKey);
		
		setsRoomWelcomeMessage("You see a key laying on the floor");
		
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
