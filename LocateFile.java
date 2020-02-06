/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.io.File;
import java.util.Arrays;

public class LocateFile
{
	private String fileName;
	private File directoryName;
	private File[] pathnames;
	private String pathname = ""; //so it doesnt display null on top 

	public LocateFile(String fileName, File directoryName) //takes file name as string input and a file 
	{
		setFileName(fileName);
		setDirectoryName(directoryName);
		getFileName();
		getDirectoryName();
	}
	
	public LocateFile clone()
	{
		return new LocateFile();
	}


	public LocateFile()
	{
		fileName = "";
		directoryName = null;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public void setDirectoryName(File directoryName)
	{
		this.directoryName = directoryName;
	}

	public String getFileName()
	{
		return this.fileName;
	}

	public File getDirectoryName()
	{
		return this.directoryName;
	}

	public void fileSearch(String fileName, File directoryName)
	{
		try
		{
			pathnames = directoryName.listFiles(); //makes an array of path names for the files in the directory
			for (File path: pathnames)
			{
				if(path.isDirectory())
				{
					fileSearch(fileName,path);
				}
				else if(fileName.equalsIgnoreCase(path.getName())) //compares String names of the file in the directory array and the input file name
				{
					pathname += path.getParent() + "\n"; //continually adds parent paths of files to a string (if file with same name exists in multiple places) 
				}
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("\nNON-EXISTENT DIRECTORY.\n");
		}
	}

	public void extensionSearch(String fileName, File directoryName)
  	{
  		try
  		{
		    pathnames = directoryName.listFiles(); //makes an array of path names for the files in the directory
		    for (File path: pathnames)
		    {
		      if(path.isDirectory())
		      {
		        extensionSearch(fileName,path);
		      }
		      else if(path.getName().endsWith(fileName))
		      {
		        pathname += "\n" + path.getAbsolutePath();
		      }
		  	}
		  }
		  catch(NullPointerException e)
		  {
		  	System.out.println("\nNON-EXISTENT DIRECTORY.\n");
		  }
    }

	public String toString()
	{
		if (pathname == "")
			return "\n" + fileName + " DOES NOT EXIST IN THIS DIRECTORY.\n";
		return "\n" + fileName + " IS LOCATED AT\n" + pathname;

	}

	public String extensionToString()
	{
		if (pathname == "")
			return "\nNO FILES WITH EXTENSION: " + fileName + " ARE LOCATED IN THIS DIRECTORY.\n";
		return "\nFiles with extension: " + fileName + " ARE LOCATED AT" + pathname + "\n";
	}
}