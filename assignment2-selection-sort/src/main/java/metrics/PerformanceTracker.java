package metrics;

/**
 * A utility class that tracks key performance metrics for algorithm execution.
 * <p>
 * This class is used to record the number of:
 * <ul>
 *     <li>Comparisons</li>
 *     <li>Swaps</li>
 *     <li>Array accesses</li>
 * </ul>
 * It provides methods to increment these counters and reset them between runs.
 */
public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

    /** Increments the comparison counter by one. */
    public void incrementComparisons() { comparisons++; }

    /** Increments the swap counter by one. */
    public void incrementSwaps() { swaps++; }

    /**
     * Increments the array access counter by the specified number.
     * @param n number of array accesses to add
     */
    public void incrementArrayAccesses(int n) { arrayAccesses += n; }

    /** @return total number of comparisons performed */
    public long getComparisons() { return comparisons; }

    /** @return total number of swaps performed */
    public long getSwaps() { return swaps; }

    /** @return total number of array accesses performed */
    public long getArrayAccesses() { return arrayAccesses; }

    /** Resets all counters to zero. */
    public void reset() {
        comparisons = swaps = arrayAccesses = 0;
    }

    /** @return human-readable summary of collected performance data */
    @Override
    public String toString() {
        return String.format("Comparisons=%d, Swaps=%d, ArrayAccesses=%d",
                comparisons, swaps, arrayAccesses);
    }
}