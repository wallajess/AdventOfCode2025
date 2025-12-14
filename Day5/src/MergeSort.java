import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    static void merge(List<String> arr, int l, int m, int r){
      //Find sizes of the two halves
        int n1 = m-l +1;
        int n2 = r-m;

        //Create temporary arrays
        List<String> L = new ArrayList<>();
        List<String> R = new ArrayList<>();

        //Copy data to the temp arrays
        for (int i = 0; i < n1; i++) {
            L.add(arr.get(l + i));
        }

        for (int j = 0; j < n2; j++)
            R.add(arr.get(m + 1 + j));

        //initial index of first and second subarrays
        int i = 0, j = 0;

        //Initial index of merged subarray array
        int k = l;

        //Merge temporary arrays
        while (i < n1 && j < n2) {
            //start for item in L
            IDRange IDRangeL = new IDRange(L.get(i));
            long startL = IDRangeL.findStart();
            //start for item in R
            IDRange IDRangeR = new IDRange(R.get(j));
            long startR = IDRangeR.findStart();

            if (startL <= startR) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        //Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k,L.get(i));
            i++;
            k++;
        }

        //Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(List<String> arr, int l, int r){

        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
