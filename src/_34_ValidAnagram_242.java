/**
 * Created by minkangyang on 09:33 Sat Jun, 2019
 * https://leetcode.com/problems/valid-anagram/
 */
public class _34_ValidAnagram_242 {
    public static void main(String[] args) {

    }
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if(++map[cs[i]] == 1) count ++;
        }
        for (int i = 0; i < ct.length; i++) {
            if (--map[ct[i]] == 0) count --;
        }
        return count == 0;
    }
}
