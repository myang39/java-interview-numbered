/**
 * Created by minkangyang on 09:18 Sat Jun, 2019
 * https://leetcode.com/problems/maximal-square/
 */
public class _31_MaximalSquare_221 {
    public static void main(String[] args) {

    }
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        // dp[i][j] means largest length of square with right bottom ccorner as i, j
        int maxleng = 0;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                    maxleng = Math.max(maxleng, dp[i][j]);
                }
            }
        }
        return (int)Math.pow(maxleng, 2);
    }
}
