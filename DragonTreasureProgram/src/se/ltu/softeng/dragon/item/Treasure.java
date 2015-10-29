package se.ltu.softeng.dragon.item;

import se.ltu.softeng.dragon.Player;

/**
 * Item of type treasure which can be used to make the user rich :-)
 * @author cm
 *
 */
public class Treasure extends Item{
	
	private int iMoney;
	
	/**
	 * Constructor of the treasure
	 * @param sName Name of the treasure
	 * @param iMoney Amount of money the treasure is worth
	 */
	public Treasure(String sName, int iMoney)
	{
		this.setsName(sName);
		this.setbReUsable(false);
		this.seteType(Item.ItemType.TREASURE);
		this.iMoney = iMoney;
	}

	/**
	 * Method which needs to be implemented if the item can be used activly by the user
	 */
	@Override
	public void useItem(Player oPlayer) {
		// TODO Auto-generated method stub
		
	}

}
