package se.ltu.softeng.dragon.monster;

/**
 * Abstract class of a Monster which is used for different monster types e.g. Dragon and Beast
 * @author cm
 *
 */
public abstract class Monster {
	
	private String sName;
	private String sDescription;
	private String sWelcomeMessage = "";
	private int iHealth;
	private int iAttackDamage;
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
	 * @return the sWelcomeMessage
	 */
	public String getsWelcomeMessage() {
		return sWelcomeMessage;
	}
	/**
	 * @param sWelcomeMessage the sWelcomeMessage to set
	 */
	public void setsWelcomeMessage(String sWelcomeMessage) {
		this.sWelcomeMessage = sWelcomeMessage;
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
