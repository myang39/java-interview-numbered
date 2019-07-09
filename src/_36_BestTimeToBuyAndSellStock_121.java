/**
 * Created by minkangyang on 09:38 Sat Jun, 2019
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class _36_BestTimeToBuyAndSellStock_121 {
    public static void main(String[] args) {

    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max_profit = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max_profit = Math.max(max_profit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max_profit;
    }
}
