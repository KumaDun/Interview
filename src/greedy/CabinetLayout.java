package greedy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
小明正在规划一个大型数据中心机房，为了使得机柜上的机器都能正常负荷工作，需要确保在每个机柜边上至少要一个电箱。

为了简化题目，假设这个机房是一整排，M表示机柜，I表示间隔，请你返回这整排机柜，至少多少个电箱。如果无解请返回-1。

输入描述：cabinets="MIIM"
其中M表示机柜，I表示间隔
输出描述：2
表示至少需要2个电箱

示例1
输入：MIIM
输出：2

示例2
输入：MIM
输出：1

示例3
输入：M
输出：-1

示例4
输入：I
输出：0


 */
public class DataCenterPowerLayout {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cabinets = sc.nextLine().toCharArray();
        int count = 0;
        int i = 0;
        while (i < cabinets.length) {
            char c = cabinets[i];
            if (c == 'M') {
                if (i + 1 < cabinets.length && cabinets[i + 1] == 'I') {
                    count++;
                    i += 3;
                } else if (i - 1 >= 0 && cabinets[i - 1] == 'I') {
                    count++;
                    i++;
                } else {
                    count = -1;
                    break;
                }
            } else {
                i++;
            }
        }
        System.out.println(count);
    }
}


