import java.util.Arrays;

/**
 * Created by minkangyang on 09:55 Sat Jun, 2019
 * https://leetcode.com/problems/coin-change/
 */
public class _42_CoinChange_322 {
    public static void main(String[] args) {

    }
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // dp[i] represents the number of least coins needed to make up amount i
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i-coins[j]] != -1) {
                    curMin = Math.min(dp[i - coins[j]], curMin);
                }
                dp[i] = curMin == Integer.MAX_VALUE ? -1 : curMin + 1;
            }
        }
        return dp[amount];
    }
}
