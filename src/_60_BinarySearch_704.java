/**
 * Created by minkangyang on 20:15 Tue Jul, 2019
 * https://leetcode.com/problems/binary-search/
 */
public class _60_BinarySearch_704 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
