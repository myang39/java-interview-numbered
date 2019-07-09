import modules.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by minkangyang on 14:34 Sat Jun, 2019
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class _59_BinaryTreeZigzagLevelOrderTraversal_103 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {return lists;}
        Deque<TreeNode> q = new LinkedList<>();
        q.offerFirst(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new LinkedList<>();
            lists.add(list);
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.pollFirst();
                if (level % 2 == 0) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }
                if (cur.left != null) { q.offerLast(cur.left);}
                if (cur.right != null) {q.offerLast(cur.right);}
            }
            level++;
        }
        return lists;
    }
}
