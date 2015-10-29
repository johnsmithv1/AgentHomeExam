package se.ltu.softeng.dragon.item;

import se.ltu.softeng.dragon.Player;

/**
 * Item of the type Key which can be used to open locked doors
 * @author cm
 *
 */
public class Key extends Item{
		
	/**
	 * Constructor of the key
	 * @param sName Name of the key
	 */
	public Key(String sName)
	{
		this.setsName(sName);
		this.setbReUsable(false);
		this.seteType(Item.ItemType.KEY);
	}

	/**
	 * Method which needs to be implemented if the item can be used activly by the user
	 */
	@Override
	public void useItem(Player oPlayer) {
		// TODO Auto-generated method stub
		
	}



}
