/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileOutputStream;

public class LogFile 
{
	private PrintWriter outputStream;
	private String fileString;
	private String results;
	private File logFile;

	public LogFile(String results, String fileString)
	{
		setLogFile(fileString, logFile);
		setResults(results);
		getLogFile();
		getResults();
	}

	public LogFile()
	{
		results = null;
		fileString = "default.txt";
	}

	public LogFile clone()
	{
		return new LogFile();
	}

	public void setLogFile(String fileString, File logFile)
	{
		this.logFile = new File(fileString);
	}

	public void setResults(String results)
	{
		this.results = results;
	}

	public File getLogFile()
	{
		return logFile;
	}

	public String getResults()
	{
		return results;
	}

	public void dumpToLog()
	{
		outputStream = null;
		try
	    {	
	        outputStream = 
            	new PrintWriter(new FileOutputStream(logFile));
	    }
	    catch(FileNotFoundException e)
	    {
	    	System.out.println("ERROR OPENING FILE " + logFile);
	    }

	    outputStream.println(results);
	    outputStream.close();
	}
}