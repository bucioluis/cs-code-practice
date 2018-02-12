//UIUC CS125 FALL 2014 MP. File: Stack.java, CS125 Project: Challenge5-DataStructures, Version: 2015-03-09T23:37:12-0500.058332832

public class Stack {
	/** Adds a value to the top of the stack.
	 * @author jbucio4
	 **/
	private String [] infoList = new String [16];
	private int size = 0;
	public void push(String value){
		if (size == infoList.length ) {
			String [] temp = new String [size * 2];
			for (int i = 0; i < size; i++)
				temp[i] = infoList[i];
			infoList = temp; 
		}
		infoList [size++] = value;
	}
	
	/** Removes the topmost string. If the stack is empty, returns null. */
	public String pop() {
		if (size == 0)
			return null;
		return infoList[--size];
	}
	
	/** Returns the topmost string but does not remove it. If the stack is empty, returns null. */
	public String peek() {
		if (size == 0)
			return null;
		return infoList[size - 1];
	}
	
	/** Returns true iff the stack is empty */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the number of items in the stack. */
	public int length() {
		return size;
	}
	
	/** Returns a string representation of the stack. Each string is separated by a newline. Returns an empty string if the stack is empty. */
	public String toString() {
		StringBuffer New =  new StringBuffer();
		for (int i = 0; i< size; i++) {
			New.append( infoList[i]);
			New.append("\n");
		}
		return New.toString();
	}
}
