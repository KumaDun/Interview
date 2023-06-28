package slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
某个充电站，可提供n个充电设备，每个充电设备均有对应的输出功率。任意个充电设备组合的输出功率总和，均构成功率集合P的1个元素。功率集合P的最优元素，表示最接近充电站最大输出功率p_max的元素。

输入描述：
第1行是充电设备个数n
第2行是那个充电设备的输出功率
第3行是充电站最大输出功率p_max

输出描述：功率集合P的最优元素

说明：
1.充电设备个数n>0
2.最优元素必须小于或等于充电站最大输出功率p_max


示例1
输入：4
           50 20 20 60
           90
输出：90
说明：当充电设备输出功率50、20、20组合时，其输出功率总和为90，最接近充电站最大充电输出功率，因此最优元素为90

示例2
输入：2
           50 40
输出：30
说明：所有充电设备的输出功率组合，均大于充电站最大充电输出功率30，因此最优元素值为0

 */
public class MaxPower {

    public int solution(int[] nums, int limit){
        int[][] dp = new int[nums.length+1][limit+1];
        // Initialize dp zero row and zero col
        Arrays.fill(dp[0],0);
        for(int i=0; i< nums.length+1; i++){
            dp[i][0] = 0;
        }
        // Fill dp table
        for(int i=1; i<nums.length+1;i++){
            for(int j =1; j<limit+1;j++){
                // 0-1 knapsack problem
                if(j<nums[i-1]){
                    // if weight not enough for the new item, then no need to compare
                    dp[i][j] = dp[i-1][j];
                }else{
                    // take new item into consideration, two options
                    // one, not include new item, same as dp[i-1][weight]
                    // two, include new item, dp[i-1][weight-weight[i]]+value[i]
                    // for this specific question, weight = value
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-nums[i-1]]+nums[i-1]);
                }
            }
        }
        for(int k=0;k< dp.length;k++){
            System.out.println("dp[" + k +"]: " + Arrays.toString(dp[k]));
        }
        return dp[nums.length][limit];
    }
}
