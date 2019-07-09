import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by minkangyang on 20:11 Fri Jun, 2019
 * https://leetcode.com/problems/4sum/
 */
public class _11_4Sum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }
        Arrays.sort(nums);

        int max = nums[len - 1];

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1]) {continue;} // avoid duplicate
            if (z + 3 * max < target) {continue;} // z is too small
            if (4 * z > target) {break;} // z is too large
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z) {
                    res.add(Arrays.asList(z, z, z, z));
                }
                break;
            }
            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }
        return res;
    }

    private void threeSumForFourSum(int[] nums, int target, int l, int h, List<List<Integer>> res, int z1) {
        if (l + 1 >= h) {return;}
        int max = nums[h];
        if (3 * nums[l] > target || 3 * max < target) {return;}

        int i, z;
        for (i = l; i < h - 1; i++) {
            z = nums[i];
            if (i > l && z == nums[i - 1]) {continue;}
            if (z + 2 * max < target) {continue;}
            if (3 * z > target) {break;}
            if (3 * z == target) {
                if (i + 1 < h && nums[i + 2] == z) {
                    res.add(Arrays.asList(z1, z, z, z));
                }
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, h, res, z1, z);
        }
    }

    private void twoSumForFourSum(int[] nums, int target, int l, int h, List<List<Integer>> res, int z1, int z2) {
        if (l >= h) {return;}
        if (2 * nums[l] > target || 2 * nums[h] < target) {return;}

        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == target) {
                res.add(Arrays.asList(z1, z2, nums[l], nums[h]));
                while (l < h && nums[l] == nums[l + 1]) {l++;}
                while (l < h && nums[h] == nums[h - 1]) {h--;}
                l++;
                h--;
            } else if (sum < target) {
                while (l < h && nums[l] == nums[l + 1]) {l++;}
                l++;
            } else {
                while (l < h && nums[h] == nums[h - 1]) {h--;}
                h--;
            }
        }
    }
}
