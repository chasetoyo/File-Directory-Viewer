/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.io.File;
import java.util.Arrays;

public class SubdirectoryList
{
  private String directory;
  private File searchableDirectory;
  private File[] fileList;
  private String bigList = ""; //set it equal to empty string so null doesnt print out in beginning

  public SubdirectoryList(String directory)
  {
    setDirectory(directory);
    setSearchableDirectory(directory, searchableDirectory);
    setFileList(searchableDirectory);
    getDirectory();
    getSearchableDirectory();
    getFileList();
  }

  public SubdirectoryList()
  {
    directory = "";
    searchableDirectory = null;
    fileList = null;
  }

  public SubdirectoryList clone()
  {
    return new SubdirectoryList();
  }

  public void setDirectory(String directory)
  {
    this.directory = directory;
  }
  public void setSearchableDirectory(String directory, File searchableDirectory)
  {
    this.searchableDirectory = new File(directory);
  }
  public void setFileList(File searchableDirectory)
  {
    fileList = this.searchableDirectory.listFiles();
  }

  public String getDirectory()
  {
    return this.directory;
  }
  public File getSearchableDirectory()
  {
    return this.searchableDirectory;
  }
   public File[] getFileList()
  {
    return this.fileList;
  }

  //got stack overflow error with this so i had to switch to a different recursion method + i dont think it wwould have worked
  /*public String listString(String directory, File[] fileList)
  {
    bigList = "";
    for (File path: fileList)
    {
      if (path.isFile())
      {
        bigList += path.getName();
        bigList += "\n";
      }
      else if (path.isDirectory())
        listString(path.getParent(),this.fileList);
    }
    return "\n" + bigList; 
  }*/

  public String rcString(File[] fileList)
  {
    try
    {
      for (File file: fileList)
      {
        if (file.isFile())
          bigList += file.getName() + "\n";
        else if(file.isDirectory())
        {
          bigList += "--------------------------------------------------\n";
          bigList += "Directory:" + file.getName() +"\n";
          rcString(file.listFiles());
        }
      }
      return bigList;
    }
    catch(NullPointerException e)
    {
      return "NON-EXISTENT DIRECTORY.\n";
    }
  }
}