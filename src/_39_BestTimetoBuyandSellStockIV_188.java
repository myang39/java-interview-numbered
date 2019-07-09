/**
 * Created by minkangyang on 09:52 Sat Jun, 2019
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class _39_BestTimetoBuyandSellStockIV_188 {
    public static void main(String[] args) {

    }
    public int maxProfit(int k, int[] prices) {
        // dp[i][j] represents the max profit you can make with totoal number of i transactions on day j
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k >= n) {
            return quickSolve(prices);
        }
        int[][] dp = new int[2][n];
        int max_profit = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                int curMax = 0;
                for (int m = 0; m < j; m++) {
                    curMax = Math.max(curMax, dp[0][m] + prices[j] - prices[m]);
                }
                dp[1][j] = Math.max(curMax, dp[1][j - 1]);
                max_profit = Math.max(max_profit, dp[1][j]);
            }
            //swap
            for (int f = 0; f < n; f++) {
                int temp = dp[0][f];
                dp[0][f] = dp[1][f];
                dp[1][f] = temp;
            }
        }
        return max_profit;
    }

    private int quickSolve(int[] prices) {
        int n = prices.length;
        int total = 0;
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i -1] ) {
                total += prices[i] - prices[i - 1];
            }
        }
        return total;
    }
}
