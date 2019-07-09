/**
 * Created by minkangyang on 10:12 Sat Jun, 2019
 * https://leetcode.com/problems/split-array-largest-sum/
 */
public class _57_SplitArrayLargestSum_410 {
    public static void main(String[] args) {

    }
    public int splitArray(int[] nums, int m) {
        // find the range for possible sum of min and max
        Integer leftBound = 0;
        Integer rightBound = 0;
        for (int i : nums) {
            leftBound = Math.max(leftBound, i);
            rightBound += i;
        }
        //
        if (nums.length <= m) {
            return leftBound;
        }
        //
        int targetsum = rightBound;
        while (leftBound < rightBound) {
            targetsum = leftBound + (rightBound - leftBound) / 2;
//            System.out.println("targetsum:" + targetsum);
            if (segment(nums, m, targetsum)) {
                rightBound = targetsum;
            } else {
                leftBound = targetsum + 1;
            }
        }
        return rightBound;
    }

    private boolean segment(int[] nums, int m, int targetsum) {
        int i = 0;
        int cursum = 0;
        while (m > 1 && i < nums.length) {
            if (cursum + nums[i] > targetsum) {
                m--;
                cursum = 0;
            } else {
                cursum += nums[i++];
            }
        }
        int lastsum = 0;
//        System.out.println("targetsum is:" + targetsum);
        while (i < nums.length) {
            lastsum += nums[i++];
        }

//        System.out.println("lastsum is:" + lastsum);
        return lastsum <= targetsum;
    }
}
