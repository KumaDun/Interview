package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.isEmpty() || t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> tCounts = new HashMap<>();
        for (char c : t.toCharArray()) {
            int count = tCounts.getOrDefault(c, 0);
            tCounts.put(c, count + 1);
        }
        int l = 0;
        int r = 0;

        HashMap<Character, Integer> sCounts = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int [] results = new int[] {0, 0};
        boolean isHasResult = false;
        sCounts.put(s.charAt(0), 1);
        while (l <= r && r < s.length()) {
            if (!this.isMatch(sCounts, tCounts)) {
                System.out.println("l, r " + l + ", " + r + " not matched");
                if (r < s.length() - 1) {
                    r ++;
                } else {
                    break;
                }
                int count = sCounts.getOrDefault(s.charAt(r), 0);
                sCounts.put(s.charAt(r), count + 1);
            } else {
                isHasResult = true;
//                System.out.println("l, r " + l + ", " + r + " is matched");
                if ((r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    results[0] = l;
                    results[1] = r;
                }
                int count = sCounts.getOrDefault(s.charAt(l), 0);
                sCounts.put(s.charAt(l), count - 1);
//                System.out.println("after remove l " + l + ", "  + s.charAt(l) +  " is " + + sCounts.get(s.charAt(l)));
                l ++;
            }
        }
        return isHasResult ? s.substring(results[0], results[1] + 1) : "";
    }


    // This method is not efficient for not necessarily checked char in s but not in t
    public boolean isMatch(Map<Character, Integer> sCounts, Map<Character, Integer> tCcounts) {
        for (Map.Entry<Character, Integer> entry : tCcounts.entrySet()) {
            if (!sCounts.containsKey(entry.getKey()) || sCounts.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        sol.minWindow("ADOBECODEBANC", "ABC");
        // 0 1 2 3 4 5 6 7 8 9 10 11 12
        // A D O B E C O D E B A  N  C
    }
}
