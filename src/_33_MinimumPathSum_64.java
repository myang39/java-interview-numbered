/**
 * Created by minkangyang on 09:32 Sat Jun, 2019
 * https://leetcode.com/problems/minimum-path-sum/
 */
public class _33_MinimumPathSum_64 {
    public static void main(String[] args) {

    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        // path[i][j] represents the minimal to get position i, j
        //
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    path[i][j] = grid[i][j];
                } else if (i == 0) {
                    path[i][j] = path[i][j-1] + grid[i][j];
                } else if (j == 0) {
                    path[i][j] = path[i-1][j] + grid[i][j];
                } else {
                    path[i][j] = Math.min(path[i-1][j], path[i][j-1]) + grid[i][j];
                }
            }
        }
        return path[m - 1][n - 1];
    }
}
