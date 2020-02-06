/*
Chase Toyofuku-Souza
2296478
toyofukusouza@chapman.edu
*/

//shortening printing the menu in the main class by just calling this tostring
public interface Menu
{
	public final String MENU =
		"------------------------------------------------------------\n"+
		"|ENTER THE NUMBER CORRESPONDING TO WHAT ACTION YOU WANT DONE.\n" +
		"|1: LIST THE CONTENTS OF A DIRECTORY.\n" +
		"|2: LIST THE CONTENTS OF A DIRECTORY AS WELL AS ALL OF ITS SUB DIRECTORIES.\n" +
		"|3: LOCATE A FILE WITH A GIVEN NAME.\n" +
		"|4: LOCATE FILES WITH A GIVEN FILE EXTENSION.\n" +
		"|5: CONCATENATE THE CONTENTS OF TWO FILES AND OUTPUT THE RESULT TO A THIRD FILE.\n" +
		"|6: EXIT.\n" +
		"------------------------------------------------------------\n";
	public void printMenu();
}

