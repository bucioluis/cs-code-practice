
/**
 * See CipherBreaker.txt for instructions.
 * TODO: add your netid to the line below
 * 
 * @author jbucio4
 */
public class CipherBreaker {

	public static void main(String[] args) {
		
		
		
		int i = 0;
		int j;
		int space=0;
		int digit=0;
		int dot = 0;
		char letter;
		
		TextIO.putln("Text?");
		String line = TextIO.getln();
		TextIO.putln(line);
		line=line.toUpperCase();
		
		int [] Array = new int [26];
		
		for (i=0; i<=line.length()-1; i++)
		{
			letter=line.charAt(i);
			
			if ((int)(letter)>=48 && (int)(letter) <=57)
					digit++;
			
			if(letter == ' ')
				space++;
			
			if(letter== '\"' || letter == '-' ||  letter == '\'' || letter == '.' || letter == '!' || letter== ','  )
				dot++;
			
			for (j=0;j<=25;j++){
				
				if(letter==(char)(j+65))
					
					Array[j]++;
			}
		}
		
		
				for(j=0;j<=25;j++)
				{
					if(Array[j] !=0)
						
					TextIO.putln((char)(j+65) + ":" + Array[j]);
				}
				
				if(digit > 0)
					TextIO.putln("DIGITS:" + digit);
				if(space > 0)
					TextIO.putln("SPACES:" + space);
				if(dot > 0)
					TextIO.putln("PUNCTUATION:" + dot);
				
	}
	
	
}
						
				
					
		
		
	

