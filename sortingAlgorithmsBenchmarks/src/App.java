import java.util.ArrayList;
import java.util.List;

import conordowdall.sorters.*;
import conordowdall.util.Array;
import conordowdall.util.BenchmarkSorter;
import conordowdall.util.File;

public class App {
    public static void main(String[] args) throws Exception {
        List<Sorter> sorters = new ArrayList<Sorter>();
        sorters.add(new BubbleSort());
        sorters.add(new SelectionSort());
        sorters.add(new InsertionSort());
        sorters.add(new QuickSort());
        sorters.add(new CountingSort());

        // int repetitionSampleSize = 10;
        // int repetitionSampleSize = 100;
        // int repetitionSampleSize = 1000;
        int repetitionSampleSize = 10_000;
        // int repetitionSampleSize = 100_000;

        // int[] inputSizes = { 1000 };
        // int[] inputSizes = { 10, 100, 500, 1000 };
        // int[] inputSizes = { 10, 100, 500, 1000, 2000 };
        // int[] inputSizes = { 10, 100, 500, 1000, 2000, 5000 };
        int[] inputSizes = { 10, 100, 500, 1000, 2000, 5000, 8000, 10_000 };

        // log info, and input sizes to the console
        System.out.println("");
        System.out.println("Sorting Algorithms Benchmarks");
        System.out.println("by Conor Dowdall");
        System.out.println("");
        System.out.print(String.format("%19s", "Input Size") + "\t");
        Array.toConsole(inputSizes);

        // a data file name to store input sizes, mean times in nano-seconds,
        // and errors on the mean times - use later to plot data
        String dataFileName = "data/data_ns.csv";
        // clear file for a new run
        File.deleteIfExists(dataFileName);
        // output the header containing the input sizes used
        Array.toFile(dataFileName, inputSizes, "");

        // a table data file name to store input sizes, and mean times in milli-seconds
        // - use later to create a table
        String tableDataFileName = "data/tableData_ms.csv";
        // clear file for a new run
        File.deleteIfExists(tableDataFileName);
        // output the header containing the input sizes used
        Array.toFile(tableDataFileName, inputSizes, "InputSize");

        // benchmark the sorters...
        // output of data, to the terminal and relavent files,
        // is done in the benchmark method
        for (Sorter sorter : sorters)
            BenchmarkSorter.benchmark(sorter, inputSizes, repetitionSampleSize, dataFileName, tableDataFileName);
    }
}
