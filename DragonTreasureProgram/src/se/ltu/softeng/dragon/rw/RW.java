package se.ltu.softeng.dragon.rw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * This class is used from nearly all other classes to read and write from and to STDIN/STDOUT
 * @author cm
 *
 */
public class RW {
	
	private static String sLastLine = "";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static String sJunitInput;
	private static String sJunitOutput;
	private static boolean bJunit;
	

	/**
	 * Read one line from STDIN
	 * @return one line from STDIN
	 */
	public static String readLine()
	{
		if (bJunit == true)
		{
			sLastLine = sJunitInput;
			writeLine("JUnit INPUT: " + sJunitInput);
			return sLastLine;
		}
	
		try {
			sLastLine = br.readLine();
		} catch (IOException e) {
			System.out.println("Error reading from STDIN");
		}
		
		return sLastLine;
		
	}
	

	/**
	 * Write on line to STDOUT
	 * @param sLine line which will be written to STDOUT
	 */
	public static void writeLine(String sLine)
	{
		if (bJunit == true)
		{
			sJunitOutput = sLine;
			System.out.println(sLine);

		}
		else
		{
			System.out.println(sLine);
		}
	}

	/**
	 * @return the sJunitInput
	 */
	public static String getsJunitInput() {
		return sJunitInput;
	}

	/**
	 * @param sJunitInput the sJunitInput to set
	 */
	public static void setsJunitInput(String sJunitInput) {
		RW.sJunitInput = sJunitInput;
	}

	/**
	 * @return the bJunit
	 */
	public static boolean isbJunit() {
		return bJunit;
	}

	/**
	 * @param bJunit the bJunit to set
	 */
	public static void setbJunit(boolean bJunit) {
		RW.bJunit = bJunit;
	}

	/**
	 * @return the sJunitOutput
	 */
	public static String getsJunitOutput() {
		return sJunitOutput;
	}


}
