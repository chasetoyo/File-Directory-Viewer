/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/
import java.io.File;
import java.util.Arrays;

public class ListFiles 
{
  private String directory;
  private File searchableDirectory;
  private String[] fileList;
  private String bigList;

  public ListFiles(String directory)
  {
    setDirectory(directory);
    setSearchableDirectory(directory, searchableDirectory);
    setFileList(searchableDirectory);
  }

  public ListFiles()
  {
    directory = "";
    searchableDirectory = null;
    fileList = null;
  }

  public ListFiles clone()
  {
    return new ListFiles();
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
    fileList = this.searchableDirectory.list();
  }

  public String getDirectory()
  {
    return this.directory;
  }
  public File getSearchableDirectory()
  {
    return this.searchableDirectory;
  }
   public String[] getFileList()
  {
    return this.fileList;
  }

  public String toString()
  {
    try
    {
      bigList = "";
      for (String s: fileList)
      {
        bigList += s;
        bigList += "\n";
      }
      return "\n" + bigList;
    }
    catch (NullPointerException e)
    {
      return "NON-EXISTENT DIRECTORY.\n";
    }
  }
}