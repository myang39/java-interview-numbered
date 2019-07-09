import modules.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 20:03 Fri Jun, 2019
 * https://leetcode.com/problems/binary-tree-paths/
 */
public class _6_BinaryTreePaths_257 {
    public static void main(String[] args) {

    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new LinkedList<>();
        DFS(root, new StringBuilder(), paths);
        return paths;
    }

    private void DFS(TreeNode root, StringBuilder path, List<String> paths) {
        if (root == null) {
            return;
        }
        int length = path.length();
        path.append(root.val);
        if (root.left == null && root.right == null) {
            paths.add(path.toString());
        } else {
            path.append("->");
            DFS(root.left, path, paths);
            DFS(root.right, path, paths);
        }

        path.setLength(length);
    }
}
