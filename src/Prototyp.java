import java.util.Scanner;

import rita.*;

public class Prototyp {

	public static RiWordNet dictionary;
	static int indexOfCurrentPos = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//variables
		String input;
		String wishedWord;
		String wishedFunction;
		String[] outputArray;
		String output;
		String isIt;
		int indexOfCurrentOutput = 0;
		
		
//		Scanner sc = new Scanner(System.in);
//		input = sc.nextInt();
		input = "What is the definition of blood";
		
		//create dictionary
		dictionary = new RiWordNet("dict/");
		
		
		//evaluate what user wants
		if(input.contains("definition of") || input.contains("meaning of")){
			int positionOfwishedFunction = 0;
			
			wishedFunction = "definition";
			
			if(input.contains("definition of"))
			{
				positionOfwishedFunction = input.indexOf("definition of");
				wishedWord = input.substring(positionOfwishedFunction+("definition of".length()+1));
			}
			else if(input.contains("meaning of"))
			{
				positionOfwishedFunction = input.indexOf("meaning of");
				wishedWord = input.substring(positionOfwishedFunction+("meaning of".length()+1));
			}
			else
				wishedWord = "word cannot be found in sentence";
				
			
			
//			System.out.println("Test: " + wishedFunction+", " + wishedWord);
		}
		else{
			wishedFunction = "unknown";
			wishedWord = "errorXYZ";
		}
		
		
		
		if(dictionary.exists(wishedWord))
		{
			switch(wishedFunction)
			{
				case "definition":
				{
					String pos = getPartsOfSpeech(wishedWord);
					if(pos != "nonono")
					{
//						System.out.println("pos is not nonono");
						outputArray = dictionary.getAllGlosses(wishedWord, pos);
						try{
							output = outputArray[indexOfCurrentOutput];
						}
						catch(ArrayIndexOutOfBoundsException oub)
						{
							output = "Sorry, there are no matches with your search";
						}
					}
					else
					{
						output = "pos is nonono";
					}
					
					break;
				}
				default:
				{
					output = "Sorry, this function is not avialable";
					break;
				}
				
			}
		}
		else
		{
			output = "Word does not exist in database";
		}
		System.out.println(output);
	}
	
	public static String getPartsOfSpeech(String word)
	{
		if(dictionary.exists(word))
		{
			String pos;
			String[] posArr;
			posArr = dictionary.getPos(word);
			pos = posArr[indexOfCurrentPos];
			indexOfCurrentPos++;
			return pos;
		}
		else{
			System.out.println("Word does not exist in database: " + word);
			return "nonono";
		}
	}
	
	public void resetAll()
	{
		indexOfCurrentPos = 0;
	}

}
