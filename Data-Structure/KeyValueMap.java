//UIUC CS125 FALL 2014 MP. File: KeyValueMap.java, CS125 Project: Challenge5-DataStructures, Version: 2015-03-09T23:37:12-0500.058332832
import java.awt.Color;

public class KeyValueMap { // aka Dictionary or Map
	 private Color [] color = new Color[0];
	 private String [] pic = new String[0];
	
	/**
	 * Adds a key and value. If the key already exists, it replaces the original
	 * entry.
	 * @author jbucio4
	 */
	public void add(String key, Color value) {
		Color [] newColor = new Color [this.color.length + 1];
		String [] newKey = new String[this.pic.length + 1];
		for (int i = 0; i < this.color.length; i++){
			newColor[i] = color[i];
		}
		for(int i = 0; i < this.pic.length; i++){
			newKey[i] = pic[i];
		}
		newColor[this.color.length] = value;
		newKey[this.pic.length] = key;
		this.color = newColor;
		this.pic = newKey;
	}

	/**
	 * Returns particular Color object previously added to this map.
	 */
	public Color find(String key) {
		for(int i = 0; i < this.color.length; i++){
			if(key.equals(this.pic[i])){
				return this.color[i];
			}
		}
		return null;
	}
	  
	

	/**
	 * Returns true if the key exists in this map.
	 */
	public boolean exists(String key) {
		return find(key) != null;
		
	}
		

	/**
	 * Removes the key (and the color) from this map.
	 */
	public void remove(String key) {
		int location = 0;
		Color [] newColor = new Color[this.color.length - 1];
		String [] newKey = new String[this.pic.length - 1];
		if(exists(key)){
			Color finder = find(key);
			for(int i = 0; i < this.color.length; i++){
				if(this.color[i].equals(finder)){
					location = i;
				}
			}
			
			for (int i = 0; i < location; i++){
				newKey[i] = this.pic[i];
				newColor[i] = this.color[i];
			}
			
			for (int i = location; i < this.color.length - 1; i++){
				newKey[i] = this.pic[i + 1];
				newColor[i] = this.color[i + 1];
			}
			
			this.color = newColor;
			this.pic = newKey;
		}
		
	}
	
}




