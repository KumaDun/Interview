package slidingWindow;

import org.junit.Test;

public class ShortestSubArrayTest {
    int[] nums = new int[]{2,3,1,2,4,3};
    ShortestSubArray sol = new ShortestSubArray();
    @Test
    public void OneTest(){
        sol.minSubArrayLen(7,nums);
    }
}