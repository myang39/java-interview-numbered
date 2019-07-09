/**
 * Created by minkangyang on 09:51 Sat Jun, 2019
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class _38_BestTimetoBuyandSellStockiii_123 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int n = prices.length;
        // dp[i][j] represents the max profit you can get with total number of i transactions on day
        int[][] dp = new int[3][n];

        for (int i = 1; i < 3; ++i) {
            for (int j = 1; j < n; ++j) {
                int curMax = 0;
                for (int m = 0; m < j; ++m) {
                    curMax = Math.max(curMax, dp[i-1][m] + prices[j] - prices[m]);
                }
                dp[i][j] = Math.max(curMax, dp[i][j - 1]);
            }
        }
        return dp[2][n-1];
    }
}
