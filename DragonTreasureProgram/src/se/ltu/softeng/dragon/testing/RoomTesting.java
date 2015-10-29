package se.ltu.softeng.dragon.testing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Item.ItemType;
import se.ltu.softeng.dragon.room.Room;
import se.ltu.softeng.dragon.room.RoomManager;
import se.ltu.softeng.dragon.rw.RW;

/**
 * Class for testing a game walk through with jUnit
 * @author cm
 *
 */
public class RoomTesting {
	
	private static Player oPlayer;
	private static RoomManager oRoomManager;
	private static Room oActRoom;
	private static String sNextRoom;
	
	/**
	 * Method called before tests start
	 * @throws Exception
	 */
	 @BeforeClass
	    public static void setUpClass() throws Exception {
		 RW.setbJunit(true);
		 oPlayer = new Player("TestPlayer");
		 oRoomManager = new RoomManager();
		 oActRoom = oRoomManager.getRoom("StartRoom");
		 
	 }

	 /**
	  * Test a complete walkthrough
	  */
	@Test
	public void GameWalkThrough() {
		
		// StartRoom
		RW.setsJunitInput("e");
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(RW.getsJunitOutput().equals("As you enter the cave the entrance collapses behind you."));

		// Room1
		RW.setsJunitInput("s");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room1"));
		
		// Room 5
		RW.setsJunitInput("p");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room5"));
		assertTrue(RW.getsJunitOutput().equals("You picked up the key"));
		assertTrue(oPlayer.getItemOfType(ItemType.KEY).size() >= 1);

		
		RW.setsJunitInput("n");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room5"));
		
		// Room1
		RW.setsJunitInput("n");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room1"));
		
		// Room2
		RW.setsJunitInput("p");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room2"));
		assertTrue(oPlayer.getItemOfType(ItemType.WEAPON).size() >= 1);
		
		// Room3
		RW.setsJunitInput("s");
		oActRoom = oRoomManager.getRoom("Room3");
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room3"));
		assertTrue(oPlayer.getiHealth() < oPlayer.getiMaxHealth());
		
		
		// Room4
		RW.setsJunitInput("p");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room4"));
		assertTrue(oPlayer.getItemOfType(ItemType.POTION).size() >= 1);
		
		RW.setsJunitInput("d");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room4"));
		assertTrue(oPlayer.getItemOfType(ItemType.POTION).size() <= 1);
		
		RW.setsJunitInput("e");
		oActRoom = oRoomManager.getRoom("Room4");
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room4"));
		
		// Room 6
		RW.setsJunitInput("p");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room6"));
		assertTrue(oPlayer.getiHealth() < oPlayer.getiMaxHealth());

		
		RW.setsJunitInput("w");
		oActRoom = oRoomManager.getRoom("Room6");
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room6"));
		
		// Room 4
		RW.setsJunitInput("n");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room4"));
		
		// Room 3
		RW.setsJunitInput("e");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("Room3"));
		
		// EndRoom
		RW.setsJunitInput("xyz");
		oActRoom = oRoomManager.getRoom(sNextRoom);
		sNextRoom = oActRoom.doAction(oPlayer);
		assertTrue(oActRoom.getsRoomName().equals("EndRoom"));
		assertTrue(oPlayer.getItemOfType(ItemType.TREASURE).size() >= 1);
		
	}
	
}
