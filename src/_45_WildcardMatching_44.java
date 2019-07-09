/**
 * Created by minkangyang on 09:57 Sat Jun, 2019
 * https://leetcode.com/problems/wildcard-matching/
 */
public class _45_WildcardMatching_44 {
    public static void main(String[] args) {

    }
    public boolean isMatch(String s, String p) {
        boolean[][] wm = new boolean[s.length() + 1][p.length() + 1];
        wm[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                if (i == s.length()) {
                    wm[i][j] = (p.charAt(j) == '*') && (wm[i][j + 1]);
                    continue;
                }
                wm[i][j] = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && wm[i+1][j+1];
                if (p.charAt(j) == '*') {
                    wm[i][j] |= wm[i][j+1];
                    if (i + 1 < wm.length) {
                        wm[i][j] |= wm[i+1][j];
                    }
                }
            }
        }
        return wm[0][0];
    }
}
