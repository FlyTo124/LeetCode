package easy;

import model.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution18 {

    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null) return head;
        list.add(head.val);
        if (head.next != null) {
            this.dealNodes(head.next, head, list);
        }
        return head;
    }

    public void dealNodes(ListNode node, ListNode parentNode, List<Integer> list) {
        if (list.contains(node.val)) {
            if (node.next != null) {
                parentNode.next = node.next;
                this.dealNodes(node.next, parentNode, list);
            } else {
                parentNode.next = null;
            }
        } else {
            if (node.next != null) {
                list.add(node.val);
                this.dealNodes(node.next, node, list);
            }
        }

    }


}
