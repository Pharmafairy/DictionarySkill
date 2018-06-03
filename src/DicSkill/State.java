package DicSkill;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 03.06.2018
 * NEW:
 * -	State can now save and load context and settings
 * @author Lia
 *
 */

/**
 * 29.04.2018
 * TO DO:
 * -	make class to save context and settings
 * @author Lia
 *
 */

public class State {
	
	/** VARIABlES **/
	File context_file;
	File settings_file;
	
	
	/** Constructor **/
	State() {
		context_file = new File("/State", "context_file.ser");
		settings_file = new File("/State", "settings_file.ser");
	}
	
	
	/** Methods **/
	public void save(Settings settings, Context context) {

		try{
			
			//saves context
			FileOutputStream fos = new FileOutputStream("context_file.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(context);
			
			//saves settings
			fos = new FileOutputStream("settings_file.ser");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(settings);
			
			oos.close();

		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}
	
	// loads context file and returns context object
	public Context loadContext() {
		
		Context context;
			
		try{
			FileInputStream fis = new FileInputStream("context_file.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			context = (Context) ois.readObject();
			ois.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return new Context();
		}
		catch(IOException e) {
			System.out.println("New context has been created.");
			return new Context();
		}
		
		
		return context;

	}
	
	
	// loads settings file and returns Settings object
	public Settings loadSettings() {
		
		Settings settings;
			
		try{
			FileInputStream fis = new FileInputStream("settings_file.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			settings = (Settings) ois.readObject();
			ois.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			return new Settings();
		}
		catch(IOException e) {
			System.out.println("New settings have been created.");
			return new Settings();
		}
		
		return settings;

	}

	
}
