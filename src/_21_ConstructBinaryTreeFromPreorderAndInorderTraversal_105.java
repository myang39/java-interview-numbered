import modules.TreeNode;

import java.util.HashMap;

/**
 * Created by minkangyang on 21:57 Fri Jun, 2019
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class _21_ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> in_hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in_hm.put(inorder[i], i);
        }
        return dfs(preorder, inorder, in_hm, new int[1], 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, HashMap<Integer, Integer> in_hm, int[] i, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[i[0]];
        TreeNode root = new TreeNode(val);
        int in_pos = in_hm.get(val);
        i[0]++;
        root.left = dfs(preorder, inorder, in_hm, i, left, in_pos - 1);
        root.right = dfs(preorder, inorder, in_hm, i, in_pos + 1, right);
        return root;
    }
}
