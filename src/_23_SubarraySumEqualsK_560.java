import java.util.HashMap;

/**
 * Created by minkangyang on 22:16 Fri Jun, 2019
 * https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class _23_SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefix_sum_hm = new HashMap<>();
        int prefix_sum = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix_sum += nums[i];
            if (prefix_sum == k) { total++;}
            Integer cnt = prefix_sum_hm.get(prefix_sum - k);
            total += (cnt == null) ? 0 : cnt;
            Integer cnt2 = prefix_sum_hm.get(prefix_sum);
            prefix_sum_hm.put(prefix_sum, cnt2 == null ? 1 : cnt2 + 1);
        }
        return total;
    }
}
