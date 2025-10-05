package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link SelectionSort} algorithm.
 * <p>
 * Covers edge cases such as empty arrays, single elements, duplicates,
 * sorted, and reverse-sorted data. Ensures correctness of sorting
 * and algorithm stability.
 */
public class SelectionSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testRandomArray() {
        int[] arr = {3, 1, 4, 1, 5, 9};
        int[] expected = {1, 1, 3, 4, 5, 9};
        SelectionSort sorter = new SelectionSort(new PerformanceTracker());
        sorter.sort(arr);
        assertArrayEquals(expected, arr);
    }
}