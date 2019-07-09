import java.util.Arrays;

/**
 * Created by minkangyang on 23:02 Thu Jun, 2019
 * https://leetcode.com/problems/next-permutation/
 */
public class _58_NextPermutation_31 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,5,1};
        _58_NextPermutation_31 sol = new _58_NextPermutation_31();
        sol.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
    // n be the length of nums, n-1 would be the largest index
    public void nextPermutation(int[] nums) {
        // from the tail
        boolean flag = false;
        int i = 0;
        int smallest_larger_i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            // find the first position i such that nums[i] > nums[i-1]
            if (nums[i] > nums[i-1]) {
                flag = true;
                // then all numbers to the right of nums[i] must be descending
                /*
                TODO find the smallest number in the range nums[i] to nums[n-1] that is larger than nums[i-1]
                  Not exactly right because as I tried to find the smallest elements from i to length - 1,
                  if there are duplicates smallest number, then after swapping,
                  the sub-array to the right of nums[n-1] would not be descending anymore.
                  To Solve this, We first need to know that, the array to the right of i - 1 is descending, so we simply
                  need to start from the tail, then find the first number that is larger than nums[i-1]
                */

                int j = nums.length - 1;
                /* TODO nums[j] <= nums[i - 1], not nums[j] < nums[i - 1], think about the reason!
                * */
                for (; j > i && nums[j] <= nums[i - 1]; j--) {}
//                System.out.println("i" + i);
//                System.out.println("j" + j);
                swap(nums, i - 1, j);
//                System.out.println(Arrays.toString(nums));
                reverse(nums, i, nums.length - 1);
                break;
            }
        }
        if (!flag) { // nums are already descending
            System.out.println("flag is true");
            reverse(nums, 0, nums.length - 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
