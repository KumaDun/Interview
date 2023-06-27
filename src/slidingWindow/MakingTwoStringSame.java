package slidingWindow;

public class MakingTwoStringSame {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] differences = new int[s.length()];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i=0; i<differences.length; i++){
            differences[i] = Math.abs(sChars[i] - tChars[i]);
        }
        int left = 0;
        int maxLen = 0;
        int sum = 0;
        for (int right = 0; right<differences.length; right++){
            sum = sum + differences[right];
            while(sum>maxCost){
                sum = sum-differences[left];
                left = left + 1;
            }
            maxLen = Math.max(maxLen,right-left+1);

        }
        return maxLen;
    }
}
