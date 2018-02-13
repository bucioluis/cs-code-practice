
/**
 * @author jbucio4
 *
 */
public class GeneAnalysis
{
	/** Wrapper method. Returns the length of the longest 
	 * common subsequence
	 */
	public static int score(String gene1, String gene2)
	{
		// Hint: Use toCharArray() to convert each string to a char array.
		 // call your recursive implementation here with
		// the genes as char arrays, starting at the end of each gene.
		char[] DNA = gene1.toCharArray();
		char[] newDna = gene2.toCharArray();
		
		return GeneAnalysis.Keeper(DNA, newDna, DNA.length-1, newDna.length-1);
	}
	/** Implements longest common subsequence recursive search
The recursive case is defined as
					S(i-1, j)
S(i,j) = max {		S(i,j-1)
					S(i-1,j-1)
					S(i-1,j-1) +1 if gene1[i] = gene2[j]

NB  0<=i < gene1.length
    0<=j < gene2.length

You need to figure out the base case.
	 * */
//	define a private recursive Class method 'score' that 
//	returns an integer the score.
//	The method should take four parameters- 
//	two char arrays and two integers (gene1,gene2,i,j)
//	i and j are the indices into gene1 and gene2 respectively.
private static int Keeper(char[] a, char[] c, int i, int j){
		if(i == -1 || j == -1)
			return 0;
	
		if(c[j] == a[i])
			return Keeper(a,c,i-1,j-1) + 1;
	
		else if (Keeper(a, c, i-1, j) > Keeper(a, c, i, j-1))
			return Keeper(a, c, i-1, j);
		else
			return Keeper(a, c, i, j-1);
	}
}


// Use local variables to store a recursive result so that you  do not need to calculate it again.

// Do not use a loops.
