/**
 * Created by minkangyang on 09:50 Sat Jun, 2019
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class _37_BestTimeToBuyAndSellStockii_122 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
