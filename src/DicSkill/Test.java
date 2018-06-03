package DicSkill;

/**#################################################
 * !!! THISCOULD ACTUALLY bE A UNIT TEST FOR DBC !!!
 #################################################*/

public class Test {

    public static void main(String[]args) {

        //########### DATABASECOMMUNICATOR ###############//

        String lolz = new String("translation");
        int NOW = -1;

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
