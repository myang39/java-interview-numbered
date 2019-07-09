import modules.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 20:25 Fri Jun, 2019
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */
public class _14_SerializeAndDeserializeBinaryTree_297 {
    public static void main(String[] args) {

    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    // Recursive serialization.
    private String rserialize(TreeNode root, String str) {
        // Recursive serialization
        if (root == null) {
            str += "null,";
        } else {
            str += String.valueOf((root.val)) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList<>(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    private TreeNode rdeserialize(List<String> l) {
        // Recursive deserialization
        if (l.get(0).equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);

        return root;
    }
}
