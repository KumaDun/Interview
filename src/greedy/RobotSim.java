package greedy;

import java.util.HashSet;

/*
机器人在一个无限大小的 XY 网格平面上行走，从点(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：

-2 ：向左转90 度
-1 ：向右转 90 度
1 <= x <= 9 ：向前移动x个单位长度
在网格上有一些格子被视为障碍物obstacles 。第 i个障碍物位于网格点 obstacles[i] = (xi, yi) 。

机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。

返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/walking-robot-simulation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles){
            set.add(obstacle[0] + "," + obstacle[1]);
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        int currDir = 0, x=0, y=0;
        int ans = 0;
        int tx = 0, ty=0;
        for (int command : commands){
            if (command > 0){
                for(int i = 0; i<command; i++){
                    tx = x + dx[currDir];
                    ty = y + dy[currDir];
                    if (set.contains(tx+","+ty)){
                        break;
                    }
                    x = tx;
                    y = ty;
                    ans = Math.max(ans, x*x + y*y);
                }
            }
            else{
                currDir = (command == -1)? ((currDir+1)%4): ((currDir+3)%4);
            }

        }
        return ans;
    }
}
