package otherMed.medianOfTwoSortedArrays;


/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 * https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/6723070/video-divide-each-array-into-two-groups-2hgjq/
 */
public class Solution {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        if (nums1.length > nums2.length) {
//            return this.findMedianSortedArrays(nums2, nums1);
//        }
//
//        int len1 = nums1.length;
//        int len2 = nums2.length;
//        int low = 0;
//        int high = len1;
//
//        while (low <= high) {
//            int part1 = (low + high) / 2;
//            int part2 = (len1 + len2 + 1) / 2 - part1;
//
//            int max1 = part1 == 0 ? Integer.MIN_VALUE : nums1[part1 - 1];
//            int min1 = part1 == len1 ? Integer.MAX_VALUE : nums1[part1];
//            int max2 = part2 == 0 ? Integer.MIN_VALUE : nums2[part2 - 1];
//            int min2 = part2 == len2 ? Integer.MAX_VALUE : nums2[part2];
//
//            if (max1 <= min2 && max2 <= min1) {
//                if ((len1 + len2) % 2 == 1) {
//                    return (double) Math.max(max1, max2);
//                } else {
//                    return  (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0;
//                }
//            } else if (max1 > min2) {
//                high = low + (high - low) / 2;
//            } else {
//                low = low + (high - low) / 2;
//            }
//        }
//    }
}
