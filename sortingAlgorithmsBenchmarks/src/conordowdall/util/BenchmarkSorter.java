package conordowdall.util;

import java.io.IOException;

import conordowdall.sorters.Sorter;

/**
 * A class to run benchmarking on sorting algorithms and output the data to the
 * terminal as well as data files containing space separated values. Use the
 * benchmark method.
 */
public class BenchmarkSorter {
    /**
     * Get the time taken to sort an array with an algorithm.
     * Note that it also alters to the array, by sorting it.
     * 
     * @param sorter               - a sorting Class with a sort method
     * @param inputSizes           - the different array sizes to filled with random
     *                             numbers and sorted
     * @param repetitionSampleSize - how many times should a random array be
     *                             generated and sorted to get the average sorting
     *                             time for the sorting algorithm
     * @param dataFileName         - a file name to store the average times in
     * @param tableDataFileName    - a file name to store comma separated (actually
     *                             space separated) values, used to generate a table
     *                             in spreadsheet software
     */
    public static void benchmark(
            Sorter sorter,
            int[] inputSizes,
            int repetitionSampleSize,
            String dataFileName,
            String tableDataFileName) throws IOException {

        long[] sortingNanoTimes = new long[repetitionSampleSize];
        double[] nanoTimesMeans = new double[inputSizes.length];
        double[] nanoTimesErrors = new double[inputSizes.length];

        for (int i = 0; i < inputSizes.length; i++) {

            // run the sorting algorithm on random arrays a predefined number of times
            // and save each sort time
            int[] randomArray = new int[inputSizes[i]];
            for (int j = 0; j < repetitionSampleSize; j++) {
                randomArray = Array.random(inputSizes[i]);
                sortingNanoTimes[j] = Array.sortingNanoTime(randomArray, sorter);
            }

            // store the run times of one of the input sizes to check later if the data
            // looks sufficient to run statistics on, i.e. a histogram should resemble
            // a normal (really poisson) distribution
            if (inputSizes[i] == 1000)
                File.saveNanoTimes(sorter, sortingNanoTimes);

            // save the mean time, and error on the mean time (actually the standard
            // deviation) for this input size
            nanoTimesMeans[i] = Array.mean(sortingNanoTimes);
            nanoTimesErrors[i] = Array.standardDeviation(sortingNanoTimes, nanoTimesMeans[i]);
        }

        // convert results from nano-seconds to milli-seconds
        double[] milliTimesMeans = new double[nanoTimesMeans.length];
        for (int i = 0; i < nanoTimesMeans.length; i++)
            milliTimesMeans[i] = nanoTimesMeans[i] / 1000000.0;

        // print mean times for different input sizes in milli-seconds to console
        System.out.print(String.format("%19s", sorter.name() + " / ms") + "\t");
        Array.toConsole(milliTimesMeans);

        // append mean times in nano-seconds, and errors on the mean times
        // to the data file for later graphing/plotting
        Array.toFile(dataFileName, nanoTimesMeans, "");
        Array.toFile(dataFileName, nanoTimesErrors, "");

        // append mean times in milli-seconds to the table data file
        // for later production of table
        Array.toFile(tableDataFileName, milliTimesMeans, sorter.name().replaceAll("\\s+", ""));
    }
}
