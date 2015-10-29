package se.ltu.softeng.dragon.room;

/**
 * Instances of this class are used for room navigation.
 * Every room has a list of NavigationPossibility objects. 
 * The objects are used for navigation to other rooms, picking up items and also using items
 * @author cm
 *
 */
public class NavigationPossibility {
	
	private String sLetter;
	private String sLetterDescription;
	
	private String sUsingLetter;
	private String sUsingLetterDescription;
	
	private String sNextRoom;
	
	/**
	 * Constructor for a NavigationPossibility object
	 * @param sLetter Letter to choose this object
	 * @param sLetterDescription description for the letter
	 * @param sNextRoom Room you will enter when you type the letter
	 */
	public NavigationPossibility(String sLetter, String sLetterDescription, String sNextRoom)
	{
		this.sLetter = sLetter;
		this.sLetterDescription = sLetterDescription;
		this.sNextRoom = sNextRoom;
		this.sUsingLetter = "";
		this.sUsingLetterDescription = "";
	}
	
	/**
	 * Constructor for a NavigationPossibility object which can be picked up and used e.g. a potion
	 * @param sLetter Letter for picking up item
	 * @param sLetterDescription Description for picking up item
	 * @param sNextRoom Room you will enter when you type the letter
	 * @param sUsingLetter Letter for using the item when you picked it up already e.g. drinking potion
	 * @param sUsingLetterDescription Description for using item e.g. drinking potion
	 */
	public NavigationPossibility(String sLetter, String sLetterDescription, String sNextRoom, 
			String sUsingLetter, String sUsingLetterDescription)
	{
		this.sLetter = sLetter;
		this.sLetterDescription = sLetterDescription;
		this.sNextRoom = sNextRoom;
		this.sUsingLetter = sUsingLetter;
		this.sUsingLetterDescription = sUsingLetterDescription;
	}

	/**
	 * @return the sLetter
	 */
	public String getsLetter() {
		return sLetter;
	}

	/**
	 * @param sLetter the sLetter to set
	 */
	public void setsLetter(String sLetter) {
		this.sLetter = sLetter;
	}

	/**
	 * @return the sLetterDescription
	 */
	public String getsLetterDescription() {
		return sLetterDescription;
	}

	/**
	 * @param sLetterDescription the sLetterDescription to set
	 */
	public void setsLetterDescription(String sLetterDescription) {
		this.sLetterDescription = sLetterDescription;
	}

	/**
	 * @return the sUsingLetter
	 */
	public String getsUsingLetter() {
		return sUsingLetter;
	}

	/**
	 * @param sUsingLetter the sUsingLetter to set
	 */
	public void setsUsingLetter(String sUsingLetter) {
		this.sUsingLetter = sUsingLetter;
	}

	/**
	 * @return the sUsingLetterDescription
	 */
	public String getsUsingLetterDescription() {
		return sUsingLetterDescription;
	}

	/**
	 * @param sUsingLetterDescription the sUsingLetterDescription to set
	 */
	public void setsUsingLetterDescription(String sUsingLetterDescription) {
		this.sUsingLetterDescription = sUsingLetterDescription;
	}

	/**
	 * @return the sNextRoom
	 */
	public String getsNextRoom() {
		return sNextRoom;
	}

	/**
	 * @param sNextRoom the sNextRoom to set
	 */
	public void setsNextRoom(String sNextRoom) {
		this.sNextRoom = sNextRoom;
	}

	

	

	
	
	

}
