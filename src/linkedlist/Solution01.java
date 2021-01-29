package linkedlist;

import model.ListNode;

// 删除链表
public class Solution01 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
