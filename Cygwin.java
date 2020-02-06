/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;
public class Cygwin implements Menu
{
	public void printMenu()
		{
			System.out.println(Menu.MENU);
		}

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String outputText = "";
		String logFile = "";
		int userChoice; //picking which action they want done from the 6 in the menu
		String choice = ""; //picking whether they want to dump to a log file 
		Menu options = new Cygwin(); //creating the menu object to shorten lines in the main

		System.out.println("WOULD YOU LIKE TO DUMP RESULTS TO A LOG FILE? (Y/N)");
		choice = keyboard.next();
		keyboard.nextLine();

		if (choice.equalsIgnoreCase("Y"))
		{
			System.out.println("ENTER FILE NAME TO DUMP RESULTS TO.");
			logFile = keyboard.nextLine();
		}  
		else
		{
			System.out.println("");
		}

		while (true) //big while loop to allow user to repeat input if bad input
		{
			try
			{//try bracket
				options.printMenu(); //printing the menu 
				userChoice = keyboard.nextInt();
				while (userChoice == userChoice)
				{//while bracket
					switch(userChoice)
					{//switch bracket
						case 1:
							keyboard.nextLine(); 
					    	System.out.println("ENTER DIRECTORY TO HAVE CONTENTS DISPLAYED.");
					   		String directoryName = keyboard.nextLine();
							ListFiles fileList = new ListFiles(directoryName);
							System.out.println(fileList.toString());
							outputText += "\nChoice 1:\n" + fileList.toString();
							break;
						case 2:
							keyboard.nextLine(); 
				    		System.out.println("ENTER DIRECTORY TO HAVE CONTENTS & SUBDIRECTORIES CONTENTS DISPLAYED.");
				    		directoryName = keyboard.nextLine();
							SubdirectoryList subFileList = new SubdirectoryList(directoryName);
							System.out.println(subFileList.rcString(subFileList.getFileList()));
							outputText += "\nChoice 2:\n" + subFileList.rcString(subFileList.getFileList());
							break;
						case 3:
							keyboard.nextLine();
					        System.out.println("ENTER FILE NAME TO BE SEARCHED.");
					        String fileName = keyboard.nextLine();
					        System.out.println("ENTER DIRECTORY TO SEARCH UNDER.");
					        directoryName = keyboard.nextLine();
					        File stringToFile = new File(directoryName);
					        LocateFile absolutePath = new LocateFile(fileName,stringToFile);
					        absolutePath.fileSearch(fileName,stringToFile);
					        System.out.println(absolutePath.toString());
					        outputText += "\nChoice 3:\n" + absolutePath.toString();
					        break;
					    case 4:
					    	keyboard.nextLine();
					        System.out.println("ENTER EXTENSION TO BE SEARCHED.");
					        String extensionName = keyboard.nextLine();
					        System.out.println("ENTER DIRECTORY TO SEARCH UNDER.");
					        directoryName = keyboard.nextLine();
					        stringToFile = new File(directoryName);
					        LocateFile extensionAbsolutePath = new LocateFile(extensionName,stringToFile);
					        extensionAbsolutePath.extensionSearch(extensionName,stringToFile);
					        System.out.println(extensionAbsolutePath.extensionToString());
					        outputText += "\nChoice 4:\n" + extensionAbsolutePath.extensionToString();
					        break;
					    case 5:
					    	keyboard.nextLine();
					    	System.out.println("ENTER A FILE TO HAVE CONTENTS CONCATENATED.");
					    	String firstDirectory = keyboard.nextLine();
					    	System.out.println("ENTER FILE TO HAVE CONTENTS CONCATENATED.");
					    	String secondDirectory = keyboard.nextLine();
					    	System.out.println("ENTER FILE TO WRITE CONTENTS TO.");
					    	String outputFile = keyboard.nextLine();
					    	Concatenate combinedFiles = new Concatenate(firstDirectory,secondDirectory, outputFile);
					    	System.out.println(combinedFiles.readFiles());
					    	outputText += "\nChoice 5:\n" + combinedFiles.readFiles();
					    	break;
					    case 6:
					    	System.out.println("GOODBYE.");
							if(choice.equalsIgnoreCase("Y"))
							{
								LogFile dump = new LogFile(outputText, logFile);
								dump.dumpToLog();
							}	
							//System.out.println(outputText);			
							System.exit(0);
						default:
							System.out.println("INVALID CHOICE."); //if input a number not 1-6
							break;
					}//switch bracket
					options.printMenu();
					userChoice = keyboard.nextInt();
				}//while bracket
			}//try bracket
			catch(InputMismatchException e) //if user inputs anything not an int
			{
				keyboard.next(); //resets bad user input
				System.out.println("INVALID CHOICE.");
			}
		}//big while bracket
	}
}