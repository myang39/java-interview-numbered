import java.util.HashMap;

/**
 * Created by minkangyang on 10:11 Sat Jun, 2019
 * https://leetcode.com/problems/knight-dialer/
 */
public class _56_KnightDialer_935 {
    public static void main(String[] args) {

    }
    public int knightDialer(int N) {
        int[][] dp = new int[N + 1][10];
        // dp[i][j] means number f combinations with i moves (including the initial placement) ends at i
        HashMap<Integer, int[]> hm = new HashMap<>();

        hm.put(1, new int[]{6,8});
        hm.put(2, new int[]{7,9});
        hm.put(3, new int[]{4,8});
        hm.put(4, new int[]{3,9,0});
        hm.put(5, new int[]{});
        hm.put(6, new int[]{1,7,0});
        hm.put(7, new int[]{2,6});
        hm.put(8, new int[]{1,3});
        hm.put(9, new int[]{2,4});
        hm.put(0, new int[]{4,6});

        int bound = (int)Math.pow(10, 9) + 7;

        for (int j = 0; j < 10; ++j) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                int sum = 0;
                int[] prev = hm.get(j);
                for (int k : prev) {
                    sum += dp[i-1][k];
                    if (sum >= bound) {
                        sum %= bound;
                    }
                }
                dp[i][j] = sum;
                // System.out.println(dp[i][j]);
            }
        }


        int total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[N][i];
            if (total >= bound) {
                total %= bound;
            }
        }
        return total;
    }
}
