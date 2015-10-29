package se.ltu.softeng.dragon;

import java.util.ArrayList;

import se.ltu.softeng.dragon.item.Item;
import se.ltu.softeng.dragon.item.Item.ItemType;
import se.ltu.softeng.dragon.rw.RW;

/**
 * Player who can walk through the different rooms of the dungeon
 * @author cm
 *
 */
public class Player {
	
	private String sName;
	private int iHealth;
	private final int iMaxHealth = 10;
	private int iMoney;
	private int iAttackDamage;
	private ArrayList<Item> alItems = new ArrayList<Item>();
	
	/**
	 * Constructor for the player
	 * @param sName Name of the player
	 */
	public Player(String sName)
	{
		this.sName = sName;
		this.iHealth = 10;
		this.iAttackDamage = 1;
	}
	
	/**
	 * Add an item to the player's item list e.g. a key, potion or a weapon
	 * @param oItem
	 */
	public void addItem(Item oItem)
	{
		alItems.add(oItem);
		RW.writeLine(oItem.getsPickingUpMessage());
	}
	
	/**
	 * Remove an item from the player's item list
	 * @param oItem
	 */
	public void removeItem(Item oItem)
	{
		alItems.remove(oItem);
	}
	
	/**
	 * Check if the player has an item from a specific type
	 * @param eType Type which shall be checked
	 * @return true if the player has an item of that type, false if not
	 */
	public boolean hasItem(ItemType eType)
	{
		for(Item oItem : alItems)
		{
			if (oItem.geteType().equals(eType))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Get all items of a specific type
	 * @param eType Type which is desired
	 * @return List containing all desired items
	 */
	public ArrayList<Item> getItemOfType(ItemType eType)
	{
		ArrayList<Item> alSearchedItem = new ArrayList<Item>();
		for(Item oItem : alItems)
		{
			if (oItem.geteType().equals(eType))
			{
				alSearchedItem.add(oItem);
			}
		}
		return alSearchedItem;
	}
	
	/**
	 * Use a item e.g. a potion
	 * @param oItem
	 */
	public void useItem(Item oItem)
	{
		oItem.useItem(this);
		
		if (oItem.isbReUsable() == false)
		{
			alItems.remove(oItem);
		}
		
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
	 * @return the iHealth
	 */
	public int getiHealth() {
		return iHealth;
	}

	/**
	 * @param iHealth the iHealth to set
	 */
	public void setiHealth(int iHealth) {
		this.iHealth = iHealth;
	}

	/**
	 * @return the iMoney
	 */
	public int getiMoney() {
		return iMoney;
	}

	/**
	 * @param iMoney the iMoney to set
	 */
	public void setiMoney(int iMoney) {
		this.iMoney = iMoney;
	}

	/**
	 * @return the iAttackDamage
	 */
	public int getiAttackDamage() {
		return iAttackDamage;
	}

	/**
	 * @param iAttackDamage the iAttackDamage to set
	 */
	public void setiAttackDamage(int iAttackDamage) {
		this.iAttackDamage = iAttackDamage;
	}

	/**
	 * @return the alItems
	 */
	public ArrayList<Item> getAlItems() {
		return alItems;
	}

	/**
	 * @param alItems the alItems to set
	 */
	public void setAlItems(ArrayList<Item> alItems) {
		this.alItems = alItems;
	}

	/**
	 * @return the iMaxHealth
	 */
	public int getiMaxHealth() {
		return iMaxHealth;
	}

}
