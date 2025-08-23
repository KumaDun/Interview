package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new LinkedList<>();
        for (int i = 0; i<nums.length; i++) {
            if (i ==0 || nums[i-1] != nums[i]) {
                this.twoSum(nums, i, results);
            }
        }
        return results;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> results) {
        int low = i+1;
        int high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] < nums[i]) {
                low ++;
            } else if (nums[low] + nums[high] > nums[i]) {
                high --;
            } else {
                results.add(Arrays.asList(nums[i], nums[low], nums[high]));
            }
        }
    }
}
