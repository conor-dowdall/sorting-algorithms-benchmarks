package conordowdall.sorters;

/**
 * Implements an algorithm to sort an array of integers in ascending order.
 * Code taken from:
 * https://www.geeksforgeeks.org/java-program-for-insertion-sort/
 */
public class InsertionSort implements Sorter {
    public String name() {
        return "Insertion Sort";
    }

    /**
     * Reference: https://www.geeksforgeeks.org/java-program-for-insertion-sort/
     * 
     * @param arr - the array of integers to sort in ascending order.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            // key is first element of unsorted portion of array
            int key = arr[i];
            // start comparing with last element in sorted portion
            int j = i - 1;
            // move elements that are greater than key, to one position ahead
            // of their current position
            // stop when the element value is not greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            // put the key in it's correct place in the sorted portion
            arr[j + 1] = key;
        }
    }
}
