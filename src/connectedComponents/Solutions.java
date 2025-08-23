package connectedComponents;

import java.util.*;

public class Solutions   {



    private static int getConnectedComponentDFS(int[][] citiesConnected) {
        int componentNumber = 0;
        int length = citiesConnected.length;
        boolean[] visited= new boolean[length];
        for (int i = 0; i<length; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, length, visited, citiesConnected);
            componentNumber ++;
        }
        return componentNumber;
    }

    private static int getConnectedComponentBFS(int[][] citiesConnected) {
        int componentNumber = 0;
        int length = citiesConnected.length;
        boolean[] visited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }
            queue.offer(i);
            while (!queue.isEmpty()) {
                int k = queue.poll();
                visited[k] = true;
                for (int j = 0; j < length; j++) {
                    if (citiesConnected[k][j] == 1 && !visited[j]) {
                        queue.offer(j);
                    }
                }

            }
            componentNumber++;
        }
        return componentNumber;
    }

    private static void dfs(int i, int length, boolean[] visited, int[][] citiesConnected) {
        for (int j= 0; j < length; j++) {
            if (citiesConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(j, length, visited, citiesConnected);
            }
        }
    }
}
