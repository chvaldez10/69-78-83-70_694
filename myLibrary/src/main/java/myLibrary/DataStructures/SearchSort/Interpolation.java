/**
 * Class to search for key using interpolation search
 *
 * Uses: Sort.java
 *
 * @author Christian Valdez
 */

package myLibrary.DataStructures.SearchSort;

import java.util.Arrays;

public class Interpolation {
	private Sort sort = new Sort();

	public int interpolationSearchIterative(int[] array, int key) {
		int left = 0;
		int right = array.length-1;
		int mid, pos;
		int[] arrayCopy = new int[right+1];

		// create copy of array
		for (int i=0; i<right; i++) arrayCopy[i] = array[i];
		sort.X_Sort(arrayCopy);

		while(left <= right) {
			pos = (key-arrayCopy[left])/(arrayCopy[right]-arrayCopy[left]);
			mid = left + (right-left)*pos;

			if(arrayCopy[mid] < key) left = mid + 1;
			else if (key < arrayCopy[mid]) right = mid - 1;
			else return mid; //key found
		}

		return -1; //key not found
	}
}
