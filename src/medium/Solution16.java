package medium;

import model.ListNode;

// 反转链表 II
public class Solution16 {

    private ListNode next;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseFirst(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseFirst(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }

        ListNode last = reverseFirst(head.next, n - 1);
        head.next.next = head;
        head.next = next;
        return last;
    }
}
