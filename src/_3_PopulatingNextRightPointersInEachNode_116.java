import modules.Node;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Created by minkangyang on 19:56 Fri Jun, 2019
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class _3_PopulatingNextRightPointersInEachNode_116 {
    public static void main(String[] args) {

    }
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node prev = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; // each level has (2^level) nodes
        int count = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            count ++;
            if (prev != null) {
                prev.next = cur;
            }

            if (count == Math.pow(2, level) ) {
                cur.next = null;
                prev = null;
                count = 0;
                level++;
            } else {
                prev = cur;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
