import modules.TreeNode;

/**
 * Created by minkangyang on 19:45 Fri Jun, 2019
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class _1_FlatternBinaryTreeToLinkedList_114 {
    private TreeNode pre = null;
    public static void main(String[] args) {
        _1_FlatternBinaryTreeToLinkedList_114 sol = new _1_FlatternBinaryTreeToLinkedList_114();
        // todo create a tree here
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        flatten(left);
        flatten(right);
    }
}
