/**
 * Created by minkangyang on 09:17 Sat Jun, 2019
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class _30_MaximumProductSubarray_152 {
    public static void main(String[] args) {

    }
    public int maxProduct(int[] nums) {
        // pos[i] represents the max positive product containing nums[i]
        // neg[i] represents the max negative product containing nums[i]
        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];

        pos[0] = nums[0];
        neg[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                pos[i] = Math.max(neg[i-1] * nums[i], nums[i]);
                neg[i] = Math.min(pos[i-1] * nums[i], nums[i]);
            } else {
                neg[i] = Math.min(neg[i-1] * nums[i], nums[i]);
                pos[i] = Math.max(pos[i-1] * nums[i], nums[i]);
            }
            max = Math.max(max, pos[i]);
        }
        return max;
    }
}
