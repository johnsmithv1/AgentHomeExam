package se.ltu.softeng.dragon.item;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.room.NavigationPossibility;

/**
 * Abstract class used for different item types e.g. WEAPON, POTION, KEY, TREASURE
 * @author cm
 *
 */
public abstract class Item {
	
	// the different available item types
	public enum ItemType {WEAPON, POTION, KEY, TREASURE};
	
	private String sName;
	private ItemType eType;
	private String sDescription;
	private String sPickingUpMessage;
	private String sChangeRoomMessageAfterPickingUp;
	private boolean bReUsable = false;
	private NavigationPossibility oNavigationPossibility = null;
	
	/**
	 * Method which must be implemented from every concrete item
	 * @param oPlayer
	 */
	public abstract void useItem(Player oPlayer);
	
	/**
	 * Set navigation possibility for picking up this item. The possibility will be presented to the player
	 * @param sPickingUpLetter Letter to pick up the item
	 * @param sPickingUpLetterDescription description about the item
	 * @param sNextRoom Room which shall be visited when you pick up the item
	 */
	public void setoNavigationPossibility(String sPickingUpLetter, String sPickingUpLetterDescription, String sNextRoom)
	{
		oNavigationPossibility = new NavigationPossibility(sPickingUpLetter, sPickingUpLetterDescription, sNextRoom);
	}
	
	/**
	 * This navigation possibility is used when you have an item which can be picked up and also used afterwards e.g. a potion
	 * @param sPickingUpLetter Letter to pick up the item
	 * @param sPickingUpLetterDescription description about the item
	 * @param sNextRoom Room which shall be visited when you pick up the item
	 * @param sUsingLetter Letter for using the item
	 * @param sUsingLetterDescription description about the item usage
	 */
	public void setoNavigationPossibility(String sPickingUpLetter, String sPickingUpLetterDescription, String sNextRoom, 
			String sUsingLetter, String sUsingLetterDescription)
	{
		oNavigationPossibility = new NavigationPossibility(sPickingUpLetter, sPickingUpLetterDescription, sNextRoom, sUsingLetter, sUsingLetterDescription);
	}
	
	/**
	 * Get the navigationPossibility of this item
	 * @return
	 */
	public NavigationPossibility getoNavigationPossibility()
	{
		return oNavigationPossibility;
	}

	/**
	 * @return the sName
	 */
	public String getsName() {
		return sName;
	}

	/**
	 * @param sName the sName to set
	 */
	public void setsName(String sName) {
		this.sName = sName;
	}

	/**
	 * @return the eType
	 */
	public ItemType geteType() {
		return eType;
	}

	/**
	 * @param eType the eType to set
	 */
	public void seteType(ItemType eType) {
		this.eType = eType;
	}

	/**
	 * @return the sDescription
	 */
	public String getsDescription() {
		return sDescription;
	}

	/**
	 * @param sDescription the sDescription to set
	 */
	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}

	/**
	 * @return the sPickingUpMessage
	 */
	public String getsPickingUpMessage() {
		return sPickingUpMessage;
	}

	/**
	 * @param sPickingUpMessage the sPickingUpMessage to set
	 */
	public void setsPickingUpMessage(String sPickingUpMessage) {
		this.sPickingUpMessage = sPickingUpMessage;
	}

	/**
	 * @return the sChangeRoomMessageAfterPickingUp
	 */
	public String getsChangeRoomMessageAfterPickingUp() {
		return sChangeRoomMessageAfterPickingUp;
	}

	/**
	 * @param sChangeRoomMessageAfterPickingUp the sChangeRoomMessageAfterPickingUp to set
	 */
	public void setsChangeRoomMessageAfterPickingUp(String sChangeRoomMessageAfterPickingUp) {
		this.sChangeRoomMessageAfterPickingUp = sChangeRoomMessageAfterPickingUp;
	}

	/**
	 * @return the bReUsable
	 */
	public boolean isbReUsable() {
		return bReUsable;
	}

	/**
	 * @param bReUsable the bReUsable to set
	 */
	public void setbReUsable(boolean bReUsable) {
		this.bReUsable = bReUsable;
	}

	/**
	 * @param oNavigationPossibility the oNavigationPossibility to set
	 */
	public void setoNavigationPossibility(NavigationPossibility oNavigationPossibility) {
		this.oNavigationPossibility = oNavigationPossibility;
	}


	
}
