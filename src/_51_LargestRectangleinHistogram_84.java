import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by minkangyang on 10:07 Sat Jun, 2019
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class _51_LargestRectangleinHistogram_84 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(-1);
        Integer maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peekFirst() != -1 && heights[i] <= heights[stack.peekFirst()]) {
                maxarea = Math.max(maxarea, heights[stack.pollFirst()] * (i - stack.peekFirst() - 1));
            }
            stack.offerFirst(i);
        }
        while (stack.peekFirst() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pollFirst()] * (heights.length - stack.peekFirst() - 1));
        }
        return maxarea;
    }
}
