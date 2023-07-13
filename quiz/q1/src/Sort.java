import java.util.Arrays;

class Sort implements Constants{
    public static void quickSort(int[] a, int f, int l){
        if(f<l){
            int p = partition(a, f, l);
            quickSort(a, f, p-1);
            quickSort(a, p+1, l);
        }
    }


    public static int partition(int[] a, int f, int l) {
        int pivot = a[l];
        int i = f-1;

        for(int j=f; j<=l-1; j++){
            if(a[j] < pivot){
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        int tmp1 = a[i+1];
        a[i+1] = a[l];
        a[l] = tmp1;

        return i+1;
    }

    public static int partitionFirst(int[] a, int f, int l) {
        int pivot = a[f];
        int i = f+1;

        for(int j=f+1; j<=l; j++){
            if(a[j] < pivot){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }

        int tmp1 = a[f];
        a[f] = a[i-1];
        a[i-1] = tmp1;

        return i-1;
    }

    public static void mergeSort(int[] arr, int first, int last) {
        if(first < last) {
            int mid = (first+last) / 2;
            mergeSort(arr, first, mid);
            mergeSort(arr, mid+1, last);
            merge(arr, first, mid, last);
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

    public static void bubbleSort(int[] a) {
        for(int i=0; i<a.length-1; i++) {
            for(int j=a.length-1; j>i; j--) {
                if(a[j] < a[j-1]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortReverse(int[] a) {
        for(int i=0; i<a.length-1; i++) {
            for(int j=a.length-1; j>i; j--) {
                if(a[j] > a[j-1]) {
                    int tmp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    public static void selectionSort(int[] a){
        for(int i=0; i<a.length-1; i++){
            int min = i;
            for(int j=i+1; j<a.length; j++) if (a[j] < a[min]) min = j;
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }

    public static void selectionSortReverse(int[] a){
        for(int i=0; i<a.length-1; i++){
            int min = i;
            for(int j=i+1; j<a.length; j++) if (a[j] > a[min]) min = j;
            int tmp = a[min];
            a[min] = a[i];
            a[i] = tmp;
        }
    }

    public static void insertionSort(int[] a){
        for(int i=1, j; i<a.length; i++){
            int tmp = a[i];
            for(j=i-1; j>=0 && tmp<a[j]; j--) a[j + 1] = a[j];
            a[j+1] = tmp;
        }
    }

    public static void insertionSortReverse(int[] a){
        for(int i=1, j; i<a.length; i++){
            int tmp = a[i];
            for(j=i-1; j>=0 && tmp>a[j]; j--) a[j+1] = a[j];
            a[j+1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {15, 4, 55, 51, 90, 14, 12, 50, 95, 23};

        System.out.println("pre srt " + Arrays.toString(arr));
//        quickSort(arr,0 ,arr.length-1);
        insertionSort(arr);
        System.out.println("post srt " + Arrays.toString(arr));
    }
}
