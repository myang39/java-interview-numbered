/**
 * Created by minkangyang on 09:57 Sat Jun, 2019
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class _44_RegularExpressionMatching_10 {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] rem = new boolean[m + 1][n + 1];
        rem[m][n] = true;
        // rem[i][j] presents s[j..m-1] could be represented by p[j..n-1]
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m) {
                    if (j == n - 1) {
                        rem[i][j] = false;
                    } else {
                        rem[i][j] = p.charAt(j + 1) == '*' ? true : false;
                    }
                }
                boolean isCurrentMatch = (i < m) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                rem[i][j] = isCurrentMatch && rem[i + 1][j + 1];
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    rem[i][j] = (isCurrentMatch && rem[i + 1][j]) || rem[i][j + 2];
                }
                // System.out.println("rem[" + i + "][" + j +"] "+ rem[i][j]);
            }
        }
        return rem[0][0];
    }
}
