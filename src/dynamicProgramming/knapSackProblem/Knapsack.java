package dynamicProgramming.knapSackProblem;

public class Knapsack {
    public int zeroOneSolution(int[] weights, int[] values, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j > weights[i - 1]) {
                    dp[i][j] = Math.max(
                            // select the i-th item
                            dp[i - 1][j - weights[i - 1]] + values[i - 1],
                            // not to select the i-th item
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return 0;
    }

    public int unboundedSolution(int[] weights, int[] values, int n, int w) {
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 0; i < w + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j > weights[i - 1]) {
                    dp[i][j] = Math.max(
                            // select the i-th item
                            dp[i][j - weights[i - 1]] + values[i - 1],
                            // not to select the i-th item
                            dp[i - 1][j]
                    );
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return 0;
    }
}
