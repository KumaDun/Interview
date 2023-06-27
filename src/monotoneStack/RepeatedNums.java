package monotoneStack;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;
/*
给定一个由纯数字组成以字符串表示的数值，现要求字符串中的每个数字最多只能出现2次，超过后需要删除，删除某个重复的数字后，其它数字相对位置保持不变。

如："34533"，数字3重复超过2次，需要删除一个3，删除第一个3后获得最大数值"4533"

输入描述：第一行是纯数字组成的字符串
输出描述：经过删除后的最大数值，以字符串表示

示例1
输入：34533
输出：4533

示例2
输入：5445795045
输出：5479504

 */
public class RepeatedNums {
    public String sol(String s){
        int[] count = new int[]{0,0,0,0,0, 0,0,0,0,0};
        int[] existing = new int[]{0,0,0,0,0, 0,0,0,0,0};
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (int i = 0; i<charArray.length; i++){
            count[charArray[i]-'0'] = count[charArray[i]-'0'] + 1;
        }
//        System.out.println("Count Initial:" + Arrays.toString(count));
        for (int i =0; i< charArray.length;i++){
            if (existing[charArray[i]-'0']==2){
                count[charArray[i]-'0'] = count[charArray[i]-'0'] - 1;
                continue;
            }
            while(!stack.isEmpty() && stack.peekLast()<charArray[i] && existing[stack.peekLast()-'0']+ count[stack.peekLast()-'0']>2){
                char intRemoved = stack.removeLast();
                existing[intRemoved-'0'] = existing[intRemoved-'0'] - 1;
                count[intRemoved-'0'] = count[intRemoved-'0'] -1;
            }
            stack.addLast(charArray[i]);
            existing[charArray[i]-'0'] = existing[charArray[i]-'0'] + 1;
            count[charArray[i]-'0'] = count[charArray[i]-'0'] -1;
//            System.out.println("stack: " + stack);
//            System.out.println("existing :" + Arrays.toString(existing));
//            System.out.println("count :" + Arrays.toString(count));
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        return sb.toString();
    }
}
