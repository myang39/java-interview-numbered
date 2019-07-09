/**
 * Created by minkangyang on 09:54 Sat Jun, 2019
 * https://leetcode.com/problems/shortest-common-supersequence/
 */
public class _41_ShortestCommonSupersequence_1092 {
    public static void main(String[] args) {

    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m == 0) {
            return str2;
        } else if (n == 0) {
            return str1;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        int l = dp[m][n];
        char[] arr = new char[l--];
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                arr[l--] = str1.charAt(i - 1);
                i--;
                j--;
            } else if (dp[i - 1][j] <= dp[i][j - 1]) {
                arr[l--] = str1.charAt(i - 1);
                i--;
            } else {
                arr[l--] = str2.charAt(j - 1);
                j--;
            }
        }

        while (i > 0) {
            arr[l--] = str1.charAt(i - 1);
            i--;
        }

        while (j > 0) {
            arr[l--] = str2.charAt(j - 1);
            j--;
        }

        return new String(arr);
    }
}
