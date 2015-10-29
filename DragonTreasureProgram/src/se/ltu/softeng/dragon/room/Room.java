package se.ltu.softeng.dragon.room;

import java.util.ArrayList;
import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.fight.Fight;
import se.ltu.softeng.dragon.rw.RW;
import se.ltu.softeng.dragon.item.*;
import se.ltu.softeng.dragon.monster.*;

/**
 * Class which gets extended by all rooms
 * A room has different NavigationPossibilities, items lying around and also monsters which want to attack the player
 * @author cm
 *
 */
public abstract class Room {
	
	private String sRoomName = "";
	private String sRoomWelcomeMessage = "";
	
	// Lists which contain all the possibilities for navigation from where the user can choose
	private ArrayList<NavigationPossibility> alNavigationPossibilitiesWithoutItems = new ArrayList<NavigationPossibility>();
	private ArrayList<NavigationPossibility> alNavigationPossibilitiesInclusiveItems = new ArrayList<NavigationPossibility>();

	// lists containing items and monsters
	private ArrayList<Item> alItems = new ArrayList<Item>();
	private ArrayList<Monster> alMonsters = new ArrayList<Monster>();
	
	/**
	 * Method which must be implemented from every room
	 * @param oPlayer object of the Player
	 * @return the next Room which shall be visited
	 */
	public abstract String doAction(Player oPlayer);
	
	/**
	 * Method which checks if the player has everything to enter a room e.g. a key
	 * @param oPlayer object of the Player
	 * @return true if he has everything, false if not
	 */
	public boolean bMeetEntryConditions(Player oPlayer)
	{
		return true;
	}
	
