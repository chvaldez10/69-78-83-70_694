/**
 * Sort an array in ascending order using merge sort.
 */

package myLibrary.DataStructures.SearchSort;

public class Sort {
	public void X_Sort(int[] arr) { mergeSort(arr,  0, arr.length-1); }

	public static void mergeSort(int[] arr, int first, int last) {
		if(first < last) {
			int mid = (first+last)/2;
			mergeSort(arr, first, mid); // merge left side
			mergeSort(arr, mid+1, last); //merge right side
			merge(arr, first, mid, last); //merge the sorted halves
		}
	}

	public static void merge(int a[], int f, int m, int l){
		int nl = m-f+1;
		int nr = l-m;
		int i2=0, j2=0, k=f;

		int[] leftArr = new int[nl];
		int[] rightArr = new int[nr];

		for(int i=0; i<nl; ++i) leftArr[i] = a[f+i];
		for(int j=0; j<nr; ++j) rightArr[j] = a[j+m+1];

		// pick lower values from left/right array
		while (i2<nl && j2<nr) {
			if(leftArr[i2] < rightArr[j2]) {
				a[k] = leftArr[i2];
				i2++;
			} else {
				a[k] = rightArr[j2];
				j2++;
			}
			k++;
		}

		// copy remaining elements
		while(i2<nl) {
			a[k] = leftArr[i2];
			i2++;
			k++;
		}

		while(j2<nr) {
			a[k] = rightArr[j2];
			j2++;
			k++;
		}
	}
}
