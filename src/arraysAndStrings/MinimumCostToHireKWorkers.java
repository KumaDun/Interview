package arraysAndStrings;

import java.util.*;

public class MinimumCostToHireKWorkers {
    // Q 3    1    10    10    1
    // W 4    8    2     2     7
    // U 1.33 8    0.2   0.2   7
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        double qualityTillNow = 0;

        List<Worker> workers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            workers.add(new Worker(wage[i] / (double) quality[i], quality[i]));
        }

        // Sorting workers by their wage-quality ratio
        Collections.sort(workers);

        // Max-heap for the qualities using a comparator
        PriorityQueue<Integer> highQualityWorkers = new PriorityQueue<>(Comparator.reverseOrder());

        for (Worker worker : workers) {
            double ratio = worker.ratio;
            int qua = worker.quality;

            qualityTillNow += qua;
            highQualityWorkers.add(qua);

            if (highQualityWorkers.size() > k) {
                qualityTillNow -= highQualityWorkers.poll();
            }

            if (highQualityWorkers.size() == k) {
                minCost = Math.min(minCost, qualityTillNow * ratio);
            }
        }

        return minCost;
    }

    // Helper class to store the ratio and quality and implement comparable for
    // sorting

    private class Worker implements Comparable<Worker> {
        int quality;
        double ratio;

        Worker(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }


        @Override
        public int compareTo(Worker o) {
            return Double.compare(this.ratio, o.ratio);
        }
    }
}
