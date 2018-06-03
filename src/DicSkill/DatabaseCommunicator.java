package DicSkill;

/**
 * 21.05.2018
 *
 * DatabaseCommunicator gets function specific calls. The databases will be searched accordingly
 * and the result will be extracted. Then it will be returned.
 *
 * Used databases with API:
 * - WordNet database with Rita
 * -
 *
 * TO DO:
 * - Get a translation database
 *
 * @author Walter
 *
 */

/**
 * 29.04.2018
 * TO DO:
 * -	make use of database
 * -	implement all functions
 * -	function translate is a rough template of what the functions (except extractResult) should look like
 * @author Lia
 *
 */

import rita.RiWordNet;

/**
 * DatabaseCommunicator gets function specific calls. The databases will be searched accordingly
 * and the result will be extracted. Then the answer will be returned to the Messagemanager.
 */
public class DatabaseCommunicator {

	/**
	 * VARIABlES
	 **/
	private RiWordNet RitaDB;

	private String pos;                // Rita specific: PartsOfSpeach. e.g.: noun, adjective, verb ...

	/**
	 * Constructor
	 **/
	public DatabaseCommunicator() {

		RitaDB = new RiWordNet("dict/");
		pos = null;
	}


	/**
	 * Methods
	 **/

	/*
	 * Makes sense of the gibberish the data base outputs
	 * String shall always be the result (definition/translation/...)
	 */
	private String[] extractResult(String dbOutput[]) {
		return null;
	}

	/**
	 * Shortens the Array to fit the NOW.
	 *
	 * @param dbOutput
	 * @return String[] shortened Array
	 */
	private String[] extractArray(String dbOutput[], int NOW) {

		String[] returnArray = new String[NOW];

		for (int i = 0; i < NOW; i++) {

			if (dbOutput[i] != null) {
				returnArray[i] = dbOutput[i];
			}
		}

		return returnArray;
	}

	/**
	 * WIP. Translate provides the translation to the wished word
	 *
	 * @param ww  wishedWord
	 * @param NOW numberOfWords
	 * @return String[] databaseOutput[]
	 */
	public String[] translate(String ww, int NOW) {

		if (!RitaDB.exists(ww)) {
			return null;
		}

		String result[] = null;

		return result;
	}

	/**
	 * Define provides a definition of the wished word.
	 *
	 * @param ww  wishedWord
	 * @param NOW numberOfWords
	 * @return String[] databaseOutput[]
	 */
	public String[] define(String ww, int NOW) {

		if (!RitaDB.exists(ww)) {
			return null;
		}

		String result[];

		pos = RitaDB.getBestPos(ww);
		result = RitaDB.getAllGlosses(ww, pos);

		result = extractArray(result, NOW);

		return result;
	}

	// returns synonyms for the wished word

	/**
	 * GiveSynonyms provides a synonym of the wished word.
	 *
	 * @param ww  wishedWord
	 * @param NOW numberOfWords
	 * @return String[] databaseOutput[]
	 */
	public String[] giveSynonyms(String ww, int NOW) {

		if (!RitaDB.exists(ww)) {
			return null;
		}

		String result[];

		pos = RitaDB.getBestPos(ww);
		result = RitaDB.getAllSimilar(ww, pos);

		result = extractArray(result, NOW);

		return result;
	}

	/**
	 * Spell provides the spelling of a word.
	 *
	 * @param ww wishedWord
	 * @return String[] databaseOutput[]
	 */
	public String[] spell(String ww) {

		int length = ww.length();
		String result[] = new String[length];

		for (int i = 0; i < length; i++) {
			result[i] = ww.substring(i, i + 1);
		}

		return result;
	}

	/**
	 * returns words that start with [letters]
	 *
	 * @param letters the word starts with
	 * @param NOW     numberOfWords
	 * @return String[] result
	 */
	public String[] scrabble_start(String letters, int NOW) {

		String result[];

		pos = RitaDB.getBestPos(letters);
		result = RitaDB.getStartsWith(letters, pos, NOW);

		return result;
	}

	/**
	 * returns words that ends with [letters]
	 *
	 * @param letters the word starts with
	 * @param NOW     numberOfWords
	 * @return String[] result
	 */
	public String[] scrabble_end(String letters, int NOW) {

		String result[];

		pos = RitaDB.getBestPos(letters);
		result = RitaDB.getEndsWith(letters, pos, NOW);

		return result;
	}

	/**
	 * returns words that contains [letters]
	 *
	 * @param letters the word starts with
	 * @param NOW     numberOfWords
	 * @return String[] result
	 */
	public String[] scrabble_contain(String letters, int NOW) {

		String result[];

		pos = RitaDB.getBestPos(letters);
		result = RitaDB.getContains(letters, pos, NOW);

		return result;
	}
}