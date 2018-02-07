
/**
 * A program to search for specific lines and print their line number.
 * See FindScriptLine.txt for more details
 * TODO: add your netid to the line below
 * @author jbucio4
 */


public class FindScriptLine {

	public static void main(String[] args) {
// TODO: Implement the functionality described in FindScriptLine.txt
		
		//You need to get the output exactly correct (including the printing a newline character at the end)
		//Look at the sample code in MyScriptPrinter for ideas about the basic structure of your program.
		//You need to use several string methods (see learning objectives) to solve this problem
		//You only need to compare one line at a time 
		//* Re-application of string and text processing
		//* Application of string features (trim, contains, toLowerCase, concatenation)
		
		int counter = 0;
		
		TextIO.putln("Please enter the word(s) to search for");
		
		String input = TextIO.getln();
		String lowercaseInput = input.toLowerCase().trim(); 

		System.out.println("Searching for '"+ input + "'");
		TextIO.readFile("thematrix.txt");

		while (false == TextIO.eof()) 
		{
			String line = TextIO.getln(); 
				counter++; 
			if(line.length() >= 0) 
			{
				if(line.toLowerCase().contains(lowercaseInput))
				{
					TextIO.putln(counter+ " - " + line.trim());	
				}
			}
		}
		System.out.println("Done Searching for '" + input + "'");

	}
}
// TODO: Test your code manually and using the automated unit tests in FindScriptLineTest		
			
	

