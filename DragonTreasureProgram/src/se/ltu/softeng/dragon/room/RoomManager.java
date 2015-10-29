package se.ltu.softeng.dragon.room;

import java.util.HashMap;

/**
 * This class is used for returning rooms to the main game loop.
 * If there is not already an instance of the room, a new instance will be created
 * @author cm
 *
 */
public class RoomManager {
	
	// HashMap containing all room instances
	private HashMap<String,Room> hmRooms;
	
	public RoomManager()
	{
		hmRooms = new HashMap<String,Room>();
	}
	
	/**
	 * Return the room object which belongs to the room name
	 * @param sRoomName name of the room you want to get
	 * @return Room object matchin sRoomName
	 */
	public Room getRoom(String sRoomName)
	{
		Room oDesiredRoom;

		if (sRoomName == null)
			oDesiredRoom = null;
		
		oDesiredRoom = hmRooms.get(sRoomName);
		
		// if room is not existing alread
		if (oDesiredRoom == null)
		{
			if (sRoomName.equalsIgnoreCase("StartRoom"))
			{
				oDesiredRoom = new StartRoom("StartRoom");
			}
			else if (sRoomName.equalsIgnoreCase("EndRoom"))
			{
				oDesiredRoom = new EndRoom();
			}
			else if (sRoomName.equalsIgnoreCase("DeathRoom"))
			{
				oDesiredRoom = new DeathRoom();
			}
			else if (sRoomName.equalsIgnoreCase("Room1"))
			{
				oDesiredRoom = new Room1();
			}
			else if (sRoomName.equalsIgnoreCase("Room2"))
			{
				oDesiredRoom = new Room2();
			}
			else if (sRoomName.equalsIgnoreCase("Room3"))
			{
				oDesiredRoom = new Room3();
			}
			else if (sRoomName.equalsIgnoreCase("Room4"))
			{
				oDesiredRoom = new Room4();
			}
			else if (sRoomName.equalsIgnoreCase("Room5"))
			{
				oDesiredRoom = new Room5();
			}
			else if (sRoomName.equalsIgnoreCase("Room6"))
			{
				oDesiredRoom = new Room6();
			}

			hmRooms.put(sRoomName, oDesiredRoom);

		}
		
		return oDesiredRoom;
			
	}


}
