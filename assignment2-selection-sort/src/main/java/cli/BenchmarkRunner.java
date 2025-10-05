package cli;

import algorithms.SelectionSort;
import metrics.PerformanceTracker;
import java.io.FileWriter; // Import for writing to files
import java.io.IOException; // Import for handling file errors
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        // Expanded sizes to better capture the O(n^2) curve, up to 10^5
        int[] sizes = {100, 500, 1000, 5000, 10000, 20000, 50000, 100000};

        // Using a try-with-resources block to safely handle the file writer
        try (FileWriter writer = new FileWriter("docs/performance_data.csv")) {
            // Write the CSV header
            writer.append("ArraySize,DataType,Time_ms,Comparisons,Swaps\n");

            for (int n : sizes) {
                System.out.println("Processing size: " + n);

                // Create instances for sorting and tracking
                PerformanceTracker tracker = new PerformanceTracker();
                SelectionSort sorter = new SelectionSort(tracker);

                // --- 1. Test on Random Data (Average Case) ---
                int[] randomArr = generateRandomArray(n);
                runAndRecord(writer, sorter, tracker, randomArr, n, "Random");

                // --- 2. Test on Sorted Data (Best Case) ---
                int[] sortedArr = generateSortedArray(n);
                runAndRecord(writer, sorter, tracker, sortedArr, n, "Sorted");

                // --- 3. Test on Reverse-Sorted Data (Worst Case) ---
                int[] reversedArr = generateReversedArray(n);
                runAndRecord(writer, sorter, tracker, reversedArr, n, "Reversed");
            }
            System.out.println("✅ Benchmark complete! Data saved to docs/performance_data.csv");

        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    /**
     * Helper method to run the sort, track performance, and write results to the CSV file.
     */
    private static void runAndRecord(FileWriter writer, SelectionSort sorter, PerformanceTracker tracker,
                                     int[] arr, int n, String dataType) throws IOException {
        tracker.reset(); // Reset counters for a fresh run

        // We need a copy because the sort method modifies the array in-place
        int[] arrCopy = Arrays.copyOf(arr, arr.length);

        long start = System.nanoTime();
        sorter.sort(arrCopy);
        long end = System.nanoTime();

        double timeMs = (end - start) / 1e6;
        long comparisons = tracker.getComparisons(); // Assuming your tracker has these methods
        long swaps = tracker.getSwaps();             // Assuming your tracker has these methods

        // Write the data row to the CSV file
        writer.append(String.format("%d,%s,%.4f,%d,%d\n", n, dataType, timeMs, comparisons, swaps));
    }

    // --- Array Generation Methods ---

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rand.nextInt(n * 10);
        return arr;
    }

    private static int[] generateSortedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        return arr;
    }

    private static int[] generateReversedArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = n - 1 - i;
        return arr;
    }
}