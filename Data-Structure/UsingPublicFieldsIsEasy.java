//UIUC CS125 FALL 2014 MP. File: UsingPublicFieldsIsEasy.java, CS125 Project: Challenge5-DataStructures, Version: 2015-03-09T23:37:12-0500.058332832

/**
 * Complete the class method 'analyze' that takes a SimplePublicPair object as an argument
 * and returns a new SimplePublicTriple object.
 * The SimplePublicTriple needs to set up as follows:
 * x = the minimum value of 'a' and 'b'
 * y = the maximum value of 'a' and 'b'
 * description:a*b=M 
 *   where a,b, and M are replaced with the numerical values of a, b and the multiplication of a and b.
 * Your code will create a SimplePublicTriple, initializes the three fields and return a reference to the SimplePublicTriple object.
 * @author jbucio4
 */
public class UsingPublicFieldsIsEasy {
	
	public static SimplePublicTriple analyze(SimplePublicPair in) {
            SimplePublicTriple output = new SimplePublicTriple();
            output.x = Math.min(in.a, in.b);
            output.y = Math.max(in.a, in.b);
            output.description=""+in.a+"*"+in.b +"="+(in.a*in.b);
            return output;

		
	}
}
