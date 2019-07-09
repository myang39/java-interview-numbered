import modules.TreeNode;

/**
 * Created by minkangyang on 21:56 Fri Jun, 2019
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 */
public class _20_ConstructBinarySearchTreeFromPreorderTraversal_1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return dfs(preorder, new int[1], null, null);
    }

    private TreeNode dfs(int[] preorder, int[] i, TreeNode lower, TreeNode upper) {
        if (i[0] == preorder.length) {
            return null;
        }
        int val = preorder[i[0]];
        // System.out.println(val);
        if ((lower != null && val <= lower.val) || (upper != null && val >= upper.val)) {
            // System.out.println("here");
            return null;
        }
        TreeNode root = new TreeNode(val);
        i[0]++;
        root.left = dfs(preorder, i, lower, root);
        root.right = dfs(preorder, i, root, upper);
        return root;
    }
}
