package se.ltu.softeng.dragon.room;

import se.ltu.softeng.dragon.Main;
import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Item.ItemType;

import se.ltu.softeng.dragon.rw.RW;

/**
 * The last room of the game which shows you how good you have played
 * @author cm
 *
 */
public class EndRoom extends Room{

	/**
	 * Constructor for this room
	 */
	public EndRoom()
	{
		setsRoomName("EndRoom");
				
	}
	
	/**
	 * Function which gets called from the main game loop
	 */
	@Override
	public String doAction(Player oPlayer) {
		
		if (bMeetEntryConditions(oPlayer) == false)
		{
			return "StartRoom";
		}

		if (oPlayer.hasItem(ItemType.TREASURE))
		{
			RW.writeLine(
							"                            _.--.\n"+
							"                        _.-'_:-'||\n"+
							"                    _.-'_.-::::'||\n"+
							"               _.-:'_.-::::::'  ||\n"+
							"             .'`-.-:::::::'     ||\n"+
							"            /.'`;|:::::::'      ||_\n"+
							"           ||   ||::::::'     _.;._'-._\n"+
							"           ||   ||:::::'  _.-!oo @.!-._'-.\n"+
							"           \'.  ||:::::.-!()oo @!()@.-'_.|\n"+
							"            '.'-;|:.-'.&$@.& ()$%-'o.'\\U||\n"+
							"              `>'-.!@%()@'@_%-'_.-o _.|'||\n"+
							"               ||-._'-.@.-'_.-' _.-o  |'||\n"+
							"               ||=[ '-._.-\\U/.-'    o |'||\n"+
							"               || '-.]=|| |'|      o  |'||\n"+
							"               ||      || |'|        _| ';\n"+
							"               ||      || |'|    _.-'_.-'\n"+
							"               |'-._   || |'|_.-'_.-'\n"+
							"               '-._'-.|| |' `_.-'\n"+
							"                    '-.||_/.-'\n");
			RW.writeLine("You leave the dungeon with your riches. Congratulations, you won");
		}
		else
		{
			RW.writeLine("You coward");
		}
		
		Main.setGameOver();
		return "EndRoom";

	}




}

