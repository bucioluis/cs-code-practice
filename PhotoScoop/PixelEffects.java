

/* A class to implement the various pixel effects.
 *
 * Todo: Put your netid (i.e. username) in the line below
 * 
 * @author jbucio4
 */
public class PixelEffects {
	
	

	/** Copies the source image to a new 2D integer image */
	public static int[ ][ ] copy(int[ ][ ] source) {
		
		
		int height = source[0].length;
		int [][] Array = new int [source.length][height];
		for (int i =0; i < source.length; i++)
			for(int j=0; j<height; j++)
				Array [i][j] = source [i][j];
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		return Array;// Fix Me
	}                
	
	/**
	 * Resize the array image to the new width and height
	 * You are going to need to figure out how to map between a pixel
	 * in the destination image to a pixel in the source image
	 * @param source
	 * @param newWidth
	 * @param newHeight
	 * @return
	 */
	public static int[][] resize(int[][] source, int newWidth, int newHeight) {
		
		int [] [] picture = new int [newWidth] [newHeight];
		
		for (int i = 0; i < newWidth; i++){
			for(int j = 0; j < newHeight; j++){
				picture[i][j] = source[(int) ((i/(double)newWidth*source.length))] [(int) ((j/(double)newHeight)* source[0].length)];
			}
		}
		// Create a NEW 2D integer array and copy the colors across
		// See redeye code below
		return picture; // Fix Me
	
		//return null; // Fix Me
		// Hints: Use two nested for loops between 0... newWidth-1 and 0.. newHeight-1 inclusive.
		// Hint: You can just use relative proportion to calculate the x (or y coordinate)  in the original image.
		// For example if you're setting a pixel halfway across the image, you should be reading half way across the original image too.
	}

	/**
	 * Half the size of the image. This method should be just one line! Just
	 * delegate the work to resize()!
	 */
	
	public static int[][] half(int[][]source){
		return resize(source, (int)(0.5*source.length) , (int)(0.5*source[0].length) );  // Fix Me
}

	
	/**
	 * Create a new image array that is the same dimesions of the reference
	 * array. The array may be larger or smaller than the source. Hint -
	 * this methods should be just one line - delegate the work to resize()!
	 * 
	 * @param source
	 *            the source image
	 * @param reference
	 * @return the resized image
	 */
	public static int[ ][ ] resize(int[ ][ ]source, int[ ][ ]reference) {
		int [ ][ ] picture = source;
		return resize(picture, reference.length, reference[0].length); // Fix Me
	}

	/** Flip the image vertically */
	public static int[ ][ ] flip(int[ ][ ] source) {
		int [ ] [ ] picture = new int [source.length] [source[0].length];
		for(int i=0; i < source.length; i++){
			for (int j=0; j < source[0].length; j++){
				int X = source[0].length -1 - j;
				picture [i][j] = source[i][X];
			}
		}
		return picture;// Fix Me
	}

	/** Reverse the image horizontally */
	public static int[ ][ ] mirror(int[ ][ ] source) {
		int [ ] [ ] picture = new int [source.length] [source[0].length];
		for (int i = 0; i < source[0].length; i++){
			for(int j = 0; j < source.length; j++){
				int X = source.length - 1 - j;
				picture [j][i] = source[X][i];
				}
		//return null Fix Me
		}
		return picture;
	}

	/** Rotate the image */
	public static int[ ][ ] rotateLeft(int[ ][ ] source) {
		int [ ] [ ] picture = new int [source[0].length] [source.length];
		
		for (int i=0; i < source[0].length; i++){
			for(int j=0; j < source.length; j++){
				picture[i][j] = source[source.length - 1 - j][i];
			}
		}
		return picture;
	}

	/** Merge the red,blue,green components from two images */
	public static int[ ][ ] merge(int[ ][ ] sourceA, int[ ][ ] sourceB) {
		// The output should be the same size as the input. Scale (x,y) values
		// when reading the background
		// (e.g. so the far right pixel of the source is merged with the
		// far-right pixel ofthe background).
		int [ ] [ ] picture = new int [sourceA.length] [sourceA[0].length];
		picture = resize(sourceA,sourceB);
		
		for(int i=0; i < sourceA.length; i++)
			for (int j = 0; j < sourceA[i].length; j++) {
				int rgb1 = sourceA[i][j];
				int rgb2 = sourceB[i][j];
				picture [i][j] = RGBUtilities.toRGB((RGBUtilities.toRed(rgb1) + RGBUtilities.toRed(rgb2))/2,
				(RGBUtilities.toGreen(rgb1) + RGBUtilities.toGreen(rgb2))/2,
				(RGBUtilities.toBlue(rgb1) + RGBUtilities.toBlue(rgb2))/2);
			}
		return picture;
	}

	/**
	 * Replace the green areas of the foreground image with parts of the back
	 * image
	 */
	public static int[][] chromaKey(int[][] foreImage, int[][] backImage) {
		// If the image has a different size than the background use the
		// resize() method
		// create an image the same as the background size.
		int width = foreImage.length, height = foreImage[0].length;
		int[][]picture = new int[width][height];
		picture = resize(foreImage,backImage);
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++){
				int rgb = picture[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if ((green > 64) && (green > Math.max(blue,red)))
					picture[i][j]=backImage [i][j];
				
			}
		return picture;	
	}
	

	/** Removes "redeye" caused by a camera flash. sourceB is not used */
	public static int[ ][ ] redeye(int[ ][ ] source, int[ ][ ] sourceB) {

		int width = source.length, height = source[0].length;
		int[ ][ ] result = new int[width][height];
		for (int i = 0; i < width; i++)
			for (int j = 0; j < height; j++) {
				int rgb = source[i][j];
				int red = RGBUtilities.toRed(rgb);
				int green = RGBUtilities.toGreen(rgb);
				int blue = RGBUtilities.toBlue(rgb);
				if (red > 4 * Math.max(green, blue) && red > 64)
					red = green = blue = 0;
				result[i][j] = RGBUtilities.toRGB(red, green, blue);
			}

		return result;
	}

	/* Upto you! do something fun to the image */
	public static int[ ][ ] funky(int[ ][ ] source, int[ ][ ] sourceB) {
		// You need to invent your own image effect
		// Minimum boring requirements to pass autograder:
		int [ ][ ] picture = new int[source.length] [source[0].length];
		for (int i=0; i < source.length; i++){
			for (int j=0; j < source[i].length; j++){
			int Y = source[i].length-1-j;
		picture [i][j] = source [i][Y];
			}
		}
		
		// Does not ask for any user input and returns a new 2D array
		// Todo: remove this return null
		return picture; // Fix Me
	}
}
