package dynamicProgramming.palindromicSubstring;

import java.util.Arrays;

public class PalindromicSubstring {
    /**
     * Solution One
     * @param s
     * @return
     */
    public String longestPalindromeOne(String s) {
        for (int length = s.length(); length > 0; length--) {
            for (int start = 0; start <= s.length() - length; start++) {
                if (check(s, start, start + length)) {
                    return s.substring(start, start + length);
                }
            }
        }
        return "";
    }

    /**
     * Solution Two
     * @param s
     * @return
     */

    public String longestPalindromeTwo(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int[] ans = new int[]{0, 0};
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans[0] = i;
            }
        }
        for (int dist = 2; dist < n; dist++) {
            for (int i = 0; i < n - dist; i++) {
                if (dp[i + 1][i + dist - 1] && (s.charAt(i) == s.charAt(i + dist))) {
                    dp[i][i + dist] = true;
                    ans[0] = i;
                    ans[1] = i + dist;
                }
            }
        }

        int left = ans[0];
        int right = ans[1];
        return s.substring(left, right);
    }

    public String longestPalindromeThree(String s) {
        int n = s.length();
        int[] ans = {0, 0};
        for (int i = 0; i < n; i++) {
            int res = expandFromCenter(s, i, i);
            if (res > ans[1] - ans[0] + 1) {
                int dist = (res - 1) / 2;
                ans[0] = i - dist;
                ans[1] = i + dist;
            }
        }
        for (int i = 0; i< n-1; i++) {
            int res = expandFromCenter(s, i, i + 1);
            if (res > ans[1] - ans[0] + 1) {
                int dist = res / 2;
                ans[0] = i - dist + 1;
                ans[1] = i + dist;
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }

    private boolean check(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left = left + 1;
            right = right - 1;
        }
        return true;
    }

    private int expandFromCenter(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i > 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i = i - 1;
                j = j + 1;
            } else {
                // when meet break condition, i and j already plus 1, so need to minus 2
                return j - i - 1;
            }
        }
    }


}
