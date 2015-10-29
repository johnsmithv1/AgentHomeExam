package se.ltu.softeng.dragon.item;

import se.ltu.softeng.dragon.Player;

/**
 * Item of type Weapon which can be used to attack creatures
 * @author cm
 *
 */
public class Weapon extends Item{
	
	private int iAttackDamage;
	
	/**
	 * Constructor of the weapon
	 * @param sName Name of the weapon
	 * @param iAttackDamage Damage the weapon makes against monsters
	 */
	public Weapon(String sName, int iAttackDamage)
	{
		this.setsName(sName);
		this.setbReUsable(true);
		this.seteType(Item.ItemType.WEAPON);
		this.iAttackDamage = iAttackDamage;
	}

	/**
	 * Method which needs to be implemented if the item can be used activly by the user
	 */
	@Override
	public void useItem(Player oPlayer) {
		// TODO Auto-generated method stub
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

	
	
	

}
