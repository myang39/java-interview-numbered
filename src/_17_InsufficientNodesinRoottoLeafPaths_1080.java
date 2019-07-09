import modules.TreeNode;

/**
 * Created by minkangyang on 20:29 Fri Jun, 2019
 * https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
public class _17_InsufficientNodesinRoottoLeafPaths_1080 {
    public static void main(String[] args) {

    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return null;
        }
        if (!dfs(root, limit, 0)) {
            return null;
        }
        return root;
    }

    private boolean dfs (TreeNode root, long limit, long sum) {
        // sum += root.val;
        if(root == null) {
            return sum >= limit; // technically not correct
        }
        // if (root.left == null && root.right == null) {
        //     return sum + root.val >= limit;
        // } should be this one.

        boolean left = dfs(root.left, limit, sum + root.val);
        boolean right = dfs(root.right, limit, sum + root.val);

        if (left == false) {
            root.left = null;
        }
        if (right == false) {
            root.right = null;
        }

        return !(left == false && right == false);
    }
}
