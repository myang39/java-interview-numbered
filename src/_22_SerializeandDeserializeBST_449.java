import modules.TreeNode;

import java.util.*;

/**
 * Created by minkangyang on 21:58 Fri Jun, 2019
 */
public class _22_SerializeandDeserializeBST_449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // just preorder would do the trick
        List<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        serializeHelper(root.left, list);
        serializeHelper(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] ss = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(ss));
        return deserializeHelper(queue, null, null);
    }

    private TreeNode deserializeHelper(Queue<String> queue, TreeNode lower, TreeNode upper) {
        if (queue.isEmpty()) {
            return null;
        }
        int val = Integer.valueOf(queue.peek());
        if ((lower != null && val <= lower.val) || (upper != null && val >= upper.val)) {
            return null;
        }
        queue.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(queue, lower, root);
        root.right = deserializeHelper(queue, root, upper);
        return root;
    }
}
