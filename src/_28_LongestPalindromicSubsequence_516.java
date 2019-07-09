/**
 * Created by minkangyang on 09:15 Sat Jun, 2019
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class _28_LongestPalindromicSubsequence_516 {
    /*
   rule:
   dp[i][j] -> max length palindromic subsequence between s[i] to s[j]
   if s[i] == s[j]
   dp[i][j] =  j - i + 1, if j - i < 3
               dp[i+1][j-1] + 2, else
   else = max(dp[i+1][j], dp[i][j-1])
   */
    public static void main(String[] args) {

    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3) {
                        dp[i][j] = j - i + 1;
                    } else {
                        dp[i][j] = dp[i+1][j-1] + 2;
                    }
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
