package se.ltu.softeng.dragon.item;

import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.rw.RW;

/**
 * Item of type Potion which can be used to increase health of the player
 * @author cm
 *
 */
public class Potion extends Item{
	
	private int iIncreaseHealth = 0;
	
	/**
	 * Constructor of the Potion
	 * @param sName Name of the potion
	 * @param iIncreaseHealth Amount of health which gets increased by this potion
	 */
	public Potion(String sName, int iIncreaseHealth)
	{
		this.setsName(sName);
		this.iIncreaseHealth = iIncreaseHealth;
		this.setbReUsable(false);
		this.seteType(Item.ItemType.POTION);
	}

	/**
	 * Method called when user wants to drink the potion
	 */
	@Override
	public void useItem(Player oPlayer) {
		
		int iPlayerHealth = oPlayer.getiHealth();
		if ((iPlayerHealth + iIncreaseHealth) > oPlayer.getiMaxHealth())
		{
			oPlayer.setiHealth(oPlayer.getiMaxHealth());
		}
		else
		{
			oPlayer.setiHealth(iPlayerHealth + iIncreaseHealth);
		}
		RW.writeLine("You have " + oPlayer.getiHealth() + " health points now.");
	}


}
