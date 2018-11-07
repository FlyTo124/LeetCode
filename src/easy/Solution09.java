package easy;

import model.ListNode;

public class Solution09 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);

        if (l1.val < l2.val){
            result.val = l1.val;
            result.next = mergeTwoLists(l1.next, l2);
        }else {
            result.val = l2.val;
            result.next =this.mergeTwoLists(l2.next, l1);
        }

        return result;

    }


}
