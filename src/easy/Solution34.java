package easy;

import model.ListNode;

// 链表中倒数第k个节点
public class Solution34 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast, slow;
        fast = slow = head;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
