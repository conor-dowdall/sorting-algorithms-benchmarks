package conordowdall.sorters;

/**
 * Implements an algorithm to sort an array of integers in ascending order.
 * Code taken from:
 * https://www.geeksforgeeks.org/java-program-for-quicksort/
 */
public class QuickSort implements Sorter {
    public String name() {
        return "Quicksort";
    }

    /**
     * Reference: https://www.geeksforgeeks.org/java-program-for-quicksort/
     * 
     * @param arr - the array of integers to sort in ascending order.
     */
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    /**
     * takes the last element as the "pivot", and
     * places the pivot element at its correct
     * position in array, and places all
     * smaller (smaller than pivot) to left of
     * pivot, and all greater elements to right
     * of pivot
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // if current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /**
     * The main function that implements quicksort
     * 
     * @param arr  - the array to be sorted
     * @param low  - the starting index
     * @param high - the ending index
     */
    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now in its correct position
            int pi = partition(arr, low, high);
            // recursively sort elements before partition and after partition
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
}
