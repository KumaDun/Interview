package recursion;

public class UnlockPattern {
    private static final int[][] SINGLE_MOVE = new int[][] {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
            {-1, -1},
            {1, -1},
            {-1, 1},
            {1 , 1},
            {-2, -1},
            {-1, -1},
            {1, -2},
            {2, -1},
            {-2, 1},
            {-1, 2},
            {2, 1},
            {1, 2}
    };

    private static final int[][] CROSS_MOVE = new int[][] {
            {2, 0},
            {-2, 0},
            {0, -2},
            {0, 2},
            {-2, -2},
            {2, -2},
            {-2, 2},
            {2, 2}
    };


    public int numberOfPatterns(int m, int n) {
        int validPatternNum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j< 3; j++) {
                boolean[][] visited = new boolean[3][3];
                validPatternNum += this.dfs(m, n, i, j, 1, visited);
            }
        }
        return validPatternNum;
    }

    private int dfs(int m, int n, int i, int j, int length, boolean[][] visited) {
        int validPattern = 0;
        if (length >= n || i >= 3 || j>=3 || i<0 || j< 0 || visited[i][j]) {
            return 0;
        }
        if (length >= m) {
            validPattern++;
        }
        visited[i][j] = true;
        for(int[] move: UnlockPattern.SINGLE_MOVE) {
            if (this.isValidMove(i+move[0], j + move[1], visited)) {
                validPattern += this.dfs(m, n, i + move[0], j+move[1], length + 1, visited);
            }
        }
        for (int[] move: UnlockPattern.CROSS_MOVE) {
            int middleI = i + move[0] / 2;
            int middleJ = j + move[1] / 2;
            if (this.isValidMove(i+move[0], j + move[1], visited)) {
                if (visited[middleI][middleJ]) {
                    validPattern += this.dfs(m, n, i + move[0], j+move[1], length + 1, visited);
                }
            }
        }
        visited[i][j] = false;
        return validPattern;
    }

    private boolean isValidMove(int i, int j, boolean[][] visited) {
        if (i >= 3 || j >= 3 || i<0 ||j<0 || visited[i][j]) {
            return false;
        }
        return true;
    }
}
