package se.ltu.softeng.dragon.monster;

/**
 * Class representing a Beast monster
 * @author cm
 *
 */
public class Beast extends Monster{
	
	/**
	 * Constructor for the Beast
	 * @param sName Name of the Beast 
	 * @param iAttackDamage Damage of the Beast when he attacks the player once
	 */
	public Beast(String sName, int iAttackDamage)
	{
		this.setsName(sName);
		this.setiAttackDamage(iAttackDamage);
		this.setiHealth(8);
	}

}
