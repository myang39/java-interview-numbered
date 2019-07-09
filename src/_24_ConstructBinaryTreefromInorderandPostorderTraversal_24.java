import modules.TreeNode;

import java.util.HashMap;

/**
 * Created by minkangyang on 22:17 Fri Jun, 2019
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _24_ConstructBinaryTreefromInorderandPostorderTraversal_24 {
    public static void main(String[] args) {

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> in_hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in_hm.put(inorder[i], i);
        }
        int[] i = new int[]{postorder.length - 1};
        return dfs(inorder, postorder, i, in_hm, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int[] i, HashMap<Integer, Integer> in_hm, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = postorder[i[0]];
        int pos = in_hm.get(val);
        TreeNode root = new TreeNode(val);
        i[0] --;
        root.right = dfs(inorder, postorder, i, in_hm, pos + 1, right);
        root.left = dfs(inorder, postorder, i, in_hm, left, pos - 1);
        return root;
    }
}
