package DicSkill;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import edu.mit.jwi.*;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ILexFile;
import edu.mit.jwi.item.ISenseKey;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.item.POS;
import edu.mit.jwi.item.ISynset;

/**#################################################
 * !!! THIS COULD ACTUALLY bE A UNIT TEST FOR DBC !!!
 #################################################*/

public class Test {

    public static void main(String[]args) {

        testEDUMIT();
    }

    private static void testEDUMIT() {

        IDictionary dict = null;

        try {
            //construct URL to WordNet Dictionary directory on the computer
            String path = "/dict";
            URL url = new URL("file", null, path);

            //construct the Dictionary object and open it
            dict = new Dictionary(url);
            dict.open();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // look up first sense of the word "dog "
        IIndexWord idxWord = dict.getIndexWord("dog", POS.NOUN);
        IWordID wordID = idxWord.getWordIDs().get(0);
        IWord word = dict.getWord(wordID);
        ISynset synset = word.getSynset();
        String LexFileName = synset.getLexicalFile().getName();
        System.out.println("Lexical Name : "+ LexFileName);

    }

    private static void testDBC() {

        //########### DATABASECOMMUNICATOR ###############//

        String lolz = new String("happy");
        int NOW = 10;

        DatabaseCommunicator d = new DatabaseCommunicator();

        String[] h1 = d.define(lolz, NOW);

        for(int i=0; i<h1.length; i++)
            System.out.println(h1[i]);

        System.out.println("---\n");

        h1 = d.giveSynonyms(lolz, NOW);

        for(int i=0; i<h1.length; i++)
            System.out.println(h1[i]);

        System.out.println("---\n");

        h1 = d.spell(lolz);

        for(int i=0; i<h1.length; i++)
            System.out.println(h1[i]);

        System.out.println("---\n");

        h1 = d.scrabble_start(lolz, NOW);

        for(int i=0; i<h1.length; i++)
            System.out.println(h1[i]);

        System.out.println("---\n");

        h1 = d.giveExamples(lolz, NOW);

        for(int i=0; i<h1.length; i++)
            System.out.println(h1[i]);

    }
}
