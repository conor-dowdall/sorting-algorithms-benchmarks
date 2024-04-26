package conordowdall.sorters;

/**
 * Implements an algorithm to sort an array of integers in ascending order.
 * Code taken from:
 * https://www.geeksforgeeks.org/counting-sort/
 */
public class CountingSort implements Sorter {
    public String name() {
        return "Counting Sort";
    }

    /**
     * Reference: https://www.geeksforgeeks.org/counting-sort/
     * 
     * @param arr - the array of integers to sort in ascending order.
     * 
     */
    public void sort(int[] arr) {
        System.arraycopy(countingSort(arr), 0, arr, 0, arr.length);
    }

    /**
     * This is a non-comparison-based sort!
     * 
     * @param arr - the array of integers to sort in ascending order.
     * @return the sorted array
     */
    private int[] countingSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        // find the max
        for (int i = 0; i < N; i++)
            M = Math.max(M, inputArray[i]);

        // create a new array with max+1 elements
        // this is like a histogram of the input array
        int[] countArray = new int[M + 1];

        // fill the histogram
        for (int i = 0; i < N; i++)
            countArray[inputArray[i]]++;

        // use the histogram data to calculate the position value for each element
        for (int i = 1; i <= M; i++)
            countArray[i] += countArray[i - 1];

        // create output array of correct size
        int[] outputArray = new int[N];

        // sort the input elements into their correct positions, using the
        // previously calculated position values
        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            // account for duplicate elements
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

}
