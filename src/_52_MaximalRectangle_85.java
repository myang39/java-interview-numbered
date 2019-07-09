import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by minkangyang on 10:08 Sat Jun, 2019
 * https://leetcode.com/problems/maximal-rectangle/
 */
public class _52_MaximalRectangle_85 {
    public static void main(String[] args) {

    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int maxarea = 0;
        int[] his = new int[n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                his[j] = (matrix[i][j] - '0') == 0 ? 0 : his[j] + (matrix[i][j] - '0');
            }
            maxarea = Math.max(maxarea, largestRectangleArea(his));
        }
        return maxarea;
    }

    private int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        stack.offerFirst(-1);
        Integer maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peekFirst() != -1 && heights[stack.peekFirst()] >= heights[i]) {
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
