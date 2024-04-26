package conordowdall.sorters;

/**
 * Implements an algorithm to sort an array of integers in ascending order.
 * Code taken from:
 * https://www.geeksforgeeks.org/java-program-for-selection-sort/
 */
public class SelectionSort implements Sorter {
    public String name() {
        return "Selection Sort";
    }

    /**
     * Reference: https://www.geeksforgeeks.org/java-program-for-selection-sort/
     * 
     * @param arr - the array of integers to sort in ascending order.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        // loop over each element of the array
        for (int i = 0; i < n - 1; i++) {
            // first, find the minimum element, starting from the new element position
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }
            // swap the found minimum element with the first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
