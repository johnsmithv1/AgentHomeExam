package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Potion;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room4 extends Room{

	/**
	 * Constructor for this room
	 */
	public Room4()
	{
		setsRoomName("Room4");
		addNavigationPossibility("n", "north", "Room3");
		addNavigationPossibility("e", "east", "Room6");
		addNavigationPossibility("w", "west", "Room5");
		
		// adding a Potion
		Potion oPotion = new Potion("Beer",10);
		oPotion.setoNavigationPossibility("p", "picking up health potion lying on the floor.", "Room4", "d", "drinking your health potion" );
		oPotion.setsPickingUpMessage("You picked up the potion");
		oPotion.setsChangeRoomMessageAfterPickingUp("");
		addItem(oPotion);
		
		setsRoomWelcomeMessage("You see a health potion on the floor.");
		
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
