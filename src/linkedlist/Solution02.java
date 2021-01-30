package linkedlist;

import model.ListNode;

import java.util.LinkedList;
import java.util.List;

// 删除链表的倒数第N个节点
public class Solution02 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        List<ListNode> list = getNodes(head);
        if (n == 1) {
            ListNode node = list.get(list.size() - 2);
            node.next = null;
        } else {
            ListNode deleteNode = list.get(list.size() - n);
            deleteNode(deleteNode);
        }
        return head;
    }

    private void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private List<ListNode> getNodes(ListNode node) {
        List<ListNode> list = new LinkedList<>();
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        return list;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        node.next = node1;
        Solution02 solution02 = new Solution02();
        solution02.removeNthFromEnd(node, 1);
    }

}
