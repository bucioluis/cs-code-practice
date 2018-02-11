

/**
 * This class does nothing worth talking about.
 * Go away. You can edit this file if you want but you don't
 * There's nothing gradeable here. Please stop reading.
 * It's probably just some spare code. I'm sure it does
 * nothing useful. It might even not be good code to read.
 * I'm sure there are more pressing physics/chemistry/math
 * assignments that you could be doing.
 * It won't help. You won't learn anything. I'm surprised
 * that you still have this file open. Just close it now
 * and be done with it. You could be browsing Facebook
 * like the rest of the world. Creativity... Making things...
 * Solving problems is over-rated. There's plenty of day 
 * jobs at fast food places. You could be a real-people
 * person there instead of just staring at the screen.
 * Don't forget you've got graded homework, friends etc
 * to think about. I'd stop thinking about this file.
 * Ok don't. But just because I'm not trying reverse
 * psychology doesn't mean it wont not negatively fail.
 * This message is longer than a tweet so I'm sure you've
 * stopped reading by now.
 * 
 * TL;DR good.
 * 
 * @author angrave
 *
 */
public class Stenography {

	/**
	 * Hides one image inside another using bit operations.
	 * Be sure to save hidden images as 'something.png' - otherwise the jpg compression
	 * will tend to destroy the lowest bit information.
	 * @param mainImage - the decoy image
	 * @param secretImage - the secret image
	 * @return a new image with the secret image resized and embedded inside the other image
	 * 
	 */
	public static int[][] hide(int[][] mainImage, int[][] secretImage) {
		int width = mainImage.length, height = mainImage[0].length;
		int[][] resizedSecret = PixelEffects.resize(secretImage, mainImage);
		int[][] result = new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int secretRGB = resizedSecret[i][j]; 
				int sRed = RGBUtilities.toRed(secretRGB);
				int sGreen = RGBUtilities.toGreen(secretRGB);
				int sBlue = RGBUtilities.toBlue(secretRGB);
				
				// main decoy image should be something unremarkable
				int rgb = mainImage[i][j]; 
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				
				red = (red & 0xf0) | (sRed >>4);
				blue = (blue & 0xf0) | (sBlue >>4);
				green =(green & 0xf0) | (sGreen >>4);
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}
		}
		return result;
	}

	public static int[][] extract(int[][] source) {
		int width = source.length, height = source[0].length;

		int[][] result = new int[width][height];
		
		
		return result;

		
		// See I told you this method does nothing.
		// 
		// Besides  I doubt that you could create the extract method
		// based on the code inside the hide method.
		
	}

}
