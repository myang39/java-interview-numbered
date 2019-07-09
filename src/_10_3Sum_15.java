import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 20:10 Fri Jun, 2019
 * https://leetcode.com/problems/3sum/
 */
public class _10_3Sum_15 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1] || nums[i] > 0) {
                continue;
            }
            int first = nums[i];
            // two sum
            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                int sum = nums[l] + nums[h];
                if (sum == -first) {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[h]));
                    while (l < h && nums[l] == nums[l + 1]) {l++;}
                    while (l < h && nums[h] == nums[h - 1]) {h--;}
                    l++;
                    h--;
                } else if (sum < -first) {
                    while (l < h && nums[l] == nums[l + 1]) {l++;}
                    l++;
                } else {
                    while (l < h && nums[h] == nums[h - 1]) {h--;}
                    h--;
                }
            }
        }
        return ret;
    }
}
