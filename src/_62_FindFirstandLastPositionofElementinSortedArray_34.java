/**
 * Created by minkangyang on 21:24 Tue Jul, 2019
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class _62_FindFirstandLastPositionofElementinSortedArray_34 {
    public static void main(String[] args) {

    }

    public int[] searchRange(int[] nums, int target) {
        // find the first target
        int[] res = new int[]{-1, -1};
        res[0] = startbinarySearch(nums, target, 0, nums.length - 1);
        if (res[0] == -1) {
            return res;
        } else {
            res[1] = endbinarySearch(nums, target, 0, nums.length - 1);
        }
        return res;
    }

    private int startbinarySearch(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                if (mid == 0) {
                    return mid;
                } else if (nums[mid - 1] != target) {
                    return mid;
                } else {
                    j = mid - 1;
                }
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }

    private int endbinarySearch(int[] nums, int target, int i, int j) {
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (nums[mid] == target) {
                if (mid == nums.length - 1) {
                    return mid;
                } else if (nums[mid + 1] != target) {
                    return mid;
                } else {
                    i = mid + 1;
                }
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return -1;
    }
}
