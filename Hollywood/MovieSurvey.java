
/**
 * A program to run a simple survey and report the results. See MovieSurvey.txt
 * for more information. TODO: add your netid to the line below
 * 
 * @author jbucio4
 */
public class MovieSurvey {
	public static void main(String[] arg) {
		// TODO: Write your program here
		// Hints :
		// Formatted output
		// http://math.hws.edu/javanotes/c2/s4.html#basics.4.4
		
		//* Re-application of string and text processing
		//* Application of string features (trim, contains, toLowerCase, concatenation)
		//* Integer and Floating point arithmetic 
		
		System.out.println("Welcome. We're interested in how people are watching movies this year.");
		System.out.println("Thanks for your time. - The WRITERS GUILD OF AMERICA.");
		
		//* Next, the program should prompt for the following three quantities, in the following order: the number of movies watched at a cinema, using a dvd player, using a computer.
	    //* Next, the program should print out a summary of the input values.
		
	    //* Next, the program should print out the total number of movies seen in one month.
		
	    //* Next, the program should print out the percent of movies seen at the cinema to two decimal places.
	    //* Finally, the program should print out the percent of movies seen outside of the cinema to two decimal places.{
		System.out.println("Please tell us about how you've watched movies in the last month.");
		System.out.println("How many movies have you seen at the cinema?");
		double cinema = TextIO.getlnInt(); 
		System.out.println("How many movies have you seen using a DVD or VHS player?");
		double dvd = TextIO.getlnInt();
		System.out.println("How many movies have you seen using a Computer?");
		double computer = TextIO.getlnInt();
		double total = cinema + dvd + computer;
		double percentage;
		percentage = ((cinema*100)/total);
		double percentage2;
		percentage2 = ((dvd+computer)*100)/total;
		
		System.out.println("Summary: "+(int)cinema+" Cinema movies"+ ", "+(int)dvd+" DVD/VHS movies, "+(int)computer+" Computer movies");
		System.out.println("Total: "+(int)total+" movies");
		TextIO.put("Fraction of movies seen at a cinema: ");
		TextIO.putf("%.2f",percentage);
		TextIO.putln("%");
		TextIO.put("Fraction of movies seen outside of a cinema: ");
		TextIO.putf("%.2f", percentage2);
		TextIO.putln("%");
		}
		}

		
		
		// Don't just copy paste the expected output
		// For grading purposes your code may be tested
		// with other input values.
			


