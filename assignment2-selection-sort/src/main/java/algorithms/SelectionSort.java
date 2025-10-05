package algorithms;

import metrics.PerformanceTracker;

/**
 * Implementation of the Selection Sort algorithm with early termination optimization.
 * <p>
 * This algorithm repeatedly finds the minimum element from the unsorted portion of the array
 * and places it at the beginning. It includes an optimization that checks if the array
 * becomes sorted early, allowing termination before completing all passes.
 * <p>
 * Performance metrics such as comparisons, swaps, and array accesses are tracked via
 * the {@link PerformanceTracker} class.
 * <p>
 * <b>Complexity Analysis:</b>
 * <ul>
 *     <li>Best Case: Ω(n²)</li>
 *     <li>Average Case: Θ(n²)</li>
 *     <li>Worst Case: O(n²)</li>
 *     <li>Space Complexity: O(1) — in-place sorting</li>
 * </ul>
 */
public class SelectionSort {

    private final PerformanceTracker tracker;

    /**
     * Constructs a SelectionSort instance with a given PerformanceTracker.
     *
     * @param tracker a {@link PerformanceTracker} used to record sorting metrics
     */
    public SelectionSort(PerformanceTracker tracker) {
        this.tracker = tracker;
    }

    /**
     * Sorts the provided array using the Selection Sort algorithm.
     * If the array is already sorted early, the algorithm terminates before completing all iterations.
     *
     * @param arr the array to sort
     */
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            boolean swapped = false;

            for (int j = i + 1; j < n; j++) {
                tracker.incrementComparisons();
                tracker.incrementArrayAccesses(2); // arr[j] and arr[minIdx]
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                swap(arr, i, minIdx);
                swapped = true;
            }

            // Early termination optimization
            if (!swapped && isSorted(arr, i, n - 1)) {
                break;
            }
        }
    }

    /**
     * Swaps two elements in the array and updates performance metrics.
     *
     * @param arr the array containing elements to swap
     * @param i   index of the first element
     * @param j   index of the second element
     */
    private void swap(int[] arr, int i, int j) {
        tracker.incrementSwaps();
        tracker.incrementArrayAccesses(4); // read i,j; write i,j
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * Checks whether a portion of the array is sorted in ascending order.
     *
     * @param arr   the array to check
     * @param start start index (inclusive)
     * @param end   end index (inclusive)
     * @return true if the segment is sorted, false otherwise
     */
    private boolean isSorted(int[] arr, int start, int end) {
        for (int i = start; i < end; i++) {
            tracker.incrementComparisons();
            tracker.incrementArrayAccesses(2);
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }
}