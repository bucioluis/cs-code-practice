
/**
 * A program to search for to encrypt and decrypt lines of text. See
 * CaesarCipher.txt
 * Hints: line.charAt( int ) is useful.
 * You'll need loops, and conditions and variables
 * You'll need to read the Test cases to understand how your program should work.
 * Good Programming Hints: "DRY: Don't Repeat Yourself"
 * Try to make your program as short as possible.
 * TODO: add your netid to the line below
 * @author jbucio4
 */
public class CaesarCipher {

	public static void main(String[] strings) {
		//TODO: Delete the following line and write your implementation here-
	
		
		int counter = 0;
		boolean asked = false; 
		
		
		String prompt = "Please enter the shift value (between -25..-1 and 1..25)"; 
		TextIO.putln(prompt);
		while(counter !=999 && counter !=-999 && (counter==0 || counter>=26 || counter<=-26)){
			
			if(asked)
			{
				TextIO.putln(counter + " is not a valid shift value.");
				TextIO.putln(prompt);
			}
			counter = Integer.parseInt(TextIO.getln().trim());
			asked = true;
			
			if(counter==999||counter==-999){
				TextIO.putln("Using position shift");
				
			}else if((counter>0 && counter<=25 || counter>-26 && counter<0)){
				TextIO.putln("Using shift value of " + counter);
			}
			
		}
		
		
		
		//TextIO.putln("Using shift value of " + counter);
		boolean runcipher = true;
		String alphabet = "";
		while(runcipher){
			TextIO.putln("Please enter the source text (empty line to quit)");
			alphabet = TextIO.getln().trim();
			if(alphabet.length() == 0){
				runcipher= false;
			}
			
			if(runcipher){
				TextIO.putln("Source   :" + alphabet);
				String output = "";
				alphabet=alphabet.toUpperCase();
				for(int i=0; i< alphabet.length(); i++){
					int c = alphabet.charAt(i);
				
					if((c >='A') && (c <= 'Z')){
						int letter = c - 'A';
						int encrypted = (letter + counter) % 26;
						if(encrypted < 0)
						//{
						encrypted = encrypted + 26;
						//}
						c = (char) ('A' + encrypted);
						//output += (char)('A' + encrypted);
						
						if (counter==999){
							encrypted = (letter + i) % 26;
							output += (char)('A' + encrypted);
						}
						else if (counter==-999){
							encrypted = (letter - i) % 26;
							if(letter - i < 0){
								encrypted = 26 - ((i-letter) % 26);
								if(encrypted == 26){
									encrypted = 0;
									
									//output += (char)('A' + encrypted);
									}
								
								//output += (char)('A' + encrypted);
							}
							output += (char)('A' + encrypted);
							//TextIO.put(output);
							
						}
						else
						output += (char)('A' + encrypted);
						
					}
					else output += (char)c;
					
					
					
			
				}
			
			TextIO.putln("Processed:" + output);
			}
		}
		
		TextIO.putln("Bye.");
				}
		}

		
		// throw new RuntimeException ("Et tu Brutus?");
		
		

	


