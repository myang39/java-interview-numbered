/**
 * Created by minkangyang on 10:09 Sat Jun, 2019
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class _53_LongestValidParentheses_32 {
    public static void main(String[] args) {

    }
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        // dp[i] represents the longest valid substring end with ')'
        int[] dp = new int[s.length()];
        int maxlen = 0;
        dp[1] = s.substring(0, 2).equals("()") ? 2 : 0;
        maxlen = dp[1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '(') {continue;}
            if (s.charAt(i-1) == '(') {
                dp[i] = dp[i-2] + 2;
            } else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                dp[i] = dp[i-1] + 2;
                dp[i] += (i - dp[i-1] - 2) >= 0 ? dp[i - dp[i-1] - 2] : 0;
            } else {
                continue;
            }
            maxlen = Math.max(maxlen, dp[i]);
            // System.out.println("i: " + i + " dp[i]: " + dp[i]);
        }
        return maxlen;
    }
}
