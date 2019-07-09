/**
 * Created by minkangyang on 09:14 Sat Jun, 2019
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class _27_PalindromicSubstrings_647 {
    public static void main(String[] args) {

    }
    public int countSubstrings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                count = dp[i][j] ? count + 1 : count;
            }
        }
        return count;
    }
}
