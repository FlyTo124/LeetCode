package medium;

import model.ListNode;

// 环形链表 II
public class Solution24 {

    public ListNode detectCycle(ListNode head) {
        boolean flag = false;
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        if(!flag)
            return null;
        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
