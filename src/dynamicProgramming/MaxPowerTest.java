package dynamicProgramming;

import org.junit.Test;

public class MaxPowerTest {
    MaxPower sol = new MaxPower();
    @Test
    public void TestOne(){
        int[] nums = new int[]{50,20,20,60};
        int limit = 90;
        int max = sol.solution(nums,limit);
        System.out.println(max);
    }

    @Test
    public void TestTwo(){
        int[] nums = new int[]{50,40};
        int limit = 30;
        int max = sol.solution(nums,limit);
        System.out.println(max);
    }
}