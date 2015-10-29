package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Main;
import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.rw.RW;

/**
 * The Room you enter when you loose a fight
 * @author cm
 *
 */
public class DeathRoom extends Room{
	
	/**
	 * Constructor for this room
	 */
	public DeathRoom()
	{
		
		setsRoomName("DeathRoom");
	}

	/**
	 * Function which gets called from the main game loop
	 */
	@Override
	public String doAction(Player oPlayer) {
		RW.writeLine("You died... Game over");
		Main.setGameOver();
		
		return "DeathRoom";

	}


}
