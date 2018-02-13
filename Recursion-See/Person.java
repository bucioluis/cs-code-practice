
/**
 * @author jbucio4
 *
 */
public class Person
{
private final String name;
private final int age;
private final char gender;
private final Person child1; //left child
private final Person child2; //right child

public Person(String name, int age, char gender, Person c1, Person c2)
	{
    this.name=name;
    this.age=age;
    this.gender=gender;
    this.child1 = c1;
    this.child2 = c2;
	}

public String toString()
	{
    return name+"*"+age+"*"+gender;
	}

public String getName() 
	{
	return name;
	}

public int getAge() 
	{
	return age;
	}

public char getGender() 
	{
	return gender;
	}

public boolean equals(Person p)
	{
	return (this.name.equals(p.name)) &&
			(this.age==p.age) &&
			(this.gender==p.gender);
	}


public void print() 
	{
   System.out.println(this);
   if(child1 != null)
       child1.print();
   if(child2 != null)
       child2.print();
   
	}

public int count() // total person count including this object
	{
	//YOUR CODE HERE
	if (child2 == null && child2 == null)
		return 1;
	else if (child1 == null)
		return 1 + child2.count();
	else if (child1 == null)
		return 1 + child2.count();
	return (1 + child2.count() + child1.count());
	
	}
public int countGrandChildren() // but not greatGrandChildren
	{
	//YOUR CODE HERE
	return grandChild(0);
		}
		public int grandChild (int grand){
			grand++;
				if(grand == 3)
					return 1;
				if((child2 != null || child1 != null) && grand < 3 ){
					if (child2 == null){
						return child1.grandChild(grand);
					}
				if (child1 == null){
						return child2.grandChild(grand);
					}
					else{
						return child1.grandChild(grand) + child2.grandChild(grand);
						}
					}
					else return 0;
		}

public int countMaxGenerations()
	{
	//YOUR CODE HERE
		if(child2 == null && child1 == null)
			return 1;
		else if (child2 == null)
			return 1 + child1.countMaxGenerations();
	
		else if (child1 == null)
			return 1 + child2.countMaxGenerations();
	
		else if(child1 != null && child2 != null)
			if (child1.countMaxGenerations() > child2.countMaxGenerations())
				return 1 + child1.countMaxGenerations();
	
			else
				return 1 + child2.countMaxGenerations();
	  
		return 0;
	
}

public int countGender(char gen)
	{
	//YOUR CODE HERE
		if (child2 == null && child1 == null){
			if (this.gender == gen)
				return 1;
			else
				return 0;
		}
		if (child2 != null && child1 != null){
			if (this.gender == gen )
				return 1 + child1.countGender(gen) + child2.countGender(gen);
		else 
				return 0 + child1.countGender(gen) + child2.countGender(gen);
		}
		else if (child1 == null){
			 if (this.gender == gen)
				return 1 + child2.countGender(gen);
			else
				return 0 + child2.countGender(gen);	 
		}
			 else if (child2 == null){
				 if (this.gender == gen)
					 return 1 + child1.countGender(gen);
					 else
						 return 0 + child1.countGender(gen);
			 }
				return 0;
	}
	


public Person search(String name, int maxGeneration)
	{
	//YOUR CODE HERE
	Person unknown = null;
	maxGeneration--;
			if(unknown == null && this.name.equals(name))
				return this;
		
		if((child1 == null && child2 == null) || maxGeneration == 0){
			if(this.name.equals(name))
				return this;
			else
				return null;		
		}
		
		if((child1 != null || child2 != null) && maxGeneration != 0){
			 if(child2 == null){
				 unknown = child1.search(name, maxGeneration);
				 if(unknown !=null && unknown.name.equals(name))
					return unknown;
			}
			 
			 else if(child1 == null){
				 unknown = child2.search(name, maxGeneration);
				if(unknown !=null && unknown.name.equals(name))
					return unknown;
				}	
			else{
				unknown = child2.search(name, maxGeneration);
				if(unknown != null && unknown.name.equals(name))
					return unknown;
				
				unknown = child1.search(name, maxGeneration);
				if(unknown != null && unknown.name.equals(name))
					return unknown;
			}
		}
		return unknown;
	}

} // end of class
