package medium;

import model.ListNode;

public class Solution03 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String vl1 = getValueFromNode(l1),
                vl2 = getValueFromNode(l2);
        long sum = (Long.parseLong(vl1.trim()) + Long.parseLong(vl2.trim()));
        String str = Long.toString(sum);
        char[] chars = str.trim().toCharArray();
        ListNode last = new ListNode(chars[0] - '0');
        for (int i = 1; i < chars.length; i++) {
            ListNode node = new ListNode(chars[i] - '0');
            node.next = last;
            last = node;
        }
        return last;
    }

    public String getValueFromNode(ListNode node) {
        if (node == null)
            return "";
        return getValueFromNode(node.next) + node.val;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        l11.next = l111;
        l1.next = l11;
        l22.next = l222;
        l2.next = l22;
//        l1.next = l2;
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.addTwoNumbers(l1, l2).val);
    }
}
