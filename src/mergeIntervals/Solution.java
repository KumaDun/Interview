package mergeIntervals;

import java.net.SocketOption;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/450/
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        int length = intervals.length;
        // sort
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            priorityQueue.add(interval);
        }

        int[][] tmp = new int[length][];
        System.out.println("priorityQueue length is " + priorityQueue.size() + " tmp length is " + tmp.length);
        tmp[0] = priorityQueue.peek();
        int idx = 0;
        // loop
        while(!priorityQueue.isEmpty()) {
            int[] newPair = priorityQueue.poll();
            System.out.println("newPair is " + newPair[0] + "," + newPair[1]);
            int low = newPair[0];
            int high = newPair[1];
            if (low <= tmp[idx][1] && low >= tmp[idx][0]) {
                tmp[idx][1] = Math.max(high, tmp[idx][1]);
            } else if (high <= tmp[idx][1] && high >= tmp[idx][0]) {
                tmp[idx][0] = Math.min(low, tmp[idx][0]);
            } else if (low < tmp[idx][0] && high>tmp[idx][1]) {
                tmp[idx][0] = low;
                tmp[idx][1] = high;
            } else {
                tmp[idx+1] = new int[] {low, high};
                idx = idx + 1;
                System.out.println("idx++ to " + idx + " tmp idx is " + tmp[idx][0] + ", " + tmp[idx][1]);

            }
        }
        int[][] result = new int[idx + 1][];
        for (int k = 0; k < idx + 1; k++) {
            System.out.println("result k " + k + " is " + tmp[k][0] + ", " + tmp[k][1]);
            result[k] = tmp[k];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.merge(new int[][]{new int[]{1,3},new int[]{2,6},new int[]{8,10},new int[]{15,18}});
    }
}
