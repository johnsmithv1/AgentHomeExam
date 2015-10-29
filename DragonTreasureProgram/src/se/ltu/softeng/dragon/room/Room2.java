package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Weapon;
import se.ltu.softeng.dragon.rw.RW;

/**
 * A room which can be used in the game and can have items to pick up and monsters to fight against
 * @author cm
 *
 */
public class Room2 extends Room{

	/**
	 * Constructor for this room
	 */
	public Room2()
	{
		setsRoomName("Room2");
		addNavigationPossibility("e", "east","Room3");
		addNavigationPossibility("s", "south","Room1");
		
		// adding a weapon
		Weapon oWeapon = new Weapon("Excalibur Sword",1);
		oWeapon.setoNavigationPossibility("p", "picking up a sword next to a dead body on the floor","Room2");
		oWeapon.setsPickingUpMessage("You picked up the sword");
		addItem(oWeapon);
		
		setsRoomWelcomeMessage("You see a dead body on the floor.");
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
