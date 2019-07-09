/**
 * Created by minkangyang on 10:04 Sat Jun, 2019
 * https://leetcode.com/problems/sort-colors/
 */
public class _48_SortColors_75 {
    public static void main(String[] args) {

    }
    public void sortColors(int[] nums) {
        /*
        00000 11111XXXXXXX 22222
              i    j     k
              i)  0s
              [i..j) 1s
              [j..k] unexplored
              (k     2s
        */
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            } else if (nums[j] == 1) {
                j++;
            } else if (nums[k] == 2) { // nums[j] == 2
                k--;
            } else { // nums[k] == 1 or 0
                nums[j] = nums[k];
                nums[k--] = 2;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
