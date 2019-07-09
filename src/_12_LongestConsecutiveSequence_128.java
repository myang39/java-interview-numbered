import java.util.HashSet;

/**
 * Created by minkangyang on 20:13 Fri Jun, 2019
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class _12_LongestConsecutiveSequence_128 {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> num_set = new HashSet<>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;
        int currentStreak = 1;
        for (int num : nums) {
            if (!num_set.contains(num - 1)) {
                while (num_set.contains(num + 1)) {
                    num ++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
                currentStreak = 1;
            }
        }
        return longestStreak;
    }
}
