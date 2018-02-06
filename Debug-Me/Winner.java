

/**
 * This program prints "a","b","c" depending on who has the highest score. The
 * given code may not be correct. Fix it and additional code to pass the unit
 * tests.
 * 
 * @see Winner-ReadMe.txt for details on how to complete this program.
 * @author jbucio4
 * 
 */
public class Winner {     
 
	public static void main(String[] args) {
		System.out.println("Enter three unique integer scores.");
		int a = TextIO.getlnInt();
		int b = TextIO.getlnInt();
		int c = TextIO.getlnInt();		
		int highestscore = a;
		char highestscorer = 'a';
				
							
		if (b > highestscore)		{
			highestscore= b;
			highestscorer  = 'b';
		}
		if (c > highestscore) {
			highestscore= c;
			highestscorer = 'c';
		}
					
				System.out.println("1st Place:"+""+ highestscorer); 
					
				
	
	}
	}
	//	if (a > b && a > c) 
		//	TextIO.putln("wow");
		// 
			
