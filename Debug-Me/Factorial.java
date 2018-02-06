//UIUC CS125 FALL 2014 MP. File: Factorial.java, CS125 Project: Challenge1-DebugMe, Version: 2015-02-04T09:52:42-0600.340822045

/**
 * A program to calculate a factorial. The given code may contain errors. Fix the
 * given code and add additional code to calculate a factorial and pass the unit
 * tests. Hint sometimes an 'int' just 'aint big enough.
 * 
 * @see Factorial-ReadMe.txt for details on how to complete this program.
 * @author jbucio4
 */
public class Factorial {
	public static void main(String[] args) {
		int max = 0;
		System.out.println("Enter a number between 1 and 20 inclusive.");
		while (max < 1 || max >= 21) {
			max = TextIO.getlnInt();
			while(max <1 || max >= 21) { 
				TextIO.putln("Enter a number between 1 and 20 inclusive.");
				max = TextIO.getlnInt();
			}
		}
	int y = 1 ; 
	int  sub;
	long product=1; 
	int hi= max;
	while ( max >=1 && max <=20){
			
			sub = max -y;
			if(sub<1){
				product = product*max; 
				
				break;
				}
		
	
			product = product*max*sub; 
			max= sub -1; 
			//max --; 
			
			//1!=1
			
		
	
	}
	System.out.println(hi + "!"+ " = " +  product);
		
	}
					
		
}
	
	

