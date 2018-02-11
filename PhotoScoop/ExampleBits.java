//UIUC CS125 FALL 2014 MP. File: ExampleBits.java, CS125 Project: Challenge4-Photoscoop, Version: 2015-02-22T21:58:14-0600.814513453

public class ExampleBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<16;i++) {
			TextIO.putln(i+ " "+Integer.toHexString(i)+ " : "+Integer.toBinaryString(i));
		}
	}
}
