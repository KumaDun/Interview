package quickSelect;

import java.util.Random;

public class Solution {

    // 公开接口，查找第k小的元素（k从1开始）
    public static int findKthSmallest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k - 1); // 转换为0-based索引
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        // 基准情况：子数组只有一个元素
        if (left == right) {
            return nums[left];
        }

        // 随机选择枢轴并分区
        int pivotIndex = randomPartition(nums, left, right);

        // 枢轴正好是第k个元素
        if (k == pivotIndex) {
            return nums[k];
        }
        // 第k个元素在左子数组
        else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
        // 第k个元素在右子数组
        else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    // 随机选择枢轴并分区
    private static int randomPartition(int[] nums, int left, int right) {
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left + 1);
        swap(nums, pivotIndex, right); // 将枢轴移到末尾
        return partition(nums, left, right);
    }

    // 分区函数
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right]; // 枢轴
        int i = left; // i指向第一个大于枢轴的元素

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right); // 将枢轴放到正确位置
        return i; // 返回枢轴的最终位置
    }

    // 交换数组元素
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 6, 4, 1, 5};
        int k = 3;
        System.out.println("第" + k + "小的元素是: " + findKthSmallest(nums, k));

        // 验证多个k值
        for (int i = 1; i <= nums.length; i++) {
            System.out.println("第" + i + "小的元素: " + findKthSmallest(nums, i));
        }
    }
}
