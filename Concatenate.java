/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Concatenate 
{
	private String stringFirstInput;
	private String stringSecondInput;
	private String stringOutputFile;
	private File firstFile;
	private File secondFile;
	private File outputFile;
	private String outputText; //what will be written to output file
	private Scanner inputStream;
    private Scanner inputStream2;
    private PrintWriter outputStream;
    private String firstText;  //contents of first input file
    private String secondText; //contents of second input file
 	
 	//create object that takes 3 file names as string input and changes them into file type
	public Concatenate(String stringFirstInput, String stringSecondInput, String stringOutputFile) 
	{
		setStringFirstInput(stringFirstInput, firstFile);
		setstringSecondInput(stringSecondInput, secondFile);
		setOutputFile(stringOutputFile, outputFile);
		getFirstFile();
		getSecondFile();
		getOutputFile();
	}

	public Concatenate()
	{
		stringFirstInput = "";
		stringSecondInput = "";
		stringOutputFile = "";
	}

	public Concatenate clone()
	{
		return new Concatenate();
	}

	public void setStringFirstInput(String stringFirstInput, File firstFile)
	{
		this.firstFile = new File (stringFirstInput);
	}

	public void setstringSecondInput(String stringSecondInput, File secondFile)
	{
		this.secondFile = new File(stringSecondInput);
	}

	public void setOutputFile(String stringOutputFile, File outputFile)
	{
		this.outputFile = new File(stringOutputFile);
	}

	public File getFirstFile()
	{
		return firstFile;
	}

	public File getSecondFile()
	{
		return secondFile;
	}

	public File getOutputFile()
	{
		return outputFile;
	}

	public String readFiles()
	{
		firstText = "";//so it doesnt print null
		secondText = "";

		try
    	{
        	inputStream =
        		new Scanner(new FileInputStream(firstFile));
            inputStream2 = 
            	new Scanner(new FileInputStream(secondFile));
        }
        catch(FileNotFoundException e)
        {
            return ("\nFILE " + firstFile + " OR " + secondFile + " NOT FOUND OR COULD NOT BE OPENED.\n");
        }

        try
        {
            outputStream = 
                 new PrintWriter(new FileOutputStream(outputFile));
        }
        catch(FileNotFoundException e)
        {
            return ("ERROR OPENING FILE " + outputFile);
        }

        try
        {
	       	while (inputStream.hasNextLine())
		    {
	            firstText += inputStream.nextLine()+ System.lineSeparator();//make a new line in the string 
		    }
		    while (inputStream2.hasNextLine())
		    {
		    	secondText += inputStream2.nextLine() + System.lineSeparator();
		    }
		    outputStream.println(firstText+secondText);
	        inputStream.close();
	        inputStream2.close();
	        outputStream.close();
	    }
	    catch(NullPointerException e)
	    {
	    	return ("FILE(S) DO NOT EXIST.");
	    }

	    return "WRITTEN TO FILE: " + outputFile.getName() + "\n"; //final return statement if no exceptions are thrown
	    														  //states that the files could be concatenated 
   	}
}