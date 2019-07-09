import modules.TreeNode;

/**
 * Created by minkangyang on 20:09 Fri Jun, 2019
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class _9_CountCompleteTreeNodes_222 {
    public static void main(String[] args) {

    }
    public int countNodes(TreeNode root) {
        int count = 0;
        while (root != null) {
            int left = height(root.left);
            int right = height(root.right);
            if (left > right) {
                count = count + (int)(Math.pow(2, right + 1) - 1) + 1;
                root = root.left;
            } else {
                count = count + (int)(Math.pow(2, left + 1) - 1) + 1;
                root = root.right;
            }
        }
        return count;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return Math.max(height(root.left), height(root.left)) + 1;
    }
}
