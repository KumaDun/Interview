package dynamicProgramming.buySellStocks;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] mins = new int[prices.length];
        int[] maxs = new int[prices.length];
        int minIdx = 0;
        int maxIdx = 0;
        boolean isIncreasing = (prices[1] - prices[0]) >0;
        for (int i =0; i< prices.length; i++) {
            if (prices[i+1] - prices[i] > 0 && !isIncreasing) {
                isIncreasing = true;
                mins[minIdx] = prices[i];
                minIdx ++;
            } else if (prices[i+1] - prices[i] < 0 && isIncreasing) {
                isIncreasing = false;
                maxs[maxIdx] = prices[i];
                maxIdx ++;
            }
        }
        int[] profits = new int[prices.length];
        int maxProfit = 0;
        for (int i =0; i<prices.length; i++) {
            for (int j = i; j<prices.length; j ++) {
                if (j == i) {
                    profits[j] = 0;
                } else {
                    int profit = profits[j -1] + prices[j] - prices[j-1];
                    profits[j] = profit;
                    if (profit > maxProfit) {
                        maxProfit = profit;
                    }
                }
            }
        }
        return maxProfit;
    }
}
