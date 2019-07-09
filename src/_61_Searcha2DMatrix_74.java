/**
 * Created by minkangyang on 20:24 Tue Jul, 2019
 * https://leetcode.com/problems/search-a-2d-matrix/
 */
public class _61_Searcha2DMatrix_74 {
    public static void main(String[] args) {

    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int i = 0, j = matrix.length * matrix[0].length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int r = mid / matrix[0].length;
            int c = mid % matrix[0].length;
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return false;
    }
}
