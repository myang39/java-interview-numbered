/**
 * Created by minkangyang on 09:11 Sat Jun, 2019
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class _25_LongestIncreasingSubsequence_300 {
    public static void main(String[] args) {

    }
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        // tail[i] represents the smallest tia lnumber of increasing subsequence eith length i + 1;
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (x > tail[m]) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tail[i] = x;
            if (i == size) {
                size++;
            }
        }
        return size;
    }
}
