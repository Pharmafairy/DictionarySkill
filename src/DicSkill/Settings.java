package DicSkill;

import java.io.Serializable;

/**
 * 23.05.2018
 * TO DO:
 * -	make settings saveable
 * NEW:
 * -	setNOW function
 * 
 * @author Lia
 *
 */

/**
 * 29.04.2018
 * TO DO:
 * -	make settings saveable
 * @author Lia
 *
 */

public class Settings implements Serializable  
{
	/** VARIABlES **/
	
	// NOW = Number Of Words
	private int NOW_translation;
	private int NOW_definition;
	private int NOW_synonyms;
	private int NOW_scrabble;
	
	
	/** Constructor **/
	public Settings()
	{
		this.NOW_translation = 1;
		this.NOW_definition = 1;
		this.NOW_synonyms = 3;
		this.NOW_scrabble = 3;
	}
	
	/** Methods **/
	private void setAll(int x)
	{
		this.NOW_translation = x;
		this.NOW_definition = x;
		this.NOW_synonyms = x;
		this.NOW_scrabble = x;
	}
	
	public void setNOW(String msg)
	{
		// functionFound will indicate wether or not a function has been found
		boolean functionFound = false;
		
		// x is the number to which the user wants to set one or all NOW to
		try {
			int x = Integer.parseInt( msg.substring(msg.lastIndexOf("to")+3) );
			
			if(msg.contains("translations")) {
				NOW_translation = x;
				functionFound = true;
				System.out.println("Number of words for translations have been set to "+x);
			}
			if(msg.contains("definitions")) {
				NOW_definition = x;
				functionFound = true;
				System.out.println("Number of words for definitions have been set to "+x);
			}
			if(msg.contains("synonyms")) {
				NOW_synonyms = x;
				functionFound = true;
				System.out.println("Number of words for synonyms have been set to "+x);
			}
			if(msg.contains("scrabble")) {
				NOW_definition = x;
				functionFound = true;
				System.out.println("Number of words for scrabble have been set to "+x);
			}
			if(msg.contains("all")) {
				setAll(x);
				functionFound = true;
				System.out.println("Number of words for all have been set to "+x);
			}
		}
		catch (NumberFormatException e)
		{
			System.out.print("Sorry, you must set the number of words to a certain number.");
		}		
		
		if(functionFound == false)
		{
			System.out.print("Sorry, you must indicate which function you want to change the "
					+ "number of words for. You may choose: definitons, translations, synonyms, scrabble or all.");
		}
	}

	
	/** Setters and Getters **/
	public int getNOW_translation() {
		return NOW_translation;
	}

	public int getNOW_definition() {
		return NOW_definition;
	}

	public int getNOW_synonyms() {
		return NOW_synonyms;
	}

	public int getNOW_scrabble() {
		return NOW_scrabble;
	}
	
}
