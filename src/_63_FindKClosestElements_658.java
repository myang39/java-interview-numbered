import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 18:57 Mon Jul, 2019
 * https://leetcode.com/problems/find-k-closest-elements/
 */
public class _63_FindKClosestElements_658 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int k = 4;
        int x = 3;
        _63_FindKClosestElements_658 sol = new _63_FindKClosestElements_658();
        List<Integer> list = sol.findClosestElements(arr, k, x);
        System.out.println(list);
    }

    // my version
//    public List<Integer> findClosestElements(int[] arr, int k, int x) {
//        List<Integer> list = new ArrayList<>();
//        int closest = closest(arr, x);
//        int i = 0, j = 0;
//        if (arr[closest] <= x) {
//            i = closest;
//            j = i + 1;
//        } else {
//            j = closest;
//            i = j - 1;
//        }
//        while (k > 0) {
//            System.out.println(list);
//            if (i >= 0 && j < arr.length) {
//                if ( Math.abs(arr[i] - x) <= Math.abs(arr[j] - x) ) {
//                    list.add(0, arr[i--]);
//                } else {
//                    list.add(arr[j++]);
//                }
//            } else if (i >= 0) {
//                list.add(0, arr[i--]);
//            } else {
//                list.add(arr[j++]);
//            }
//            k--;
//        }
//        return list;
//    }
//
//    private int closest(int[] arr, int x) {
//        int i = 0, j = arr.length - 1;
//        while (i < j - 1) {
//            int mid = i + (j - i) / 2;
//            if (arr[mid] == x) {
//                return mid;
//            } else if (arr[mid] < x) {
//                i = mid + 1;
//            } else {
//                j = mid - 1;
//            }
//        }
//        if (Math.abs(arr[i] - x) > Math.abs(arr[j] - x)) {
//            return j;
//        } else {
//            return i;
//        }
//    }
    //

    // lai version
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        if (arr == null || arr.length == 0 || k == 0) {
            return list;
        }
        // left is the index of the largest smaller or equal element,
        // right = left + 1
        // These two should be the closest to target.
        int left = largestSmallerEqual(arr, x);
        int right = left + 1;
        // this is a typical merge operation
        for (int i = 0; i < k; i++) {
            // we can advance the left pointer when:
            // 1. right pointer is already out of bound
            // 2. right pointer is not out of bound, left pointer is not out of
            // bound, and arr[left] is closer to target.
            if (right >= arr.length || left >= 0
                && x - arr[left] <= arr[right] - x) {
                list.add(0, arr[left--]);
            } else {
                list.add(arr[right++]);
            }
        }
        return list;
    }

    private int largestSmallerEqual(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (arr[right] <= x) {
            return right;
        }
        if (arr[left] <= x) {
            return left;
        }
        // can not find...
        return -1;
    }

}
