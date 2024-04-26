package conordowdall.util;

import java.io.IOException;

import conordowdall.sorters.Sorter;

/**
 * A utility class for dealing with files
 */
public class File {
    /**
     * Delete a file, if it exists
     * 
     * @param fileName - the name of the file to delete
     */
    public static void deleteIfExists(String fileName) {
        java.io.File file = new java.io.File(fileName);
        if (file.exists() && file.isFile())
            file.delete();
    }

    /**
     * Save information from array to a specific file name, useful for this specific
     * benchmarking project
     * 
     * @param sorter - an instance of a Sorter class, so the name can be read
     * @param array  - the array of nano-second times to write to the data file
     * @throws IOException
     */
    public static void saveNanoTimes(Sorter sorter, long[] array) throws IOException {
        String nanoTimesFileName = "data/" + sorter.name().replaceAll("\\s+", "") + "Times.csv";
        conordowdall.util.File.deleteIfExists(nanoTimesFileName);
        Array.toFile(nanoTimesFileName, array, "");
    }
}
