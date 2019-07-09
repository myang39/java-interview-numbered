/**
 * Created by minkangyang on 09:19 Sat Jun, 2019
 * https://leetcode.com/problems/house-robber/
 */
public class _32_HouseRobber_198 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : nums) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