	/**
	 * Check if there are still some monsters in the room
	 * @return true if there are still monsters in the room, false if not
	 */
	public boolean containsMonster()
	{
		if (alMonsters.size() > 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Remove a monster from the room
	 * @param oMonster monster which shall be removed
	 */
	public void removeMonster(Monster oMonster)
	{
		alMonsters.remove(oMonster);
	}
	
	/**
	 * Add a monster to the room
	 * @param oMonster monster which shall be added to the room
	 */
	public void addMonster(Monster oMonster)
	{
		alMonsters.add(oMonster);
	}
	
	/**
	 * Get a monster from the available monsters
	 * @return monster
	 */
	public Monster getMonster()
	{
		for(Monster oMonster: alMonsters)
		{
			return oMonster;
		}
		return null;
	}

	/**
	 * Let the user fight agains all monsters in this room
	 * @param oPlayer player who shall fight
	 * @return true if he survived, false if he lost the fights
	 */
	public boolean survivedFightAvailableMonsters(Player oPlayer)
	{
		Fight oFight;
		boolean bFightResult = false;
		while (containsMonster())
		{
			Monster oMonster = getMonster();
			oFight = new Fight(oPlayer,oMonster);
			bFightResult = oFight.startFight(); 
			if (bFightResult == false)
				return false;
			
			removeMonster(oMonster);
			
		}
		return true;
	}


	/**
	 * Add a navigation possibility to this room
	 * @param sKeyboardLetter Letter e.g. e
	 * @param sDescription Description for letter e.g. e for going east
	 * @param sNextRoom Room which shall be visited when you push the letter
	 */
	public void addNavigationPossibility(String sKeyboardLetter, String sDescription, String sNextRoom)
	{
		alNavigationPossibilitiesWithoutItems.add(new NavigationPossibility(sKeyboardLetter, sDescription, sNextRoom));
	}

	/**
	 * Add all the navigation possibilities from the items lying in the room and the items which are possesed by the user
	 * @param oPlayer object of the player
	 */
	public void addNavigationPossibilityPlayerItems(Player oPlayer)
	{
		String sKeyboardLetter;
		String sDescription;
		String sNextRoom;

		alNavigationPossibilitiesInclusiveItems = new ArrayList<NavigationPossibility>();

		// add all the already existing navigation possibilities
		for(NavigationPossibility oActPossibility : alNavigationPossibilitiesWithoutItems) {
			sKeyboardLetter =  oActPossibility.getsLetter();
			sDescription =  oActPossibility.getsLetterDescription();
			sNextRoom = oActPossibility.getsNextRoom();
			alNavigationPossibilitiesInclusiveItems.add(new NavigationPossibility(sKeyboardLetter, sDescription, sNextRoom));

		}
		
		// add all items from the room
		NavigationPossibility oActPossibility;
		for(Item oActItem : alItems)
		{
			if (oActItem.getoNavigationPossibility() != null && oActItem.getoNavigationPossibility().getsLetter() != null)
			{
				oActPossibility = oActItem.getoNavigationPossibility();
				alNavigationPossibilitiesInclusiveItems.add(new NavigationPossibility(oActPossibility.getsLetter(), oActPossibility.getsLetterDescription(), 
						oActPossibility.getsNextRoom()));
			}
			
		}
		
		// add all the items from the player
		ArrayList<Item> alPlayerItems = oPlayer.getAlItems();
		for(Item oActItem : alPlayerItems)
		{
			if (oActItem.getoNavigationPossibility() != null && oActItem.getoNavigationPossibility().getsUsingLetter() != "")
			{
				oActPossibility = oActItem.getoNavigationPossibility();
				alNavigationPossibilitiesInclusiveItems.add(new NavigationPossibility(oActPossibility.getsUsingLetter(), oActPossibility.getsUsingLetterDescription(), 
						oActPossibility.getsNextRoom()));
			}
		}
	}
		
	/**
	 * Print out all the navigation possibilities of the room	
	 */
	public void printNavigationPossabilities()
	{
		RW.writeLine(sRoomName + " gives you the following navigation possibilities:");
		String sPossibilities = "You can ";
		String sKeyboardLetter;
		String sDescription;

		for(NavigationPossibility oActPossibility : alNavigationPossibilitiesInclusiveItems) {
			sKeyboardLetter =  oActPossibility.getsLetter();
			sDescription = oActPossibility.getsLetterDescription();
			sPossibilities = sPossibilities + "press [" + sKeyboardLetter + "] for " + sDescription + "; ";

		}
		RW.writeLine(sPossibilities);
	}
	
	/**
	 * Ask the user for his next step. e.g. e for going east
	 * @param oPlayer object of player who is doing a step
	 * @return the room which shall be visited next
	 */
	public String getNextRoom(Player oPlayer)
	{
		boolean bFound = false;
		while (bFound == false)
		{
			printNavigationPossabilities();
			String sInput = RW.readLine();
			for(NavigationPossibility oActPossibility : alNavigationPossibilitiesInclusiveItems)
			{
				if (oActPossibility.getsLetter().equals(sInput))
				{
					bFound = true;
					
					// if it is an item you can pick up from the room
					for(Item oActItem : alItems)
					{
						if (oActItem.getoNavigationPossibility().getsLetter().equals(sInput))
						{
							// add item to player
							oPlayer.addItem(oActItem);
							setsRoomWelcomeMessage(oActItem.getsChangeRoomMessageAfterPickingUp());
							// remove item from the room
							removeItem(oActItem);
							return oActPossibility.getsNextRoom();
						}
					}
					
					// if it is an item the player already is possessing
					ArrayList<Item> alPlayerItems = oPlayer.getAlItems();
					for(Item oActItem : alPlayerItems)
					{
						if (oActItem.getoNavigationPossibility().getsUsingLetter().equals(sInput))
						{
							// add item to player
							oPlayer.useItem(oActItem);
							// remove item from the room
							oPlayer.removeItem(oActItem);
							return null;
						}
					}
					
					
					return oActPossibility.getsNextRoom();

				}
			}
			RW.writeLine("You stumble and fall, please enter an valid input.");

			
		}
		return null;
	
	}
	
	/**
	 * Add an item to the room
	 * @param oItem item which shall be added
	 */
	public void addItem(Item oItem)
	{
		alItems.add(oItem);
		
	}
	
	/**
	 * Remove an item from the room
	 * @param oItem item which shall be removed
	 */
	public void removeItem(Item oItem)
	{
				alItems.remove(oItem);
		
	}

	/**
	 * @return the sRoomName
	 */
	public String getsRoomName() {
		return sRoomName;
	}

	/**
	 * @param sRoomName the sRoomName to set
	 */
	public void setsRoomName(String sRoomName) {
		this.sRoomName = sRoomName;
	}

	/**
	 * @return the sRoomWelcomeMessage
	 */
	public String getsRoomWelcomeMessage() {
		return sRoomWelcomeMessage;
	}

	/**
	 * @param sRoomWelcomeMessage the sRoomWelcomeMessage to set
	 */
	public void setsRoomWelcomeMessage(String sRoomWelcomeMessage) {
		this.sRoomWelcomeMessage = sRoomWelcomeMessage;
	}

	
}