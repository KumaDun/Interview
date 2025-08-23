package arraysAndStrings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        HashSet<Character> charSet = new HashSet<>();
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            while (charSet.contains(s.charAt(end))) {
                charSet.remove(s.charAt(start));
                start ++;
            }
            charSet.add(s.charAt(end));
            length = Math.max(length, end - start + 1);
        }
        return length;
    }
}
