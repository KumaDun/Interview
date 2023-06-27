package monotoneStack;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.HashMap;

/*
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

示例 1：

输入：s = "bcabc"
输出："abc"
示例 2：

输入：s = "cbacdcbc"
输出："acdb"

提示：

1 <= s.length <= 104
s 由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/remove-duplicate-letters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RepeatedLetter {
    public String sol(String s) {
        char[] charArray = s.toCharArray();
        // last index of specif letter's occurrence
        int[] lastIdx = new int[26];
        // boolean array recording whether such letter is visited in the stack
        boolean[] visited = new boolean[26];
        int len = s.length();
        for (int i = 0; i<len; i++){
            lastIdx[charArray[i]-'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i<len; i++){
            // the element has already in the front of the stack, no repeated letter
            if (visited[charArray[i]-'a']){
                continue;
            }
            // make sure when checking a new element, all previous repeated letter larger than current one is removed
            while(!stack.isEmpty() && charArray[i]<stack.peekLast() && lastIdx[stack.peekLast()-'a']>i){
                Character charRemoved = stack.removeLast();
                visited[charRemoved-'a'] = false;
            }
            stack.addLast(charArray[i]);
            visited[charArray[i]-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for(Character c: stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
