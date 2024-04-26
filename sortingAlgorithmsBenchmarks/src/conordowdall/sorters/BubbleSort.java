package conordowdall.sorters;

/**
 * Implements an algorithm to sort an array of integers in ascending order.
 * Code taken from:
 * https://www.geeksforgeeks.org/java-program-for-bubble-sort/
 */
public class BubbleSort implements Sorter {
    public String name() {
        return "Bubble Sort";
    }

    /**
     * Reference: https://www.geeksforgeeks.org/java-program-for-bubble-sort/
     * 
     * @param arr - the array of integers to sort in ascending order.
     */
    public void sort(int[] arr) {
        int n = arr.length;
        // loop over each element of the array
        for (int i = 0; i < n - 1; i++)
            // start from the beginning, end at one position less each time
            for (int j = 0; j < n - i - 1; j++)
                // compare with the next element
                if (arr[j] > arr[j + 1]) {
                    // swap, if less than next element
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
}
