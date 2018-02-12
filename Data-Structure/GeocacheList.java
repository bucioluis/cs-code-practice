//UIUC CS125 FALL 2014 MP. File: GeocacheList.java, CS125 Project: Challenge5-DataStructures, Version: 2015-03-09T23:37:12-0500.058332832
/**
 * Complete the following GeocacheList, to ensure all unit tests pass.
 * There are several errors in the code below
 *
 * Hint: Get the Geocache class working and passing its tests first.
 * @author jbucio4
 */
public class GeocacheList {
	private Geocache[] dataList = new Geocache[0];
	private int size = 0;

	public Geocache getGeocache(int i) {
		return dataList [i];
	}

	public int getSize() {
		return size;
	}

	public GeocacheList() {
	}

	public GeocacheList(GeocacheList other, boolean deepCopy) {
		dataList = new Geocache[other.dataList.length];
		size = other.size;
		for (int i = 0; i < size; i++)
			dataList [i] = deepCopy ? new Geocache (other.dataList[i]): other.dataList[i];
		
	}

	public void add(Geocache p) {
		size++;
		if (size > dataList.length) {
			Geocache[] sum = dataList;
			dataList = new Geocache[size * 2];
			for (int i = 0; i < sum.length; i++)
				dataList[i] = sum[i];
		}
		dataList[size-1] = p;
	}

	public Geocache removeFromTop() {
		return dataList [--size];
	}

	public String toString() {
		StringBuffer x = new StringBuffer("GeocacheList:");
		for (int i = 0; i < size; i++) {
			if (i > 0)
				x.append(',');
			x.append(dataList[i]);
		}
		return x.toString();
}	}
