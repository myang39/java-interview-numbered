/**
 * Created by minkangyang on 09:59 Sat Jun, 2019
 * https://leetcode.com/problems/decode-ways/
 */
public class _47_DecodeWays_91 {
    public static void main(String[] args) {

    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return Integer.valueOf(s) == 0 ? 0 : 1;
        }
        int[] dw = new int[s.length() + 1];
        // dw[i] means total number of ways to decode s[0..i-1]
        dw[0] = 1;
        dw[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int firstDigit = Integer.valueOf(s.substring(i-1, i));
            int twoDigits = Integer.valueOf(s.substring(i-2, i));
            if (firstDigit > 0) {
                dw[i] += dw[i-1];
            }
            if (twoDigits > 9 && twoDigits < 27) {
                dw[i] += dw[i-2];
            }
        }
        // for (int i = 0; i < dw.length; i++) {
        //     System.out.print(dw[i]);
        // }
        return dw[s.length()];
    }
}
