//UIUC CS125 FALL 2014 MP. File: Queue.java, CS125 Project: Challenge5-DataStructures, Version: 2015-03-09T23:37:12-0500.058332832

public class Queue {
	private double [] Queen = new double [1];
	private int size = 0;
	/** Adds the value to the front of the queue.
	 * Note the queue automatically resizes as more items are added. 
	 * @author jbucio4
	 **/
	public void add(double value) {
		if (size == Queen.length) {
			double [] temp = new double [size * 2];
			for (int i = 0; i < size; i++)
				temp[i] = Queen[i];
			Queen = temp;
		}
		
		Queen[size++] = value;
	}
	/** Removes the value from the end of the queue. If the queue is empty, returns 0 */
	public double remove() {
		if (size == 0)
			return 0;
		double j = Queen [0];
		size--;
		for (int i = 0; i< size;)
			Queen [i] = Queen [++i];
				return j;
	}
	
	/** Returns the number of items in the queue. */
	public int length() {
		return size;		
	}
	
	/** Returns true iff the queue is empty */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/** Returns a comma separated string representation of the queue. */
	public String toString() {
		StringBuffer Me =  new StringBuffer();
		for (int i = 0; i<size; i++) {
			if( i > 0)
					Me.append(",");
				Me.append(Queen[i]);
		}
		return Me.toString();
	}
}
