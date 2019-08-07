package round4.Q013;

import java.util.Arrays;

public class Solution {

    private int cnt;

    public int movingCount(int threshold, int rows, int cols){
        if (rows<=0 || cols <=0 )
            return 0;

        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++)
            Arrays.fill(visited[i], false);

        cnt = 0;
        dfs(threshold, 0, 0, visited);

        return cnt;
    }

    private void dfs(int threshold, int i, int j, boolean[][] visited) {
        if ( outOfRange(visited.length, visited[0].length, i, j) || visited[i][j] || !canEnter(threshold, i, j))
            return ;

        cnt++;
        visited[i][j] = true;

        dfs(threshold, i+1, j, visited);
        dfs(threshold, i-1, j, visited);
        dfs(threshold, i, j+1, visited);
        dfs(threshold, i, j-1, visited);
    }

    private boolean outOfRange(int n, int m, int i, int j) {
        return !(0 <= i && i < n && 0 <= j && j < m);
    }

    private boolean canEnter(int threshold, int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j > 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= threshold;
    }

}