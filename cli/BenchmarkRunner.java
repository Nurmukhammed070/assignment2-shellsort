package cli;

import algorithms.ShellSort;
import metrics.PerformanceTracker;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 20000};
        ShellSort.Sequence[] sequences = ShellSort.Sequence.values();

        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("Size,Sequence,Time(ms),Comparisons,Swaps\n");

            for (int size : sizes) {
                int[] baseArray = generateRandomArray(size);
                for (ShellSort.Sequence seq : sequences) {
                    int[] arr = baseArray.clone();

                    ShellSort sorter = new ShellSort();
                    PerformanceTracker tracker = sorter.getTracker();

                    long start = System.currentTimeMillis();
                    sorter.sort(arr, seq);
                    long end = System.currentTimeMillis();

                    writer.write(size + "," + seq + "," + (end - start) + ","
                            + tracker.getComparisons() + "," + tracker.getSwaps() + "\n");
                }
            }
            System.out.println("✅ Benchmark complete. Results saved in benchmark_results.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateRandomArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = rand.nextInt(100000);
        return arr;
    }
}