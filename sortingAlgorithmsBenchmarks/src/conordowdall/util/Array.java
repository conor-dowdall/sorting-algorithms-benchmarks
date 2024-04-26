package conordowdall.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import conordowdall.sorters.Sorter;

/**
 * A utility class to make it easier to do certain array functions
 */
public class Array {
    /**
     * Fill the supplied array with random integers
     * 
     * @param numberOfElements - define the size of the array
     * @return an array of random integers between 0 and 1000
     */
    public static int[] random(int numberOfElements) {
        int[] randomArray = new int[numberOfElements];
        for (int i = 0; i < numberOfElements; i++)
            randomArray[i] = (int) (Math.random() * 1000);
        return randomArray;
    }

    /**
     * Copy an array and return a new one
     * 
     * @param array - the array to copy
     * @return the copied array
     */
    public static int[] copy(int[] array) {
        int[] arrayCopy = new int[array.length];
        System.arraycopy(array, 0, arrayCopy, 0, array.length);
        return arrayCopy;
    }

    /**
     * Write an integer array to a file in space separated format, with an optional
     * tag string
     * 
     * @param filename - the filename to write to
     * @param array    - the array to write
     * @param tag      - a tag to go at the start of the line, before the array
     * @throws IOException
     */
    public static void toFile(String filename, int[] array, String tag) throws IOException {
        BufferedWriter buffer = null;
        buffer = new BufferedWriter(new FileWriter(filename, true));
        if (tag != "")
            buffer.write(tag + " ");
        for (int value : array) {
            buffer.write(value + " ");
        }
        buffer.newLine();
        buffer.flush();
        buffer.close();
    }

    /**
     * Write a long array to a file in space separated format, with an optional
     * tag string
     * 
     * @param filename - the filename to write to
     * @param array    - the array to write
     * @param tag      - a tag to go at the start of the line, before the array
     * @throws IOException
     */
    public static void toFile(String filename, long[] array, String tag) throws IOException {
        BufferedWriter buffer = null;
        buffer = new BufferedWriter(new FileWriter(filename, true));
        if (tag != "")
            buffer.write(tag + " ");
        for (long value : array) {
            buffer.write(value + " ");
        }
        buffer.newLine();
        buffer.flush();
        buffer.close();
    }

    /**
     * Write a double array to a file in space separated format, with an optional
     * tag string
     * 
     * @param filename - the filename to write to
     * @param array    - the array to write
     * @param tag      - a tag to go at the start of the line, before the array
     * @throws IOException
     */
    public static void toFile(String filename, double[] array, String tag) throws IOException {
        BufferedWriter buffer = null;
        buffer = new BufferedWriter(new FileWriter(filename, true));
        if (tag != "")
            buffer.write(tag + " ");
        for (double value : array) {
            buffer.write(value + " ");
        }
        buffer.newLine();
        buffer.flush();
        buffer.close();
    }

    /**
     * Print an integer array to console
     * 
     * @param array - the array to print
     */
    public static void toConsole(int[] array) {
        System.out.println(Arrays.toString(array).replaceAll("\\[|\\]", "").replaceAll(", ", "\t\t"));
    }

    /**
     * Print a long array to console
     * 
     * @param array - the array to print
     */
    public static void toConsole(long[] array) {
        System.out.println(Arrays.toString(array).replaceAll("\\[|\\]", "").replaceAll(", ", "\t\t"));
    }

    /**
     * Print a double array to console with 3 decimal point precision
     * 
     * @param array - the array to print
     */
    public static void toConsole(double[] array) {
        for (double value : array)
            System.out.printf("%.3f\t\t", value);
        System.out.print("\n");
    }

    /**
     * Find the mean of an array of longs
     * 
     * @param array - input array
     * @return the mean
     */
    public static double mean(long[] array) {
        long total = 0;
        for (long value : array)
            total += value;
        return total / (double) array.length;
    }

    /**
     * Find the standard deviation of an array of longs
     * 
     * @param array - input array
     * @param mean  - pass in the mean, which can be calculated using the mean
     *              method on this class
     * @return the standard deviation
     */
    public static double standardDeviation(long[] array, double mean) {
        double differenceSquaredSum = 0.0;
        for (long value : array)
            differenceSquaredSum += Math.pow(value - mean, 2);
        return Math.sqrt(differenceSquaredSum / array.length);
    }

    /**
     * Find the standard error of an array of longs
     * 
     * @param array - input array
     * @param mean  - pass in the mean, which can be calculated using the mean
     *              method on this class
     * @return the standard error
     */
    public static double standardError(long[] array, double mean) {
        return standardDeviation(array, mean) / Math.sqrt(array.length);
    }

    /**
     * Get the time taken to sort an array with an algorithm.
     * Note that it also alters to the array, by sorting it.
     * 
     * @param array  - an array of integers
     * @param sorter - a sorting Class with a sort method
     * @return the number of nano-seconds to perform the sorting algorithm
     */
    public static long sortingNanoTime(int[] array, Sorter sorter) {
        long startTime = System.nanoTime();
        sorter.sort(array);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

}
