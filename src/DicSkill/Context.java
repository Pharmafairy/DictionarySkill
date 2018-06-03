package DicSkill;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 03.06.2018
 * NEW:
 * -	Context is now savable
 * @author Lia
 *
 */

/**
 * 27.05.2018
 * NEW:
 * - 	preferresCategories is now of type ArrayList<String>
 * -	added functions: addPrefCat, removePrefCat, deleteAllPrefCat, changePrefCat
 * TO DO:
 * -	make context saveable
 * @author Lia
 *
 */

/**
 * 29.04.2018
 * TO DO:
 * -	make context saveable
 * @author Lia
 *
 */

public class Context implements Serializable {

	/** VARIABlES **/
	private static final long serialVersionUID = 4L;
	
	private Function lastFunctionUsed;
	private ArrayList<String> preferredCategory;
	private String lastWishedWord; // The "Wished Word", is the word, the function will be applied to
	
	
	/** Constructor **/
	public Context(){
		preferredCategory = new ArrayList<String>();
	}
	
	
	/** Methods **/
	
	/*
	 * This function finds out what change the user wants to make to the preferred categories by checking
	 * for keywords and then calls the function which will make the change.
	 */
	public void changePrefCat(String msg) {
		
		if(msg.contains("add")) {
			String cat = msg.substring( msg.indexOf("add")+4 );
			if( cat.contains(" ") )
				cat = cat.substring(0, cat.indexOf(" "));
			addPrefCat( cat );
		}
		
		else if(msg.contains("remove")) {
			String cat = msg.substring( msg.indexOf("remove")+7);
			if( cat.contains(" "))
				cat = cat.substring(0, cat.indexOf(" "));
			removePrefCat( cat );
		}
		
		else if (msg.contains("delete all")) {
			String cat = msg.substring( msg.indexOf("delete all")+11);
			if( cat.contains(" "))
				cat = cat.substring(0, cat.indexOf(" "));
			deleteAllPrefCat();
		}
		
		else {
			System.out.println("Sorry, I could not understand which changes you want to "
					+ "make to your preferred categories. You may add a category, remove a "
					+ "category or delete all preferres categories.");
		}
		
	}
	
	private void addPrefCat(String cat) {
		preferredCategory.add(cat);
		System.out.println(cat + " was added to your preferred categories.");
	}
	
	private void removePrefCat(String cat) {
		if(preferredCategory.contains(cat)) {
			preferredCategory.remove(cat);
			System.out.println(cat + " was removed from your preferred categories.");
		}
		else {
			System.out.println(cat + " could not be found in your preferred categories.");
		}
	}
	
	private void deleteAllPrefCat() {
		preferredCategory.clear();
		System.out.println("All your preferred categories were deleted.");
	}

	
	/** Setters and Getters **/
	public Function getLastFunctionUsed() {
		return lastFunctionUsed;
	}


	public void setLastFunctionUsed(Function lastFunctionUsed) {
		this.lastFunctionUsed = lastFunctionUsed;
	}


	public ArrayList<String> getPreferredCategory() {
		return preferredCategory;
	}


	public void setPreferredCategory(ArrayList<String> preferredCategory) {
		this.preferredCategory = preferredCategory;
	}


	public String getLastWishedWord() {
		return lastWishedWord;
	}


	public void setLastWishedWord(String lastWishedWord) {
		this.lastWishedWord = lastWishedWord;
	}
	
}

