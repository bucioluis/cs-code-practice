//UIUC CS125 FALL 2014 MP. File: PlayListUtil.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-02-22T21:58:14-0600.814513453
/**
 * jbucio4
 * 
 * @author angrave
 * 
 */
public class PlayListUtil {

	/**
	 * Debug ME! Use the unit tests to reverse engineer how this method should
	 * work. Hint: Fix the formatting (shift-cmd-F) to help debug the following
	 * code
	 * 
	 * @param list
	 * @param maximum
	 */
	public static void list(String[] list, int maximum) {
		int i;
		if (maximum < 0)
		for (i = 0; i < list.length; i++){
			TextIO.putln("" + (i+1) + ". " + list [i]);
		}
		if (maximum >= 0)
			for (i = 0; i < (maximum); i++)
			TextIO.putln("" + (i+1) + ". " + list[i]);
	}
		
		
	/**
	 * Appends or prepends the title
	 * 
	 * @param list
	 * @param title
	 * @param prepend
	 *            if true, prepend the title otherwise append the title
	 * @return a new list with the title prepended or appended to the original
	 *         list
	 */
	public static String[] add(String[] list, String title, boolean prepend) {
		String [] addList = new String [list.length+1];
		if (prepend == true){
			addList[0] = title;
			for (int i=0; i < list.length; i++){
				addList[i+1] = list[i];
			}
		}
		else{
			for(int i=0; i < list.length; i++){
				addList[i] = list[i];
				addList[addList.length-1] = title;
			}
		}
		return addList;
	}

	/**
	 * Returns a new list with the element at index removed.
	 * 
	 * @param list
	 *            the original list
	 * @param index
	 *            the array index to remove.
	 * @return a new list with the String at position 'index', absent.
	 */
	public static String[] discard(String[] list, int index) {
		int number = index-1;
		String[] addList = new String[list.length-1];
		if(index>=0)
			while ((index+1) < list.length){
				addList[index] = list[index+1];
				index++;
			}
		while(number>=0){
			addList[number]=list[number];
			number--;
		}
		return addList;
	}

}
