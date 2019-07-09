import modules.ListNode;
import modules.TreeNode;

/**
 * Created by minkangyang on 19:54 Fri Jun, 2019
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class _2_ConvertSortedListToBinarySearchTree_109 {
    public static void main(String[] args) {

    }

    private ListNode findMiddleElement(ListNode head) {
        // the pointer used to disconnect the left half from the mid node.
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        // Iterate until fastPtr doesn't reach the end of the linked list.
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // disconnect the left right and the right half;
        if (prevPtr != null) { // in case slowPtr is pointng to head;
            prevPtr.next = null;
        }

        return slowPtr;
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // find the mid node
        ListNode mid = findMiddleElement(head);

        // create root TreeNode for the mid node;
        TreeNode root = new TreeNode(mid.val);

        // if the mid is the only node left
        if (mid == head) {
            return root;
        }
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}
