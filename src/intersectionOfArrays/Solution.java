package intersectionOfArrays;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        if (nums1.length > nums2.length) {
            return this.intersect(nums2, nums1);
        }

        int[] result1 = this.resultOfOneOrder(nums1, nums2);
        for (int i = 0; i < nums1.length / 2; i++) {
            int temp = nums1[i];
            nums1[i] = nums1[nums1.length - 1 - i];
            nums1[nums1.length - 1 - i] = temp;
        }
        int[] result2 = this.resultOfOneOrder(nums1, nums2);
        return result1.length > result2.length ? result1 : result2;
    }

    public int[] resultOfOneOrder(int[] nums1, int[] nums2) {
        int max = 0;
        int start = 0;

        for (int j =0; j<nums2.length; j++) {
            for (int i =0; i < nums1.length; i++) {
                if (nums1[i] == nums2[j]) {
                    int length = this.checkLength(nums1, nums2, i, j);
                    System.out.println("length on " + i + " is " + length);
                    if (length > max) {
                        max = length;
                        start = i;
                    }
                    i = i + length - 1;
                }
            }
        }
        int[] result = new int[max];
        for (int k = 0; k<max; k++) {
            result[k] = nums1[start + k];
        }
        return result;
    }

    public int checkLength(int[] nums1, int[] nums2, int i, int j) {
        int length = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                length ++;
                j ++;
                i ++;
            } else {
                break;
            }
        }
        return length;
    }
}
