//UIUC CS125 FALL 2014 MP. File: GridCounting.java, CS125 Project: Challenge7-RecursiveKnight, Version: 2015-04-20T07:56:24-0500.863101473

public class GridCounting {
	/** Returns the total number of possible routes (paths) from
	 * (x,y) to (tx,ty).
	 * There are only three valid kinds of moves:
	 *  Increment x by one.
	 *  Increment x by two.
	 *  Increment y by one.
	 *  
	 *  Hint: You'll need to test two base cases.
	 *  @author jbucio4
	 */
	public static int count(int x,int y, int tx, int ty) {
		if ( x == tx && y == ty) return 1;
		if ( x > tx || y > ty) return 0;
		if ( x == tx) return count(x, y+1, tx, ty);
		if ( y == ty) return count(x+1, y, tx, ty) + count(x+2, y, tx, ty);
		if ( x < tx) return count(x+1, y, tx, ty) + count(x+2, y, tx, ty) + count(x, y+1, tx, ty);
		if (y < tx) return count(x, y+1, tx, ty);
		return 0;
	}
}
