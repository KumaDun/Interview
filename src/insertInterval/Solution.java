package insertInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/explore/interview/card/google/63/sorting-and-searching-4/445/
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int low = 0;
        int high = intervals.length - 1;
        int insertIdx = -1;
        int mid = -1;
        while(low <= high) {
            mid = low + (high - low + 1) / 2;
            if (intervals[mid][0] > newInterval[0]) {
                high = mid - 1;
            } else if (intervals[mid][0] < newInterval[0]) {
                low = mid + 1;
            } else {
                insertIdx = mid;
                break;
            }
        }
        if (insertIdx == -1 && mid != -1) {
            insertIdx = mid;
        }
        System.out.println("insertIdx is " + insertIdx);
        int length = intervals.length;
        int[][] newIntervals = new int[length + 1][];
        // pair at insertIdx would be the first pair with pair[0] <= newInterval[0]
        for (int i = 0; i< length + 1; i++) {
            if (i == insertIdx && intervals[i][0] > newInterval[0]) {
                newIntervals[i] = newInterval;
                newIntervals[i + 1] = intervals[i];
                i++;
            } else if (i == insertIdx && intervals[i][0] <= newInterval[0]) {
                newIntervals[i] = intervals[i];
                newIntervals[i + 1] = newInterval;
                i++;
            } else  {
                newIntervals[i] = i <= insertIdx ? intervals[i] : intervals[i - 1];
            }
            // System.out.println("new intervals at " + i + " is " + newIntervals[i][0] + ", " + newIntervals[i][1]);
        }
        return this.merge(newIntervals);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        int length = intervals.length;

        int[][] tmp = new int[length][];
        tmp[0] = intervals[0];
        int idx = 0;
        // loop
        for(int i = 0; i < length; i++) {
            int[] newPair = intervals[i];
            int low = newPair[0];
            int high = newPair[1];
            if (tmp[idx][1] >= low) {
                tmp[idx][1] = Math.max(high, tmp[idx][1]);
            } else {
                tmp[idx+1] = new int[] {low, high};
                idx = idx + 1;
            }
        }
        int[][] result = new int[idx + 1][];
        for (int k = 0; k < idx + 1; k++) {
            // System.out.println("result k " + k + " is " + tmp[k][0] + ", " + tmp[k][1]);
            result[k] = tmp[k];
        }
        return result;
    }

    // best solution
    public int[][] bestInsert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[1]) {
                res.add(newInterval);
                while (i < intervals.length) res.add(intervals[i++]);
                return res.toArray(new int[res.size()][]);
            } else if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        sol.insert(new int[][] {new int[]{1,2}, new int[]{3,5}, new int[]{6, 7}, new int[]{8, 10}, new int[]{12,16} }, new int[] {4,8});
        sol.insert(new int[][] { new int[] {1,5} }, new int[]{1, 7});
    }
}
