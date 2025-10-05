package algorithms;

import metrics.PerformanceTracker;

public class ShellSort {
    public enum Sequence {
        SHELL, KNUTH, HIBBARD, SEDGEWICK
    }

    private final PerformanceTracker tracker = new PerformanceTracker();

    public void sort(int[] arr, Sequence seq) {
        int n = arr.length;
        int[] gaps = generateGaps(seq, n);
        tracker.reset();

        for (int gap : gaps) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && tracker.compare(arr[j - gap], temp) > 0) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                    tracker.incrementSwaps();
                }
                arr[j] = temp;
            }
        }
    }

    private int[] generateGaps(Sequence seq, int n) {
        switch (seq) {
            case SHELL:
                return new int[]{n / 2, n / 4, n / 8, 1};
            case KNUTH: {
                int k = 1;
                while (k < n / 3) k = 3 * k + 1;
                java.util.List<Integer> gaps = new java.util.ArrayList<>();
                for (int h = k; h > 0; h = (h - 1) / 3) gaps.add(h);
                return gaps.stream().mapToInt(i -> i).toArray();
            }
            case HIBBARD: {
                java.util.List<Integer> gaps = new java.util.ArrayList<>();
                for (int k = 1; (1 << k) - 1 < n; k++)
                    gaps.add((1 << k) - 1);
                java.util.Collections.reverse(gaps);
                return gaps.stream().mapToInt(i -> i).toArray();
            }
            case SEDGEWICK: {
                java.util.List<Integer> gaps = new java.util.ArrayList<>();
                int k = 0;
                int gap;
                while (true) {
                    gap = (int) (Math.pow(4, k) + 3 * Math.pow(2, k - 1) + 1);
                    if (gap > n) break;
                    gaps.add(gap);
                    k++;
                }
                java.util.Collections.reverse(gaps);
                return gaps.stream().mapToInt(i -> i).toArray();
            }
            default:
                return new int[]{1};
        }
    }

    public PerformanceTracker getTracker() {
        return tracker;
    }

    //test
    public static void main(String[] args) {
        int[] arr = {9, 8, 3, 7, 5, 6, 4, 1};
        ShellSort sorter = new ShellSort();
        sorter.sort(arr, Sequence.KNUTH);

        System.out.println("Sorted: " + java.util.Arrays.toString(arr));
        System.out.println("Metrics: " + sorter.getTracker());
    }
}