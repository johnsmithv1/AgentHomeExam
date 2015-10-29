package se.ltu.softeng.dragon.fight;

import java.util.ArrayList;
import se.ltu.softeng.dragon.Player;
import se.ltu.softeng.dragon.item.Item;
import se.ltu.softeng.dragon.item.Item.ItemType;
import se.ltu.softeng.dragon.item.Weapon;
import se.ltu.softeng.dragon.monster.Monster;
import se.ltu.softeng.dragon.rw.RW;

/**
 * Class used for fighting against a monster
 * @author cm
 *
 */
public class Fight {

	private Player oPlayer;
	private Monster oMonster;

	/**
	 * Constructor of a fight
	 * @param oPlayer player who wants to fight
	 * @param oMonster monster against the player fights
	 */
	public Fight(Player oPlayer, Monster oMonster)
	{
		this.oPlayer = oPlayer;
		this.oMonster = oMonster;
	}

	/**
	 * In this method the fight Player vs. Monster happens
	 * @return false if player looses the fight, true if player wins the fight
	 */
	public boolean startFight() {
		
		int iPlayerAttackDamage = oPlayer.getiAttackDamage();
		
		// get the best weapon from the player to fight against the monster
		Weapon oBestWeapon = null;
		Weapon oActualWeapon = null;
		ArrayList<Item> alWeapons = oPlayer.getItemOfType(ItemType.WEAPON);
		for(Item oItem : alWeapons)
		{
			oActualWeapon = (Weapon) oItem;
			if (oBestWeapon == null)
			{
				oBestWeapon = oActualWeapon;
			}
			if(oBestWeapon.getiAttackDamage() > oActualWeapon.getiAttackDamage())
			{
				oBestWeapon = oActualWeapon;
			}
			
		}
		if (oBestWeapon != null)
		{
			iPlayerAttackDamage = iPlayerAttackDamage + oBestWeapon.getiAttackDamage();
			RW.writeLine("The weapon " + oBestWeapon.getsName() + " helps you in this fight.");
		}

		
		RW.writeLine(oMonster.getsWelcomeMessage());
		
		// fight until monster or player is dead
		while (oPlayer.getiHealth() > 0 && oMonster.getiHealth() > 0)
		{
			RW.writeLine(oMonster.getsName() + " attacks you and does " + oMonster.getiAttackDamage() + " damage");
			oPlayer.setiHealth(oPlayer.getiHealth()-oMonster.getiAttackDamage());
			
			RW.writeLine("You attack " + oMonster.getsName() + " and do " + iPlayerAttackDamage + " damage");
			oMonster.setiHealth(oMonster.getiHealth() - iPlayerAttackDamage);
			
			
		}

		if(oPlayer.getiHealth() <= 0) {
			return false;
		} else {
			RW.writeLine("You defeat " + oMonster.getsName() + " and have " + oPlayer.getiHealth() + " hitpoints left.");
			return true;
		}

	}

}
