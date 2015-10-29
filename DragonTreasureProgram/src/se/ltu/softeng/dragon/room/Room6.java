package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Item.ItemType;
import se.ltu.softeng.dragon.item.Treasure;
import se.ltu.softeng.dragon.monster.Dragon;
import se.ltu.softeng.dragon.monster.Monster;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room6 extends Room{

	public Room6()
	{
		setsRoomName("Room6");
		addNavigationPossibility("w", "west", "Room4");

		
		// adding a monster
		Monster oMonster = new Dragon("Smaug",1);
		addMonster(oMonster);
		
		// adding a treasure
		Treasure oTreasure = new Treasure("Nibelungen treasure", 5000);
		oTreasure.setoNavigationPossibility("p", "picking up " + oTreasure.getsName(), "Room6");
		oTreasure.setsPickingUpMessage("You picked up the treasure");
		oTreasure.setsChangeRoomMessageAfterPickingUp("Now there is no treasure any more in this room");
		addItem(oTreasure);
				
	}
	 
	@Override
	public boolean bMeetEntryConditions(Player oPlayer) {
		if (oPlayer.hasItem(ItemType.KEY))
		{
			return true;
		}
		return false;
	}
	

	/**
	 * Function which gets called from the main game loop
	 */
	@Override
	public String doAction(Player oPlayer) {
		
		if (bMeetEntryConditions(oPlayer) == false)
		{
			RW.writeLine("You need the key to unlock the door");
			return "Room4";
		}
		
		addNavigationPossibilityPlayerItems(oPlayer);
		RW.writeLine(getsRoomWelcomeMessage());	
		
		if (survivedFightAvailableMonsters(oPlayer) == false)
			return "DeathRoom";
		
		String sNextRoom = getNextRoom(oPlayer);
		return sNextRoom;
	}


}