import modules.ListNode;

/**
 * Created by minkangyang on 09:16 Sat Jun, 2019
 * https://leetcode.com/problems/reorder-list/
 */
public class _29_ReorderList_143 {
    public static void main(String[] args) {

    }
    public void reorderList(ListNode head) {
        // three steps
        // find the middle node and cut it's next off
        // reverse the second half
        // interleave the two linkedlists
        if (head == null || head.next == null) {
            return;
        }
        ListNode one = head;
        ListNode middle = findMiddle(head);
        ListNode two = middle.next;
        middle.next = null;
        two = reverse(two);
        head = interLeave(one, two);
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode interLeave(ListNode one, ListNode two) {
        ListNode head = one;
        ListNode cur = one;
        ListNode other = two;
        while(one != null && two != null) {
            ListNode one_next = one.next;
            one.next = two;
            one = two;
            two = one_next;
        }
        return head;
    }
}
