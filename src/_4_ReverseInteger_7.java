/**
 * Created by minkangyang on 19:59 Fri Jun, 2019
 * https://leetcode.com/problems/reverse-integer/
 */
public class _4_ReverseInteger_7 {
    public static void main(String[] args) {

    }
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int digit = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && digit > 7)) {return 0;}
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && digit < -8)) {return 0;}
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
