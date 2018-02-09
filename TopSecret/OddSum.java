//UIUC CS125 FALL 2014 MP. File: OddSum.java, CS125 Project: Challenge3-TopSecret, Version: 2015-02-16T07:03:45-0600.471425819
/**
 * Prints sum of odd numbers in a specific format.
 * TODO: add your netid to the line below
 * @author jbucio4
 */
public class OddSum { 
/**
Example output if user enters 10:
Max?
1 + 3 + 5 + 7 + 9 = 25
25 = 9 + 7 + 5 + 3 + 1

Example output if user enters 11:
Max?
1 + 3 + 5 + 7 + 9 + 11 = 36
36 = 11 + 9 + 7 + 5 + 3 + 1

 */
 public static void main(String[] args) { 

	 TextIO.putln("Max?");
	 int number = TextIO.getlnInt();
	 int sum = 0;
	 int count = 1 ;
	 String backwards = "";
	 if(number%2==0){
		 number= number-1;
	 }
	 while ( count <= number ){
		 //System.out.print(count);
		 backwards = backwards + count;
		 sum = sum + count;
		 count+=2;
		 if (count <= number)
			 backwards = backwards + " + ";
			 // System.out.print(" + ");
	}
	backwards = backwards + " = " + sum;
	 //System.out.print(" = ");	  
	//System.out.print(sum);
	 System.out.println(backwards);
//	 String reverse = "";
//	 reverse = sum + " = ";
	 TextIO.put(sum+" = ");
	 for(int i= number; i>=1; i-=2){
		 if(i==1){
			 TextIO.put(1);
			 break;
		 }
		 TextIO.put(i+" + ");
	 }
	 
  } // end of main method
 	
} // end of class 
