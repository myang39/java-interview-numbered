/**
 * Created by minkangyang on 09:12 Sat Jun, 2019
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class _26_LongestPalindromicSubstring_5 {
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int max_length = 1;
        for (int i = n; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);
                if (dp[i][j] && j - i + 1 > max_length) {
                    start = i;
                    max_length = j - i + 1;
                }
            }
        }
        return s.substring(start, start + max_length);
    }
}
