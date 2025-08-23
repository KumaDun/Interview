package arraysAndStrings;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int firstReverseDecreasingIdx = this.findFirstReverseDecreasingIdx(nums);
        if (firstReverseDecreasingIdx == -1) {
            Arrays.sort(nums);
            return;
        }
        int[] remainedNums = new int[nums.length - 1 - firstReverseDecreasingIdx];
        int min = 101;
        int minIdx = -1;
        int temp = nums[firstReverseDecreasingIdx];
        // This solution is not optimal
        // Remember the feature of the remained array, it is already in descending order
        // To find the nums just larger than nums[firstReverseDescreasingidx], only need to traverse backwardly
        for (int i = nums.length - 1; i > firstReverseDecreasingIdx; i--) {
//            if (nums[i] < min && nums[i] > nums[firstReverseDecreasingIdx]) {
//                min = nums[i];
//                minIdx = i;
//            }
            if (nums[i] > nums[firstReverseDecreasingIdx]) {
                min = nums[i];
                minIdx = i;
                break;
            }
        }
        // No need to get the remained array and sort it
        // You can sort it by swapping in place
        for (int i = firstReverseDecreasingIdx + 1; i < nums.length; i++) {
            if (i == minIdx) {
                remainedNums[i - firstReverseDecreasingIdx - 1] = temp;
            } else {
                remainedNums[i - firstReverseDecreasingIdx - 1] = nums[i];
            }
        }
        Arrays.sort(remainedNums);
        nums[firstReverseDecreasingIdx] = min;
        for (int i = firstReverseDecreasingIdx + 1; i < nums.length; i++) {
            nums[i] = remainedNums[i - firstReverseDecreasingIdx - 1];
        }
    }

    public int findFirstReverseDecreasingIdx(int[] nums) {
        for (int high = nums.length - 1; high > 0; high--) {
            if (nums[high - 1] < nums[high]) {
                return high - 1;
            }
        }
        return -1;
    }
}
