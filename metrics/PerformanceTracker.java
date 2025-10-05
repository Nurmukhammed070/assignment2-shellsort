package metrics;

public class PerformanceTracker {
    private int comparisons = 0;
    private int swaps = 0;

    public void reset() {
        comparisons = 0;
        swaps = 0;
    }

    public int compare(int a, int b) {
        comparisons++;
        return Integer.compare(a, b);
    }

    public void incrementSwaps() {
        swaps++;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }

    @Override
    public String toString() {
        return "comparisons=" + comparisons + ", swaps=" + swaps;
    }
}